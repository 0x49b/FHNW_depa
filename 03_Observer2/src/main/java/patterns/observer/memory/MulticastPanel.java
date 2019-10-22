package patterns.observer.memory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// A panel with buttons to create and close sample frames.
@SuppressWarnings("serial")
public class MulticastPanel extends JPanel implements ActionListener {
    private int counter = 0;
    private JButton closeAllButton;

    public MulticastPanel() {
        JButton newButton = new JButton("New");
        this.add(newButton);
        newButton.addActionListener(this);

        closeAllButton = new JButton("Close all");
        this.add(closeAllButton);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {

        // 3. Check current heap size if possible for new window
        System.out.printf("current mem %d \n", Runtime.getRuntime().totalMemory());
        System.out.printf("max mem %d\n", Runtime.getRuntime().maxMemory());

        SimpleFrame f = new SimpleFrame();
        counter++;
        System.out.println(counter);
        f.setTitle("Window " + counter);
        f.setSize(250, 150);
        f.setVisible(true);
        closeAllButton.addActionListener(f);
    }

    private class SimpleFrame extends JFrame implements ActionListener {
        byte[][] buf = new byte[1024][];

        {
            for (int i = 0; i < 1024; i++) {
                buf[i] = new byte[1024 * 256];
            }
        }

        @Override
        public void actionPerformed(ActionEvent evt) {

            // 1.
            closeAllButton.removeActionListener(this);

            // 2.
            System.runFinalization();
            System.gc();


            this.dispose();
        }
    }
}

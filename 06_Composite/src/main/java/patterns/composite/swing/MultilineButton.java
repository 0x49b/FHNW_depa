package patterns.composite.swing;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

//source: http://www.javaspecialists.eu/archive/Issue041.html
public class MultilineButton {
	public static void main(String[] args) {
		JButton button = new JButton();
		button.setLayout(new GridLayout(0, 1));
		button.add(new JLabel("This is a", SwingConstants.CENTER));
		button.add(new JLabel("multiline", SwingConstants.CENTER));
		button.add(new JLabel("button.", SwingConstants.CENTER));
		JFrame f = new JFrame("Multi-line Button");
		f.setLayout(new FlowLayout());
		f.add(button);
		f.setSize(150, 150);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}

package patterns.observer.multimodel;

import java.awt.Color;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public class ColorModel {
	private int red, green, blue;

	public enum ColorChannel {
		RED, GREEN, BLUE
	}

	public ColorModel(Color c) {
		this.red = c.getRed();
		this.green = c.getGreen();
		this.blue = c.getBlue();
	}

	private final Map<ColorListener, EnumSet<ColorChannel>> listeners = new HashMap<>();

	// register a color listener for a set of channels, i.e. a subset of {RED,GREEN,BLUE}
	public void addColorListener(ColorListener l, EnumSet<ColorChannel> set) {
		listeners.put(l, set);
	}

	public void removeColorListener(ColorListener l) {
		listeners.remove(l);
	}

	public void setColor(Color c) {
		setRed(c.getRed());
		setGreen(c.getGreen());
		setBlue(c.getBlue());
	}

	public Color getColor() {
		return new Color(red, green, blue);
	}

	public void setRed(int red) {
		this.red = red;
		notifyListeners(ColorChannel.RED);
	}

	public void setGreen(int green) {
		this.green = green;
		notifyListeners(ColorChannel.GREEN);
	}

	public void setBlue(int blue) {
		this.blue = blue;
		notifyListeners(ColorChannel.BLUE);
	}

	private void notifyListeners(ColorChannel channel) {
		Color color = getColor();
		for (ColorListener l : new ArrayList<>(listeners.keySet())) {
			if (listeners.get(l).contains(channel))
				l.colorValueChanged(color);
		}
	}

}

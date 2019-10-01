package patterns.observer.color;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class ColorModel {
	private Color color = Color.BLACK;
	private final List<ColorListener> listeners = new ArrayList<>();

	public void addColorListener(ColorListener l) { listeners.add(l); }
	public void removeColorListener(ColorListener l) { listeners.remove(l); }

	public Color getColor() { return color; }

	public void setColor(Color newColor) {
		if (!color.equals(newColor)) {
			color = newColor;
			for (ColorListener l : listeners) {
				l.colorValueChanged(this, color);
			}
		}
	}
}

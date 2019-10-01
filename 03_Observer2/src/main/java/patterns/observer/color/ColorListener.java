package patterns.observer.color;

import java.awt.Color;

@FunctionalInterface
public interface ColorListener {
	void colorValueChanged(ColorModel source, Color newColor);
}

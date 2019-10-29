package patterns.clone;

import java.awt.Color;

public class ColorPoint extends Point {
	private Color color;

	public ColorPoint(int x, int y, Color c) {
		super(x, y);
		this.color = c;
	}

	@Override
	public ColorPoint clone() {
		return (ColorPoint) super.clone();
	}

	@Override
	public String toString() {
		return String.format("ColorPoint(%s, %s)", super.toString(), color);
	}
}
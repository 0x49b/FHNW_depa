package patterns.clone;

import java.awt.Color;

public class Test {
	public static void main(String[] args) {
		ColorPoint p1 = new ColorPoint(1, 2, Color.RED);
		ColorPoint p2 = p1.clone();

		System.out.println(p1);
		System.out.println(p2);
	}
}

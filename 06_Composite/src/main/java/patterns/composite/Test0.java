package patterns.composite;

public class Test0 {
	public static void main(String[] args) {
		Figure f1 = new OvalFigure("f1");
		Figure f2 = new OvalFigure("f2");
		Figure f3 = new RectangleFigure("f3");
		GroupFigure g1 = new GroupFigure("g1", f1, f2);
		GroupFigure g2 = new GroupFigure("g2", g1, f3);
		g2.draw("");
	}
}

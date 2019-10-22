package patterns.composite;

public class Test4 {
	public static void main(String[] args) {
		Figure f1 = new RectangleFigure("f1");
		Figure f2 = new RectangleFigure("f2");
		Figure f3 = new OvalFigure("f3");
		Figure f4 = new RectangleFigure("f4");
		Figure f5 = new RectangleFigure("f5");
		Figure f6 = new OvalFigure("f6");
		Figure f7 = new RectangleFigure("f7");

		GroupFigure g1 = new GroupFigure("g1", f1, f2);
		GroupFigure g2 = new GroupFigure("g2", g1, f3);
		GroupFigure g3 = new GroupFigure("g3", f4, f5);
		GroupFigure g4 = new GroupFigure("g4", g2, g3);
		GroupFigure g5 = new GroupFigure("g5", f6, g4, f7);

		g1.addFigure(g5);

		g1.draw("");
	}
}

package patterns.clone;

public class Point implements Cloneable {
	private int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public Point clone() {
		try {
			return (Point)super.clone();
		} catch (CloneNotSupportedException e) {
			throw new InternalError();
		}
	}

	@Override
	public String toString() {
		return String.format("Point(%d, %d)", x, y);
	}
}

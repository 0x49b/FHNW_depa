package patterns.clone.immutable;

import java.awt.*;

public class ImmutableLine implements Cloneable {
	private Point start, end;

	public ImmutableLine(Point start, Point end) {
		this.start = start;
		this.end = end;
	}

	public Point getStartPoint() {
		return (Point)start.clone();
	}


	public Point getEndPoint() {
		return (Point)end.clone();
	}


	@Override
	public ImmutableLine clone() {
		try {
			ImmutableLine p = (ImmutableLine) super.clone();
			p.start = (Point) start.clone();
			p.end = (Point) end.clone();
			return p;
		} catch (CloneNotSupportedException e) {
			throw new InternalError();
		}
	}

	@Override
	public String toString() {
		return String.format("Line[start=%s, end=%s]", start, end);
	}
}

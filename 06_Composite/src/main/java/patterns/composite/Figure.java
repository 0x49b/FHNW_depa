package patterns.composite;

public abstract class Figure {
	public Boolean contained = false;
	public abstract void draw(String prefix);
}

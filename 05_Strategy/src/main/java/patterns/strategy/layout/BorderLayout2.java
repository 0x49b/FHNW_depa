package patterns.strategy.layout;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.util.HashMap;
import java.util.Map;

public class BorderLayout2  implements LayoutManager {

	public static final String NORTH = "North";
	public static final String SOUTH = "South";
	public static final String EAST = "East";
	public static final String WEST = "West";
	public static final String CENTER = "Center";

	int hgap;
	int vgap;

	private final Map<Component, String> components = new HashMap<>();

	public BorderLayout2() { this(0, 0); }

	public BorderLayout2(int i, int j) {
		hgap = i;
		vgap = j;
	}

	@Override
	public void addLayoutComponent(String s, Component component) {
		/* Special case:  treat null the same as "Center". */
		if (s == null) {
		    s = "Center";
		}
		
		switch(s) {
		case "Center":
		case "North":
		case "South":
		case "East":
		case "West":
			components.put(component, s);
			break;
		default:
			throw new IllegalArgumentException("cannot add to layout: unknown constraint: " + s);
		}
	}

	@Override
	public void removeLayoutComponent(Component component) {
		components.remove(component);
	}

	@Override
	public Dimension minimumLayoutSize(Container container) {
		Dimension dimension = new Dimension(0, 0);
		Component component = null;
		if((component = getChild("East", container)) != null) {
			Dimension dimension1 = component.getMinimumSize();
			dimension.width += dimension1.width + hgap;
			dimension.height = Math.max(dimension1.height, dimension.height);
		}
		if((component = getChild("West", container)) != null) {
			Dimension dimension2 = component.getMinimumSize();
			dimension.width += dimension2.width + hgap;
			dimension.height = Math.max(dimension2.height, dimension.height);
		}
		if((component = getChild("Center", container)) != null) {
			Dimension dimension3 = component.getMinimumSize();
			dimension.width += dimension3.width;
			dimension.height = Math.max(dimension3.height, dimension.height);
		}
		if((component = getChild("North", container)) != null) {
			Dimension dimension4 = component.getMinimumSize();
			dimension.width = Math.max(dimension4.width, dimension.width);
			dimension.height += dimension4.height + vgap;
		}
		if((component = getChild("South", container)) != null) {
			Dimension dimension5 = component.getMinimumSize();
			dimension.width = Math.max(dimension5.width, dimension.width);
			dimension.height += dimension5.height + vgap;
		}
		Insets insets = container.getInsets();
		dimension.width += insets.left + insets.right;
		dimension.height += insets.top + insets.bottom;
		return dimension;
	}

	@Override
	public Dimension preferredLayoutSize(Container container)  {
		Dimension dimension = new Dimension(0, 0);
		Component component = null;
		if((component = getChild("East", container)) != null) {
			Dimension dimension1 = component.getPreferredSize();
			dimension.width += dimension1.width + hgap;
			dimension.height = Math.max(dimension1.height, dimension.height);
		}
		if((component = getChild("West", container)) != null) {
			Dimension dimension2 = component.getPreferredSize();
			dimension.width += dimension2.width + hgap;
			dimension.height = Math.max(dimension2.height, dimension.height);
		}
		if((component = getChild("Center", container)) != null) {
			Dimension dimension3 = component.getPreferredSize();
			dimension.width += dimension3.width;
			dimension.height = Math.max(dimension3.height, dimension.height);
		}
		if((component = getChild("North", container)) != null) {
			Dimension dimension4 = component.getPreferredSize();
			dimension.width = Math.max(dimension4.width, dimension.width);
			dimension.height += dimension4.height + vgap;
		}
		if((component = getChild("South", container)) != null) {
			Dimension dimension5 = component.getPreferredSize();
			dimension.width = Math.max(dimension5.width, dimension.width);
			dimension.height += dimension5.height + vgap;
		}
		Insets insets = container.getInsets();
		dimension.width += insets.left + insets.right;
		dimension.height += insets.top + insets.bottom;
		return dimension;
	}

	@Override
	public void layoutContainer(Container container) {
		Insets insets = container.getInsets();
		int i = insets.top;
		int j = container.getHeight() - insets.bottom;
		int k = insets.left;
		int l = container.getWidth() - insets.right;
		Component component = null;
		if((component = getChild("North", container)) != null) {
			component.setSize(l - k, component.getHeight());
			Dimension dimension = component.getPreferredSize();
			component.setBounds(k, i, l - k, dimension.height);
			i += dimension.height + vgap;
		}
		if((component = getChild("South", container)) != null) {
			component.setSize(l - k, component.getHeight());
			Dimension dimension1 = component.getPreferredSize();
			component.setBounds(k, j - dimension1.height, l - k, dimension1.height);
			j -= dimension1.height + vgap;
		}
		if((component = getChild("East", container)) != null) {
			component.setSize(component.getWidth(), j - i);
			Dimension dimension2 = component.getPreferredSize();
			component.setBounds(l - dimension2.width, i, dimension2.width, j - i);
			l -= dimension2.width + hgap;
		}
		if((component = getChild("West", container)) != null) {
			component.setSize(component.getWidth(), j - i);
			Dimension dimension3 = component.getPreferredSize();
			component.setBounds(k, i, dimension3.width, j - i);
			k += dimension3.width + hgap;
		}
		if((component = getChild("Center", container)) != null)
		component.setBounds(k, i, l - k, j - i);
	}

	private Component getChild(String s, Container container) {
		Component component = null;
		for(Component c : container.getComponents()) {
			if(s.equals(components.get(c))) {
				component = c; break;
			}
		}

		if (component != null && !component.isVisible())
			component = null;
		return component;
	}

}

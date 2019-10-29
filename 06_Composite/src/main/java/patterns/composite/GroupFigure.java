package patterns.composite;

import java.awt.*;
import java.util.*;
import java.util.List;

public class GroupFigure extends Figure {
    private String name;
    private List<Figure> figures = new LinkedList<>();

    public GroupFigure(String name, Figure... figures) {
        this.name = name;
        for (Figure f : figures) {
            addFigure(f);
        }
    }



    public void addFigure(Figure f) {
		if (f.contained) throw new IllegalArgumentException();
		f.contained = true;

		if(contains(f, this)) throw new IllegalArgumentException();
        figures.add(f);
    }




    private boolean contains(Figure g1, GroupFigure g2){
    	if (g1 == g2){
    		return true;
		} else if (g1 instanceof GroupFigure){
    		for(Figure f: ((GroupFigure) g1).figures){
    			if(contains(f, g2)){
    				return true;
				}
			}
		}

    	return false;
	}

/*

	void add(Component c){
    	// (1) - check
		if(c.parent != null) throw new IllegalArgumentException();
		// (2) - check
		if(c instanceof Composite){
			Composite comp = this;
			while( comp.parent != null ) comp=comp.parent;
			if(comp=c) throw new IllegalArgumentException();
		}
		c.parent = this;
		c.children.add(c);
	}
*/

    @Override
    public void draw(String prefix) {
        System.out.println(prefix + name);
        for (Figure f : figures) {
            f.draw(prefix + ">>");
        }
    }

}

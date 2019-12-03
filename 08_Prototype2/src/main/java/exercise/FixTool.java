package exercise;

import java.util.HashMap;
import java.util.Map;

public class FixTool {

    public FixTool(){};
    private static Map<Figure, Boolean> fixedFigures = new HashMap<>();


    public static void toggleFixFigure(Figure f){
        if(fixedFigures.containsKey(f)){
            fixedFigures.get(f);
        }
    }

}

package patterns.observer.javafx;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Test1 {
	public static void main(String[] args) {
		StringProperty prop = new SimpleStringProperty("p1");

		prop.addListener(observable -> {
			System.out.println("observable was invalidated "
					// + "new value: " + ((StringProperty)observable).getValue()
			);
		});
		
		prop.setValue("p2");
		prop.setValue("p3");
		prop.setValue("p4");
		
		System.out.println(prop.getValue());
		
		prop.setValue("p5");
		prop.setValue("p5");
		prop.setValue("p5");

	}
}

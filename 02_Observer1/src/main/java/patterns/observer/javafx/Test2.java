package patterns.observer.javafx;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Test2 {
	public static void main(String[] args) {
		StringProperty prop = new SimpleStringProperty("p1");

		prop.addListener((observable, oldValue, newValue) -> {
			System.out.printf("value changed from %s to %s\n", oldValue, newValue);
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

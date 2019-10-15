package patterns.strategy.date;

public class StdPrintDate implements PrintDate {
	@Override
	public void print(Date d) {
		System.out.println("Date: " + d.day + "." + d.month + "." + d.year);
	}
}

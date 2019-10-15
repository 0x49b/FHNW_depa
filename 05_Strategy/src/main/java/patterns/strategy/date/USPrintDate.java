package patterns.strategy.date;

public class USPrintDate implements PrintDate {
	@Override
	public void print(Date d) {
		System.out.println("Date: " + d.month + "/" + d.day + "/" + d.year);
	}
}

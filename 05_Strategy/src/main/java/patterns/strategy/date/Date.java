package patterns.strategy.date;

import java.time.LocalDate;

public class Date {
	int day, month, year;
	private final PrintDate p; // algorithm which defines how to format and print a date

	public Date(PrintDate p) {
		this.p = p;
	}

	public void print() {
		p.print(this);
	}

	public static void main(String[] args) throws Exception {
		PrintDate printer = (PrintDate) Class.forName(args[0]).getDeclaredConstructor().newInstance();
		Date d = new Date(printer);

		LocalDate today = LocalDate.now();
		d.day = today.getDayOfMonth();
		d.month = today.getMonthValue();
		d.year = today.getYear();

		d.print();
	}
}

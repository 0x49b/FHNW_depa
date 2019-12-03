package patterns.clone.comparison;

public class CompareCopyStrategies {
	private static final int SIZE = 10000;
	private static final int NOFCLONES = 1000;

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		double referenceTime = measure(new Dictionary("german", SIZE));
	}

	private static double measure(Dictionary dict) {
		long start = System.currentTimeMillis();

		System.out.print("------------> ORIGINAL ");
		System.out.println(dict);

		System.out.println("------------> CLONES");

		for (int i = 0; i < NOFCLONES; i++) {
			System.out.println(dict.clone());
		}
		long end = System.currentTimeMillis();
		double t = (end - start) / 1000.0;
		System.out.println("Time used: " + t);
		return t;
	}
}

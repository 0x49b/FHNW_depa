package patterns.observer.list;

public class ObserverTest {
	
	public static void main(String[] args) {
		ObservableList<Integer> list = new ObservableList<>();

		ConsoleObserver co = new ConsoleObserver();
		AdderObserver ao = new AdderObserver();
		
		list.addListener(co);
		list.addListener(ao);

		list.add(17);
		list.add(42);
		
		printList(list);
		
		list.remove(17);
		list.remove(18);
	}
	
	private static void printList(ObservableList<Integer> list) {
		System.out.print("[ ");
		for (int x : list.toArray(new Integer[list.size()])) {
			System.out.print(x + " ");
		}
		System.out.println("]");
	}

}

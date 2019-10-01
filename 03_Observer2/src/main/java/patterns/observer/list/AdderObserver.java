package patterns.observer.list;

public class AdderObserver implements Observer {

	@Override
	public void update(Observable source) {
		@SuppressWarnings("unchecked")
		ObservableList<Integer> list = (ObservableList<Integer>) source;

		int sum = 0;
		for (int n : list.toArray(new Integer[list.size()])) {
			sum += n;
		}

		System.out.println("AdderObserver: new sum is " + sum);
	}

}

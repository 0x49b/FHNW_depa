package patterns.observer.list;

public class ConsoleObserver implements Observer {

	@Override
	public void update(Observable source) {
		System.out.println("ConsoleObserver: List has changed");
	}

}

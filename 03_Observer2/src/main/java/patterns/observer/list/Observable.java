package patterns.observer.list;

import java.util.ArrayList;
import java.util.List;

public class Observable {
	private final List<Observer> observers = new ArrayList<Observer>();

	public void addListener(Observer o) {
		observers.add(o);
	}

	public void removeListener(Observer o) {
		observers.remove(o);
	}

	protected void notifyObservers() {
		for (Observer obs : observers) {
			obs.update(this);
		}
	}
}

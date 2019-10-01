package patterns.observer.cycle;

import java.util.ArrayList;
import java.util.List;

public class Observable {
	private final List<Observer> observers = new ArrayList<Observer>();

	public void addObserver(Observer o) {
		observers.add(o);
	}

	public void removeObserver(Observer o) {
		observers.remove(o);
	}

	protected void notifyObservers(Object arg) {
		for (Observer obs : observers) {
			obs.update(this, arg);
		}
	}
}

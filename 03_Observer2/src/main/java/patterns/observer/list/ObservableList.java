package patterns.observer.list;

import java.util.ArrayList;
import java.util.List;

public class ObservableList<E> extends Observable {
	private final List<E> list = new ArrayList<E>();

	public boolean add(E e) {
		boolean res = list.add(e);
		if(res) notifyObservers();
		return res;
	}

	public boolean remove(Object o) {
		boolean res = list.remove(o);
		if(res) notifyObservers();
		return res;
	}

	public E get(int index) {
		return list.get(index);
	}

	public Object[] toArray() {
		return list.toArray();
	}

	public <T> T[] toArray(T[] a) {
		return list.toArray(a);
	}

	public int size() {
		return list.size();
	}
}

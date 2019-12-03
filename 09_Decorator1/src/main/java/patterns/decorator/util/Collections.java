package patterns.decorator.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Collections<UnmodifiableIterator> {

	public static <T> Collection<T> unmodifiableCollection(Collection<T> c) {
		return new UnmodifiableCollection(c);
	}

	static class UnmodifiableCollection<T> implements Collection<T>{
		private Collection<T> inner;

		public UnmodifiableCollection(Collection<T> c){
			this.inner = c;
		}

		@Override
		public int size() {
			return inner.size();
		}

		@Override
		public boolean isEmpty() {
			return inner.isEmpty();
		}

		@Override
		public boolean contains(Object o) {
			return inner.contains(o);
		}

		@Override
		public Iterator<T> iterator() {
			return inner.iterator();
		}

		class IteratorDecorator {

			private Iterator<T> inner;
			public IteratorDecorator(Iterator<T> t){
				this.inner = t;
			}

			public boolean hasNext() {
				return inner.hasNext();
			}

			public T next() {
				return inner.next();
			}

			public void remove() {
				throw new UnsupportedOperationException();
			}

			public void forEachRemaining(Consumer<? super T> action) {
				inner.forEachRemaining(action);
			}
		}


		@Override
		public Object[] toArray() {
			return inner.toArray();
		}

		@Override
		public <T1> T1[] toArray(T1[] a) {
			return inner.toArray(a);
		}

		@Override
		public <T1> T1[] toArray(IntFunction<T1[]> generator) {
			return inner.toArray(generator);
		}

		@Override
		public boolean add(T t) {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean remove(Object o) {
			throw new UnsupportedOperationException();
		}


		@Override
		public boolean containsAll(Collection<?> c) {
			return inner.containsAll(c);
		}

		@Override
		public boolean addAll(Collection<? extends T> c) {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean removeAll(Collection<?> c) {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean removeIf(Predicate<? super T> filter) {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean retainAll(Collection<?> c) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void clear() {
			throw new UnsupportedOperationException();
		}

/*		@Override
		public boolean equals(Object o) {
			return inner.equals(o);
		}*/

		@Override
		public int hashCode() {
			return inner.hashCode();
		}

		@Override
		public Spliterator<T> spliterator() {
			return inner.spliterator();
		}

		@Override
		public Stream<T> stream() {
			return inner.stream();
		}

		@Override
		public Stream<T> parallelStream() {
			return inner.parallelStream();
		}

		@Override
		public void forEach(Consumer<? super T> action) {
			inner.forEach(action);
		}
	}


}

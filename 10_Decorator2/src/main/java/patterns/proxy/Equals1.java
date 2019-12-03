package patterns.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Equals1 {
	
	static interface Figure {}

	static class Rectangle implements Figure {
		private int w, h;

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Rectangle) {
				return ((Rectangle) obj).w == w && ((Rectangle) obj).h == h;
			}
			if (obj instanceof Figure)
				return obj.equals(this);
			else
				return false;
		}
	}
	
	private static final class LoggingHandler implements InvocationHandler {
		private final Object target;
		private LoggingHandler(Object target) { this.target = target; }
		
		@Override
		public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
			// Logging
			return m.invoke(target, args);
		}
	}

	public static void main(String[] args) {
		Figure f1 = new Rectangle();
		Figure f2 =  (Figure) Proxy.newProxyInstance(
			Figure.class.getClassLoader(),
			new Class[] { Figure.class }, 
			new LoggingHandler(f1)
		);
		Figure f3 =  (Figure) Proxy.newProxyInstance(
				Figure.class.getClassLoader(),
				new Class[] { Figure.class }, 
				new LoggingHandler(f2)
			);
		Figure f4 =  (Figure) Proxy.newProxyInstance(
				Figure.class.getClassLoader(),
				new Class[] { Figure.class }, 
				new LoggingHandler(f1)
			);
		
		System.out.println(f1.equals(f1));
		System.out.println(f2.equals(f1));
		System.out.println(f3.equals(f1));
		System.out.println(f4.equals(f1));
		
		System.out.println(f1.equals(f2));
		System.out.println(f2.equals(f2));
		System.out.println(f3.equals(f2));
		System.out.println(f4.equals(f2));
		
		System.out.println(f1.equals(f3));
		System.out.println(f2.equals(f3));
		System.out.println(f3.equals(f3));
		System.out.println(f4.equals(f3));
		
		System.out.println(f1.equals(f4));
		System.out.println(f2.equals(f4));
		System.out.println(f3.equals(f4));
		System.out.println(f4.equals(f4));
	}
	
}
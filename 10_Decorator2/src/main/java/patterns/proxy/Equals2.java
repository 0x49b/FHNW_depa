package patterns.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Equals2 {
	
	static interface Figure {}

	static class Rectangle implements Figure {
		private int w, h;

		@Override
		public boolean equals(Object obj) {
			return (obj instanceof Rectangle) && 
				 ((Rectangle) obj).w == w && ((Rectangle) obj).h == h;
		}
	}
	
	private static final class LoggingHandler implements InvocationHandler {
		private static final Method OBJECT_EQUALS = getObjectMethod("equals", Object.class);
	        
		private final Object target;
		private LoggingHandler(Object target) { this.target = target; }
		
		@Override
		public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
			// Logging
			if (OBJECT_EQUALS.equals(m)) {
				return equalsInternal(proxy, args[0]);
			} else {
				return m.invoke(target, args);
			}
		}
		
		private boolean equalsInternal(Object proxy, Object other) {
            if (other == null || other.getClass() != proxy.getClass()) {
                return target.equals(other);
            }
            InvocationHandler handler = Proxy.getInvocationHandler(other);
            return proxy.equals(((LoggingHandler) handler).target);
//            return ((LoggingHandler) handler).target.equals(target);
//            return ((LoggingHandler) handler).target.equals(target)
//              || ((LoggingHandler) handler).target.equals(proxy)
//              || other.equals(target);
        }
		 
		private static Method getObjectMethod(String name, Class<?>... types) {
			try {
				return Object.class.getMethod(name, types);
			} catch (NoSuchMethodException e) {
				throw new IllegalArgumentException(e);
			}
		}
	}

	
	public static void main(String[] args) {
		Figure f1 = new Rectangle();
		Figure f2 =  (Figure) Proxy.newProxyInstance(
			Figure.class.getClassLoader(),
			new Class[] { Figure.class }, 
			new LoggingHandler(f1)
		);
		
		System.out.println(f1.equals(f2));
		System.out.println(f2.equals(f1));
	}
	
}
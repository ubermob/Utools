package utools.listener;

/**
 * @author Andrey Korneychuk on 12-Apr-22
 * @version 1.0
 */
public class DefaultListeners {

	public static InfoListener defaultInfoListener;
	public static ExceptionListener defaultExceptionListener;

	public static InfoListener getDefaultInfoListener() {
		if (defaultInfoListener == null) {
			defaultInfoListener = new SoutInfoListenerImpl();
		}
		return defaultInfoListener;
	}

	public static ExceptionListener getDefaultExceptionListener() {
		if (defaultExceptionListener == null) {
			defaultExceptionListener = new SoutExceptionListenerImpl();
		}
		return defaultExceptionListener;
	}
}
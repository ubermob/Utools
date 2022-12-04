package utools.listener;

/**
 * @author Andrey Korneychuk on 12-Apr-22
 * @version 1.0
 */
public class SoutExceptionListenerImpl implements ExceptionListener {

	@Override
	public void add(String message, Exception exception) {
		synchronized (this) {
			System.out.println(message);
			exception.printStackTrace();
		}
	}
}
package utools.listener;

/**
 * @author Andrey Korneychuk on 12-Apr-22
 * @version 1.0
 */
public class SoutInfoListenerImpl implements InfoListener {

	@Override
	public void add(String message) {
		synchronized (this) {
			System.out.println(message);
		}
	}
}
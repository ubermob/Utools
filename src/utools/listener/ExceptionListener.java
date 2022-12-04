package utools.listener;

/**
 * @author Andrey Korneychuk on 12-Apr-22
 * @version 1.0
 */
public interface ExceptionListener {

	void add(String message, Exception exception);
}
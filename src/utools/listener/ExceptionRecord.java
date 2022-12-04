package utools.listener;

/**
 * @author Andrey Korneychuk on 12-Apr-22
 * @version 1.0
 */
public class ExceptionRecord {

	private final String message;
	private final Exception exception;

	public ExceptionRecord(String message, Exception exception) {
		this.message = message;
		this.exception = exception;
	}

	public String getMessage() {
		return message;
	}

	public Exception getException() {
		return exception;
	}
}
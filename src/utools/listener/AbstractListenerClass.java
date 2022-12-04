package utools.listener;

/**
 * @author Andrey Korneychuk on 12-Apr-22
 * @version 1.0
 */
public abstract class AbstractListenerClass {

	protected InfoListener infoListener;
	protected ExceptionListener exceptionListener;

	public AbstractListenerClass() {
		infoListener = DefaultListeners.getDefaultInfoListener();
		exceptionListener = DefaultListeners.getDefaultExceptionListener();
	}

	public InfoListener getInfoListener() {
		return infoListener;
	}

	public void setInfoListener(InfoListener infoListener) {
		this.infoListener = infoListener;
	}

	public ExceptionListener getExceptionListener() {
		return exceptionListener;
	}

	public void setExceptionListener(ExceptionListener exceptionListener) {
		this.exceptionListener = exceptionListener;
	}
}
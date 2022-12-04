package utools.stringtools;

/**
 * @author Andrey Korneychuk on 20-Nov-22
 * @version 1.0
 */
public class WindowsFileName extends AbstractFileName {

	public WindowsFileName() {
		unacceptableChars = UnacceptableSymbolReplacer.WINDOWS_CHARS;
	}
}
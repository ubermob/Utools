package utools.stringtools;

/**
 * @author Andrey Korneychuk on 04-Dec-22
 * @version 1.0
 */
public class WebAndWindowsFileName extends AbstractFileName {

	public WebAndWindowsFileName() {
		int length = UnacceptableSymbolReplacer.WEB_CHARS.length + UnacceptableSymbolReplacer.WINDOWS_CHARS.length;
		unacceptableChars = new String[length];
		int index = 0;
		for (int i = 0; i < UnacceptableSymbolReplacer.WEB_CHARS.length; i++) {
			unacceptableChars[index++] = UnacceptableSymbolReplacer.WEB_CHARS[i];
		}
		for (int i = 0; i < UnacceptableSymbolReplacer.WINDOWS_CHARS.length; i++) {
			unacceptableChars[index++] = UnacceptableSymbolReplacer.WINDOWS_CHARS[i];
		}
	}

	public String[] getArray() {
		return unacceptableChars;
	}
}
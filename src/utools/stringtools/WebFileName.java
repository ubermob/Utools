package utools.stringtools;

/**
 * @author Andrey Korneychuk on 20-Nov-22
 * @version 1.0
 */
public class WebFileName extends AbstractFileName {

	public WebFileName() {
		unacceptableChars = UnacceptableSymbolReplacer.WEB_CHARS;
	}
}
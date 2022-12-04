package utools.stringtools;

/**
 * Replace unacceptable Windows and web file name chars.
 */
public class UnacceptableSymbolReplacer {

	public static final String[] WINDOWS_CHARS = {"\\", "/", ":", "*", "?", "\"", "<", ">", "|"}; // Size == 9
	public static final String[] WEB_CHARS = {"#", "%", "&", "{", "}", "\\", "<", ">", "*", "?", "/", " ", "$"
			, "!", "'", "\"", ":", "@", "+", "`", "|", "="}; // size == 22

	private static WindowsFileName windowsFileName;
	private static WebFileName webFileName;
	private static WebAndWindowsFileName webAndWindowsFileName;

	/**
	 * Class containing unacceptable symbols for Windows OS.
	 *
	 * @return {@link WindowsFileName} singleton
	 */
	public static WindowsFileName getWindowsFileName() {
		if (windowsFileName == null) {
			windowsFileName = new WindowsFileName();
		}
		return windowsFileName;
	}

	/**
	 * Class containing unacceptable symbols for Web.
	 *
	 * @return {@link WebFileName} singleton
	 */
	public static WebFileName getWebFileName() {
		if (webFileName == null) {
			webFileName = new WebFileName();
		}
		return webFileName;
	}

	/**
	 * Class containing unacceptable symbols for Web and Windows OS.
	 *
	 * @return {@link WebAndWindowsFileName} singleton
	 */
	public static WebAndWindowsFileName getWebAndWindowsFileName() {
		if (webAndWindowsFileName == null) {
			webAndWindowsFileName = new WebAndWindowsFileName();
		}
		return webAndWindowsFileName;
	}
}
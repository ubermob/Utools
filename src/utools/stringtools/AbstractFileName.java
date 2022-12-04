package utools.stringtools;

/**
 * @author Andrey Korneychuk on 20-Nov-22
 * @version 1.0
 */
public abstract class AbstractFileName {

	protected String[] unacceptableChars;

	/**
	 * Remove unacceptable symbols in string.
	 *
	 * @param input {@link String} File name
	 * @return replaced {@link String}
	 */
	public String replace(String input) {
		return replace(input, "");
	}

	/**
	 * Replace unacceptable symbols in string.
	 *
	 * @param input       {@link String} File name
	 * @param replacement replacement string
	 * @return replaced {@link String}
	 */
	public String replace(String input, String replacement) {
		for (String s : unacceptableChars) {
			input = input.replace(s, replacement);
		}
		return input;
	}

	/**
	 * Remove unacceptable symbols in string.
	 *
	 * @param input {@link String} File name
	 * @return replaced {@link String}
	 */
	public String remove(String input) {
		return replace(input);
	}

	/**
	 * Check acceptable char.
	 *
	 * @param c char for check
	 * @return true if char is acceptable else false
	 */
	public boolean isAcceptable(char c) {
		return !isUnacceptable(c);
	}

	/**
	 * Check unacceptable char.
	 *
	 * @param c char for check
	 * @return true if char is not acceptable else false
	 */
	public boolean isUnacceptable(char c) {
		for (String s : unacceptableChars) {
			if (s.charAt(0) == c) {
				return true;
			}
		}
		return false;
	}
}
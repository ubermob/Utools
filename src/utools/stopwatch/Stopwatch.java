package utools.stopwatch;

/**
 * Primitive stopwatch. Start with realize constructor.
 *
 * @author Andrey Korneychuk
 * @version 1.0
 */
public class Stopwatch {

	private static final String DEFAULT_FORMAT = "%d ms";

	private long time;
	private String format = getDefaultFormat();

	/**
	 * Constructor with default format
	 */
	public Stopwatch() {
		time = System.currentTimeMillis();
	}

	/**
	 * Constructor with user format
	 *
	 * @param format new format
	 */
	public Stopwatch(String format) {
		this.format = format;
		time = System.currentTimeMillis();
	}

	/**
	 * Print to console formatted string.
	 * Invoke {@code getPrettyString()} method.
	 */
	public void print() {
		System.out.println(getPrettyString());
	}

	/**
	 * @return start time as millis
	 */
	public long getStartTime() {
		return time;
	}

	/**
	 * @return formatted string
	 */
	public String getPrettyString() {
		return String.format(format, System.currentTimeMillis() - time);
	}

	/**
	 * @return format string
	 */
	public String getFormat() {
		return format;
	}

	/**
	 * Set new format string. Must contain "%d".
	 *
	 * @param format new format
	 */
	public void setFormat(String format) {
		this.format = format;
	}

	/**
	 * @return default format
	 */
	public String getDefaultFormat() {
		return DEFAULT_FORMAT;
	}

	/**
	 * Reset current format to default.
	 */
	public void resetFormat() {
		format = getDefaultFormat();
	}

	/**
	 * Reset stopwatch.
	 */
	public void reset() {
		time = System.currentTimeMillis();
	}

	/**
	 * Append string to current format before existing statement.
	 *
	 * @param string appended format
	 */
	public void appendBefore(String string) {
		format = string + format;
	}

	/**
	 * Append string to current format after existing statement.
	 *
	 * @param string appended format
	 */
	public void appendAfter(String string) {
		format += string;
	}

	/**
	 * Return internal state of object.
	 *
	 * @return internal state
	 */
	@Override
	public String toString() {
		return "Stopwatch{" + "time=" + time + ", format='" + format + '\'' + '}';
	}
}
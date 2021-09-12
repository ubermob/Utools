package utools.stopwatch;

import java.io.IOException;
import java.util.Properties;

/**
 * Primitive stopwatch.
 * Start measure time as millis with realize constructor.
 *
 * @author Andrey Korneychuk
 * @version 1.2
 */
public class Stopwatch {

	protected static final Properties properties;
	private static final String DEFAULT_FORMAT;

	static {
		properties = new Properties();
		try {
			properties.load(Stopwatch.class.getResourceAsStream("/Stopwatch_properties.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		DEFAULT_FORMAT = properties.getProperty("stopwatch.default_format");
	}

	private long startTime;
	private String format = getDefaultFormat();

	/**
	 * @return default format
	 */
	public static String getDefaultFormat() {
		return DEFAULT_FORMAT;
	}

	/**
	 * Constructor with default format
	 */
	public Stopwatch() {
		startTime = System.currentTimeMillis();
	}

	/**
	 * Constructor with user format
	 *
	 * @param format new format
	 */
	public Stopwatch(String format) {
		this.format = format;
		startTime = System.currentTimeMillis();
	}

	/**
	 * Protected cloning constructor.
	 *
	 * @param time   original object time in millis
	 * @param format original format
	 */
	protected Stopwatch(long time, String format) {
		this.format = format;
		this.startTime = time;
	}

	/**
	 * Print to console formatted string.
	 * Invoke {@code getPrettyString()} method.
	 */
	public void print() {
		System.out.println(getPrettyString());
	}

	/**
	 * @return start millis
	 */
	public long getStartTime() {
		return startTime;
	}

	/**
	 * @return formatted string with millis elapsed from start
	 */
	public String getPrettyString() {
		return String.format(format, getElapsedTime());
	}

	/**
	 * @return format
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
	 * Reset current format to default.
	 */
	public void resetFormat() {
		format = getDefaultFormat();
	}

	/**
	 * Reset stopwatch.
	 */
	public void reset() {
		startTime = System.currentTimeMillis();
	}

	/**
	 * Append string to current format before existing format.
	 *
	 * @param string appended format
	 */
	public void appendBefore(String string) {
		format = string + format;
	}

	/**
	 * Append string to current format after existing format.
	 *
	 * @param string appended format
	 */
	public void appendAfter(String string) {
		format += string;
	}

	/**
	 * Return internal state of object as string.
	 *
	 * @return internal state
	 */
	@Override
	public String toString() {
		return "Stopwatch{" + "startTime=" + startTime + ", format='" + format + '\'' + '}';
	}

	/**
	 * @return stopwatch clone
	 */
	@Override
	public Stopwatch clone() {
		return new Stopwatch(startTime, format);
	}

	/**
	 * @return current millis elapsed from start
	 */
	public long getElapsedTime() {
		return System.currentTimeMillis() - startTime;
	}
}
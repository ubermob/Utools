package utools.stopwatch;

import java.util.Arrays;

/**
 * Primitive stopwatch. Start measure time as millis with realize constructor.
 * Output time from hours to millis.
 *
 * @author Andrey Korneychuk on 12-Sep-21
 * @version 1.0
 */
public class ExtendedStopwatch extends Stopwatch {

	private static final String[] DEFAULT_FORMAT;

	static {
		DEFAULT_FORMAT = new String[]{
				properties.getProperty("extended_stopwatch.default_format_h"),
				properties.getProperty("extended_stopwatch.default_format_m"),
				properties.getProperty("extended_stopwatch.default_format_s"),
				properties.getProperty("stopwatch.default_format")
		};
	}

	private String[] format;
	private boolean isMillisPresence;
	private String beforeFormat, afterFormat;

	/**
	 * Constructor with default format.
	 */
	public ExtendedStopwatch() {
		super();
		format = DEFAULT_FORMAT;
		isMillisPresence = true;
	}

	/**
	 * Constructor with default format.
	 *
	 * @param isMillisPresence presence millis to output
	 */
	public ExtendedStopwatch(boolean isMillisPresence) {
		super();
		format = DEFAULT_FORMAT;
		this.isMillisPresence = isMillisPresence;
	}

	/**
	 * Constructor with user formats:
	 * - before format
	 * - after format.
	 *
	 * @param beforeFormat new format
	 * @param afterFormat  new format
	 */
	public ExtendedStopwatch(String beforeFormat, String afterFormat) {
		super();
		format = DEFAULT_FORMAT;
		isMillisPresence = true;
		this.beforeFormat = beforeFormat;
		this.afterFormat = afterFormat;
	}

	/**
	 * Constructor with user formats:
	 * - before format
	 * - after format.
	 *
	 * @param isMillisPresence presence millis to output
	 * @param beforeFormat     new format
	 * @param afterFormat      new format
	 */
	public ExtendedStopwatch(boolean isMillisPresence, String beforeFormat, String afterFormat) {
		super();
		format = DEFAULT_FORMAT;
		this.isMillisPresence = isMillisPresence;
		this.beforeFormat = beforeFormat;
		this.afterFormat = afterFormat;
	}

	/**
	 * Protected cloning constructor.
	 *
	 * @param stopwatchTime    original object time in millis
	 * @param stopwatchFormat  original format
	 * @param isMillisPresence original millis presence
	 */
	protected ExtendedStopwatch(long stopwatchTime,
	                            String stopwatchFormat,
	                            boolean isMillisPresence,
	                            String beforeFormat,
	                            String afterFormat) {
		super(stopwatchTime, stopwatchFormat);
		format = DEFAULT_FORMAT;
		this.isMillisPresence = isMillisPresence;
		this.beforeFormat = beforeFormat;
		this.afterFormat = afterFormat;
	}

	/**
	 * Print to console formatted string.
	 * Invoke {@code getPrettyString()} method.
	 */
	@Override
	public void print() {
		System.out.println(getPrettyString());
	}

	/**
	 * @return formatted string with time elapsed from start
	 */
	@Override
	public String getPrettyString() {
		long elapsedTime = super.getElapsedTime();
		int hours = (int) elapsedTime / (60 * 60 * 1000);
		int minutes = (int) elapsedTime / (60 * 1000) - hours * 60;
		int seconds = (int) elapsedTime / 1000 - hours * 60 * 60 - minutes * 60;
		int millis = (int) elapsedTime % 1000;
		int[] time = {hours, minutes, seconds};
		StringBuilder stringBuilder = new StringBuilder();
		if (beforeFormat != null) {
			stringBuilder.append(beforeFormat);
		}
		for (int i = 0; i < time.length; i++) {
			if (time[i] != 0) {
				stringBuilder.append(String.format(format[i], time[i]));
				stringBuilder.append(" ");
			}
		}
		if (isMillisPresence) {
			stringBuilder.append(String.format(format[3], millis));
		}
		if (afterFormat != null) {
			stringBuilder.append(afterFormat);
		}
		return stringBuilder.toString();
	}

	/**
	 * @return format of extended stopwatch
	 */
	public String[] getExtendedFormat() {
		return format;
	}

	/**
	 * Set new extended format array of string extended stopwatch.
	 * Must contain array with 4th string with "%d" format literal.
	 *
	 * @param format new format
	 */
	public void setExtendedFormat(String[] format) {
		this.format = format;
	}

	/**
	 * Reset current format of extended stopwatch to default.
	 */
	public void resetExtendedFormat() {
		format = DEFAULT_FORMAT;
	}

	/**
	 * Append string to current format before existing extended format.
	 *
	 * @param string appended format
	 */
	@Override
	public void appendBefore(String string) {
		beforeFormat = string;
	}

	/**
	 * Append string to current format after existing extended format.
	 *
	 * @param string appended format
	 */
	@Override
	public void appendAfter(String string) {
		afterFormat = string;
	}

	/**
	 * Return internal state of object as string.
	 *
	 * @return internal state
	 */
	@Override
	public String toString() {
		String parent = super.toString();
		String current = "ExtendedStopwatch{" +
				"format=" + Arrays.toString(format) +
				", isMillisPresence=" + isMillisPresence +
				", beforeFormat='" + beforeFormat + '\'' +
				", afterFormat='" + afterFormat + '\'' +
				'}';
		return parent + "\n" + current;
	}

	/**
	 * Toggle millis presence.
	 */
	public void toggleMillisPresence() {
		isMillisPresence = !isMillisPresence;
	}

	/**
	 * @return extend stopwatch clone
	 */
	@Override
	public ExtendedStopwatch clone() {
		return new ExtendedStopwatch(super.getStartTime(), super.getFormat(),
				isMillisPresence, beforeFormat, afterFormat);
	}
}
package utools.exceptiontools;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * @author Andrey Korneychuk on 22-Apr-22
 * @version 1.0
 */
public class ExceptionToString {

	/**
	 * Get {@link Exception} as {@link String}.
	 *
	 * @param exception
	 * @return Exception as string
	 */
	public static String getAsString(Exception exception) {
		// https://stackoverflow.com/questions/10120709/difference-between-printstacktrace-and-tostring
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(byteArrayOutputStream);
		exception.printStackTrace(printStream);
		printStream.close();
		return byteArrayOutputStream.toString();
	}
}
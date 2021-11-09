package utools.propertiestools;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * Get or fill existing {@link Properties} from simple *.txt file.
 * Class realize reading UTF-8 characters.
 * Default line spliterator is "=". File example:<BR>
 * {@code en=hello}<BR>
 * {@code ru=привет}<BR>
 * {@code jp=おい}<BR>
 * Support comment char is "#".
 *
 * @author Andrey Korneychuk on 24-Sep-21
 * @version 1.1
 */
public class UtfProperties {

	private static final String DEFAULT_SPLITERATOR = "=";
	private static final int DEFAULT_BUFFER_SIZE = 8192;

	/**
	 * Fill existing properties from file at input stream.
	 *
	 * @param properties  target properties
	 * @param inputStream file input stream
	 * @throws IOException
	 */
	public static void fill(Properties properties, InputStream inputStream) throws IOException {
		fill(properties, inputStream, DEFAULT_BUFFER_SIZE, DEFAULT_SPLITERATOR);
	}

	/**
	 * Fill existing properties from file at input stream.
	 *
	 * @param properties  target properties
	 * @param inputStream file input stream
	 * @param spliterator properties spliterator
	 * @throws IOException
	 */
	public static void fill(Properties properties, InputStream inputStream, String spliterator) throws IOException {
		fill(properties, inputStream, DEFAULT_BUFFER_SIZE, spliterator);
	}

	/**
	 * Fill existing properties from file at input stream.
	 *
	 * @param properties  target properties
	 * @param inputStream file input stream
	 * @param bufferSize  buffer size of {@link BufferedReader}
	 * @throws IOException
	 */
	public static void fill(Properties properties, InputStream inputStream, int bufferSize) throws IOException {
		fill(properties, inputStream, bufferSize, DEFAULT_SPLITERATOR);
	}

	/**
	 * Fill existing properties from file at input stream.
	 *
	 * @param properties  target properties
	 * @param inputStream file input stream
	 * @param bufferSize  buffer size of {@link BufferedReader}
	 * @param spliterator properties spliterator
	 * @throws IOException
	 */
	public static void fill(Properties properties, InputStream inputStream, int bufferSize, String spliterator) throws IOException {
		Reader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
		BufferedReader bufferedReader = new BufferedReader(reader, bufferSize);
		String[] split;
		String line;
		while (bufferedReader.ready()) {
			line = bufferedReader.readLine();
			if (line.charAt(0) != 35) { // '#' comment char
				split = line.split(spliterator);
				properties.put(split[0].trim(), split[1].trim());
			}
		}
	}

	/**
	 * @param inputStream file input stream
	 * @return new filling properties
	 * @throws IOException
	 */
	public static Properties getProperties(InputStream inputStream) throws IOException {
		return getProperties(inputStream, DEFAULT_BUFFER_SIZE, DEFAULT_SPLITERATOR);
	}

	/**
	 * @param inputStream file input stream
	 * @param spliterator properties spliterator
	 * @return new filling properties
	 * @throws IOException
	 */
	public static Properties getProperties(InputStream inputStream, String spliterator) throws IOException {
		return getProperties(inputStream, DEFAULT_BUFFER_SIZE, spliterator);
	}

	/**
	 * Get new properties from file as input stream.
	 *
	 * @param inputStream file input stream
	 * @param bufferSize  buffer size of {@link BufferedReader}
	 * @return new filling properties
	 * @throws IOException
	 */
	public static Properties getProperties(InputStream inputStream, int bufferSize) throws IOException {
		return getProperties(inputStream, bufferSize, DEFAULT_SPLITERATOR);
	}

	/**
	 * Get new properties from file as input stream.
	 *
	 * @param inputStream file input stream
	 * @param bufferSize  buffer size of {@link BufferedReader}
	 * @param spliterator properties spliterator
	 * @return new filling properties
	 * @throws IOException
	 */
	public static Properties getProperties(InputStream inputStream, int bufferSize, String spliterator) throws IOException {
		Properties properties = new Properties();
		fill(properties, inputStream, bufferSize, spliterator);
		return properties;
	}
}
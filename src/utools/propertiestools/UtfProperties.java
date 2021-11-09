package utools.propertiestools;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * Short call UTF-8 encoded {@link Properties}.
 *
 * @author Andrey Korneychuk on 24-Sep-21
 * @version 2.0
 */
public class UtfProperties {

	/**
	 * Short call UTF-8 encoded {@link Properties}.
	 *
	 * @param path to properties file
	 * @return ready for work properties
	 * @throws IOException
	 */
	public static Properties asd(String path) throws IOException {
		Properties properties = new Properties();
		Reader inputStreamReader = new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8);
		properties.load(inputStreamReader);
		return properties;
	}
}
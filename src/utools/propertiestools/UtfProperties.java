package utools.propertiestools;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * Short call UTF-8 encoded {@link Properties}.
 *
 * @author Andrey Korneychuk on 24-Sep-21
 * @version 2.1
 */
public class UtfProperties {

	/**
	 * Short call UTF-8 encoded {@link Properties} from external environment.
	 *
	 * @param path to external properties file
	 * @return ready for work properties
	 * @throws IOException
	 */
	public static Properties getExternalUtfProperties(String path) throws IOException {
		Properties properties = new Properties();
		Reader reader = new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8);
		properties.load(reader);
		return properties;
	}

	/**
	 * Short call UTF-8 encoded {@link Properties} from internal environment.
	 *
	 * @param path to internal properties file
	 * @return ready for work properties
	 * @throws IOException
	 */
	public static Properties getInternalUtfProperties(String path) throws IOException {
		Properties properties = new Properties();
		Reader reader = new InputStreamReader(UtfProperties.class.getResourceAsStream(path), StandardCharsets.UTF_8);
		properties.load(reader);
		return properties;
	}
}
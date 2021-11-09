package utools.runninglocation;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Get current running *.jar path and some simple tools.
 *
 * @author Andrey Korneychuk on 17-Oct-21
 * @version 2.0
 */
public class RunningLocation {

	private static RunningLocation windowsInstance;
	private static RunningLocation unixInstance;

	private final boolean isWindowsOs;

	private RunningLocation(boolean isWindowsOs) {
		this.isWindowsOs = isWindowsOs;
	}

	/**
	 * Automatic detect OS type and get correct instance.
	 *
	 * @return Running location instance
	 */
	public static RunningLocation getInstance() {
		if (System.getProperty("os.name").startsWith("Windows")) {
			return getInstanceForWindows();
		} else {
			return getInstanceForUnix();
		}
	}

	/**
	 * Get Windows OS instance.
	 *
	 * @return Running location instance
	 */
	public static RunningLocation getInstanceForWindows() {
		if (windowsInstance == null) {
			windowsInstance = new RunningLocation(true);
		}
		return windowsInstance;
	}

	/**
	 * Get Unix OS instance.
	 *
	 * @return Running location instance
	 */
	public static RunningLocation getInstanceForUnix() {
		if (unixInstance == null) {
			unixInstance = new RunningLocation(false);
		}
		return unixInstance;
	}

	/**
	 * Return current *.jar file path. Example for Windows: "C:/file_name.jar".
	 * Example for Linux: "/home/user_name/Documents/file_name.jar"
	 *
	 * @return current *.jar file path
	 */
	public String getJarPath() {
		String path = RunningLocation.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		path = URLDecoder.decode(path, StandardCharsets.UTF_8);
		if (isWindowsOs) {
			return path.substring(1); // First char is '/', example "/D:/qwerty.jar"
		} else {
			return path;
		}
	}

	/**
	 * Return current *.jar directory.
	 *
	 * @return current *.jar directory
	 */
	public String getJarPathParent() {
		return Path.of(getJarPath()).getParent().toString();
	}

	/**
	 * Return absolute path to file for opening.
	 *
	 * @param relativePath path to file relative running Jar directory
	 * @return absolute path to file
	 */
	public String getFilePath(String relativePath) {
		if (relativePath.charAt(0) != '\\' || relativePath.charAt(0) != '/') {
			relativePath = '/' + relativePath;
		}
		return getJarPathParent() + relativePath;
	}

	/**
	 * Return all read lines from *.txt file.
	 *
	 * @param relativePath path to file
	 * @return all file lines
	 * @throws IOException
	 */
	public List<String> getAllLines(String relativePath) throws IOException {
		return Files.readAllLines(Path.of(getFilePath(relativePath)), StandardCharsets.UTF_8);
	}
}
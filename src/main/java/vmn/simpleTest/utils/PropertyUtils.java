package vmn.simpleTest.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

/**
 * Created by Aliaksandr_Novik2 on 16.07.15.
 */

public class PropertyUtils {

	private static PropertyUtils instance;
	public Properties properties = new Properties();
	public HashMap<String, String> arraySettings = new HashMap<String, String>();
	private String filePath = "config.properties";
	private FileInputStream fileInputStream = null;

	public static PropertyUtils getInstance() {
		if (instance == null) {
			instance = new PropertyUtils();
		}
		return instance;
	}

	public String getProperties(String fileName) {

		try {

			fileInputStream = new FileInputStream(filePath);

			properties.load(fileInputStream);

			Enumeration enumeration = properties.keys();

			while (enumeration.hasMoreElements()) {

				String key = enumeration.nextElement().toString();

				arraySettings.put(key, properties.getProperty(key));

				if (arraySettings.get(key).equals(fileName)) {

					return arraySettings.get(fileName);

				}

			}

		} catch (InvalidPropertiesFormatException e) {
			// TODO: LOGGER

			e.getMessage();

		} catch (IOException e) {
			// TODO: LOGGER
			e.getMessage();

		} finally {

			try {
				fileInputStream.close();
			} catch (IOException e) {
				// TODO: LOGGER

				e.printStackTrace();
			}

		}
		return arraySettings.get(fileName);
	}
}

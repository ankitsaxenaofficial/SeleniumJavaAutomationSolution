package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigRead {
	
	public static Properties prop;
	
	public static Properties loadConfig() throws IOException {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		return prop;
	}	
	
	public static String readProperties(String propName) {
		 if (prop == null) {
	            throw new IllegalStateException("Properties not loaded. Please call loadConfig() before accessing properties.");
	        }
		String value =  prop.getProperty(propName);
		if (value == null) {
            System.out.println("Property " + propName + " not found in the config file.");
        }
        return value;
	}

}

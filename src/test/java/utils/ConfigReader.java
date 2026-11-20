package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader  {
	



	    private static Properties properties;

	    static {

	        try {

	            String path =
	                    "Sourcet/maintest/data/config.properties";

	            FileInputStream fis =
	                    new FileInputStream(path);

	            properties = new Properties();

	            properties.load(fis);

	            fis.close();

	        } catch (IOException e) {

	            e.printStackTrace();

	            throw new RuntimeException(
	                    "Unable to load config.properties"
	            );
	        }
	    }

	    public static String getProperty(String key) {
	        return properties.getProperty(key);
	    }

		
	}


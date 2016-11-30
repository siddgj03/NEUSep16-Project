package org.neu.project.dao;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader{

	public Properties properties;

	public void readProperties(){
		try {
			properties = new Properties();
			File propertyFile = new File(System.getProperty("user.dir") + "\\config.properties");
			FileReader reader = new FileReader(propertyFile);
			properties.load(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getObject(String key){
		return properties.getProperty(key);
	}
}

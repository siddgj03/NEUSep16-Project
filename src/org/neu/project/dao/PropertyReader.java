package org.neu.project.dao;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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

	public String getString(String key){
		readProperties();
		return properties.getProperty(key);
	}
	
	public Font getFont(String key){
        Font value = null;
        
            String fontName = (String) getString(key+ ".Name");
            Integer fontStyle = Integer.parseInt(getString(key+ ".Style"));
            Integer fontSize = Integer.parseInt(getString(key+ ".Size"));
            value = new Font(fontName, fontStyle, fontSize);
        
        return value;
    }
	
	public Dimension getDimension(String key){
        Dimension value = null;
       
            Integer X = Integer.parseInt(getString(key+ ".X"));
            Integer Y = Integer.parseInt(getString(key+ ".Y"));
            value = new Dimension(X, Y);
        
        return value;
    }
	
	 public Color getColor(String key){
	        Color value = null;
	        
	            Integer R = Integer.parseInt(getString(key+ ".R"));
	            Integer G = Integer.parseInt(getString(key+ ".G"));
	            Integer B = Integer.parseInt(getString(key+ ".B"));
	            value = new Color(R, G, B);
	       
	        return value;
	    }
	
}

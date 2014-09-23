package config;

import java.util.ArrayList;

import util.XMLUtil;

public class PropertyConfig extends Config{
	private final String fileName = "PropertyType";
	private static PropertyConfig PropertyConfig = null; 
	private PropertyConfig() {
		// TODO Auto-generated constructor stub
		xmlUtil = new XMLUtil(fileName);
	}
	public static PropertyConfig getInstance(){
		if (PropertyConfig == null){
			PropertyConfig = new PropertyConfig();
		}
		return PropertyConfig;
	}
	
	public ArrayList<String> getPropertyList(){
		return xmlUtil.getListByTag("Name");	
	}
	
	public String getPropertyTypeByName(String name){
		return xmlUtil.getValueListByUpperTagAndName("Property",name,"Type").get(0);
	}

}

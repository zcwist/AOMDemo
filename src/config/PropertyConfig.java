package config;

import java.util.ArrayList;

import util.XMLUtil;

public class PropertyConfig {
	private final String fileName = "EntityType";
	private static PropertyConfig PropertyConfig = null; 
	private static XMLUtil xmlUtil;
	public PropertyConfig() {
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

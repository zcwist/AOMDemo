package model;

import config.PropertyConfig;

public class PropertyType {
	private String name;
	private String type;
	public PropertyType(String name, String type){
		this.name = name;
		this.type = type;
	}
	public PropertyType(String name){
		this.name = name;
		this.type =  PropertyConfig.getInstance().getPropertyTypeByName(name);
	}
	public String getName() {
		return name;
	}
	public String getType() {
		return type;
	}
}

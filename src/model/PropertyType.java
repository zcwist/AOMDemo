package model;

public class PropertyType {
	private String name;
	private String type;
	public PropertyType(String name, String type){
		this.name = name;
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public String getType() {
		return type;
	}
}

package model;

public class Property {
	private PropertyType type;
	private Object value;
	public Property(PropertyType type, Object value){
		this.type = type;
		this.value = value;
	}
	public PropertyType getType() {
		return type;
	}
	public Object getValue() {
		return value;
	}
}

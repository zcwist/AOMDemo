package model;

import java.util.List;


public class Entity {

	private EntityType type;
	private List<Property> properties;
	
	public EntityType getType() {
		return type;
	}
	public void setType(EntityType type) {
		this.type = type;
	}
	public List<Property> getProperties() {
		return properties;
	}
	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}
}

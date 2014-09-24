package model;

import java.util.List;

import config.EntityConfig;
import exception.InvalidEntityBuilderException;
import exception.NoSuchEntityException;

public class EntityBuilder {
	protected Entity entity = new Entity();
	private String type;
	private List<Property> propertyList;
	
	public EntityBuilder(String type, List<Property> propertyList){
		this.type = type;
		this.propertyList = propertyList;
	}
	
	public void buildEntityType() throws NoSuchEntityException{
		if (EntityConfig.getInstance().getEntityList().contains(type)){
			entity.setType(new EntityType(type));
		} else {
			throw new NoSuchEntityException();
		}
		
	}
	public void buildPropertyList(){
		entity.setProperties(propertyList);
	}
	
	public void verify() throws InvalidEntityBuilderException {
		if (type == null || propertyList == null){
			throw new InvalidEntityBuilderException();
		}
	}
	
	public Entity createEnttiy(){
		return entity;
	}

}

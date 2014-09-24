package model;

import config.EntityConfig;
import exception.NoSuchEntityException;

public class EntityBuilder {
	protected Entity entity = new Entity();
	
	public void buildEntityType(String type) throws NoSuchEntityException{
		if (EntityConfig.getInstance().getEntityList().contains(type)){
			entity.setType(new EntityType(type));
		} else {
			throw new NoSuchEntityException();
		}
		
	}
	public void buildPropertyList(){
		
	}
	
	public Entity createEnttiy(){
		return entity;
	}

}

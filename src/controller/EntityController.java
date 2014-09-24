package controller;

import model.Entity;
import model.EntityBuilder;
import exception.InvalidEntityBuilderException;
import exception.NoSuchEntityException;

public class EntityController {
	public Entity construct(EntityBuilder eb){
		Entity entity;
		try {
			eb.verify();
			eb.buildEntityType();
			eb.buildPropertyList();
		} catch (InvalidEntityBuilderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchEntityException e){
			e.printStackTrace();
		}
		
		
		entity = eb.createEnttiy();
		
		return entity;
	}

}

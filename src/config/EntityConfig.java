package config;

import java.util.ArrayList;

import util.XMLUtil;



public class EntityConfig{
	private final String fileName = "EntityType";
	private static EntityConfig entityConfig = null; 
	private static XMLUtil xmlUtil;
	public EntityConfig() {
		// TODO Auto-generated constructor stub
		xmlUtil = new XMLUtil(fileName);
	}
	public static EntityConfig getInstance(){
		if (entityConfig == null){
			entityConfig = new EntityConfig();
		}
		return entityConfig;
	}
	
	public ArrayList<String> getEntityList(){
		return xmlUtil.getListByTag("Name");	
	}
	
	public ArrayList<String> getPropertyListByEntityName(String name){
		return xmlUtil.getValueListByUpperTagAndName("Entity",name,"Property");
	}

	

}

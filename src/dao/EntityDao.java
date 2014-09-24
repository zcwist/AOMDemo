package dao;

import java.net.UnknownHostException;

import model.Entity;
import model.Property;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;

public class EntityDao extends MongoWrapper{
	private final String COLLNAME = "entity_property_list";

	public EntityDao() throws UnknownHostException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void insertNewEntity(Entity entity){
//		System.out.println(entity2BasicDBObject(entity).toString());
		try {
			DBCollection coll = db.getCollection(COLLNAME);
			coll.insert(entity2BasicDBObject(entity));
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	private BasicDBObject entity2BasicDBObject(Entity entity){
		BasicDBObject obj = new BasicDBObject();
		obj.append("EntityType", entity.getType().getType());
		BasicDBObject properties = new BasicDBObject();
		for (Property property: entity.getProperties()){
			BasicDBObject typeAndValue = new BasicDBObject().append("Type", property.getType().getType()).append("Value", property.getValue());
			properties.append(property.getType().getName(), typeAndValue);
		}
		obj.append("Properties", properties);
		
		return obj;
	}

}

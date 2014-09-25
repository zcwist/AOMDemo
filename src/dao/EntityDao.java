package dao;

import java.net.UnknownHostException;
import java.util.ArrayList;

import model.Entity;
import model.Property;
import model.Query;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

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
	
	public ArrayList<Query> runAQuery(Query query){
		ArrayList<Query> queryList = new ArrayList<Query>();
		try {
			DBCollection coll = db.getCollection(COLLNAME);
			DBCursor cur = coll.find(query.queryObj());
			while (cur.hasNext()){
				DBObject object = cur.next();
				Query item = new Query(query.getQueryType(), query.getInputProperty());
				item.generateOutput(object);
				queryList.add(item);
				
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		
		
		return queryList;
	}

}

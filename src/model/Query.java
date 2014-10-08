package model;

import java.util.ArrayList;
import java.util.HashMap;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import config.QueryConfig;

public class Query {
	private String queryType;
	private HashMap<String,String> inputProperty;
	private ArrayList<String> outputPropertyList;
	private HashMap<String, String> outputProperty;
	public Query(String queryType, HashMap<String, String> inputProperty){
		this.queryType = queryType;
		ArrayList<String> inputPropertyList = QueryConfig.getInstance().getInputPropertyListByQueryType(queryType);
		HashMap<String,String> temp = new HashMap<String,String>();
		for (String key: inputPropertyList){
//			if (inputProperty.get(key) != ""){
			temp.put(key, inputProperty.get(key));
//			}
		}
		this.inputProperty = temp;
		this.outputPropertyList = QueryConfig.getInstance().getOutputPropertyListByQueryType(queryType);
	}
	public String getQueryType() {
		return queryType;
	}
	public HashMap<String,String> getInputProperty() {
		return inputProperty;
	}
	public ArrayList<String> getOutputPropertyList() {
		return outputPropertyList;
	}
	public HashMap<String,String> getOutputProperty() {
		return outputProperty;
	}
	
	public BasicDBObject queryObj(){
		BasicDBObject query = new BasicDBObject();
		if (inputProperty != null){
			for (String key: inputProperty.keySet()){
				if (!inputProperty.get(key).equals("")){
					query.append("Properties." + key + ".Value", inputProperty.get(key));
				}
			}
		}
//		System.out.println(query);
		return query;
	}
	public void generateResult(DBObject item){
		
		BasicDBObject properties = (BasicDBObject) item.get("Properties");
		//generate a full input property
		HashMap<String,String> inputProperty = new HashMap<String, String>();
		for (String propertyName: this.inputProperty.keySet()){
//			System.out.println(propertyName);
			BasicDBObject aProperty = (BasicDBObject) properties.get(propertyName);
			inputProperty.put(propertyName, aProperty.get("Value").toString());
		}
		
		HashMap<String, String> outputProperty = new HashMap<String, String>();
		
//		System.out.println(properties.toString());
		
		for (String propertyName: outputPropertyList){
			
			BasicDBObject aProperty = (BasicDBObject) properties.get(propertyName);
			outputProperty.put(propertyName, aProperty.get("Value").toString());
		}
		this.inputProperty = inputProperty;
		this.outputProperty = outputProperty;
		
	}
}

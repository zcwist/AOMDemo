
package test;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.Entity;
import model.EntityBuilder;
import model.Property;
import model.PropertyType;
import model.Query;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import util.ExcelUtil;
import config.EntityConfig;
import config.PropertyConfig;
import controller.EntityController;
import dao.EntityDao;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Tester().test5();

	}

	public void test1(){
//		System.out.println(EntityConfig.getInstance().getEntityList().get(0));
//		System.out.println(EntityConfig.getInstance().getPropertyListByEntityName("��������").get(0));
//		System.out.println(PropertyConfig.getInstance().getPropertyList().get(0));
//		System.out.println(PropertyConfig.getInstance().getPropertyTypeByName("Currency"));
//		System.out.println(Transformer.array2Json(EntityConfig.getInstance().getPropertyListByEntityName("��������")));
	}
	public void test2(){
		String type = EntityConfig.getInstance().getEntityList().get(0);
		List<Property> propertyList = new ArrayList<Property>();
		for (String propertyName:EntityConfig.getInstance().getPropertyListByEntityName(type)){

			PropertyType propertyType = new PropertyType(propertyName, PropertyConfig.getInstance().getPropertyTypeByName(propertyName));
			
			Property property = new Property(propertyType, "dollar");
			propertyList.add(property);
		}

		EntityBuilder eb = new EntityBuilder(type, propertyList);
		EntityController ec = new EntityController();
		Entity entity;
		entity = ec.construct(eb);
		
		EntityDao entityDao = null;
		try {
			entityDao = new EntityDao();
			entityDao.insertNewEntity(entity);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			entityDao.destroy();
		}
		
	}
	public void test3(){
		//xls to db
		ExcelUtil excel = new ExcelUtil("��������","D:/","��������");
		try {
			excel.xls2DB();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void test4(){
		//test the QueryConfig reading
//		System.out.println(QueryConfig.getInstance().getInputPropertyListByQueryType("Query1").get(0));
//		System.out.println(QueryConfig.getInstance().getOutputPropertyListByQueryType("Query1").get(0));
//		System.out.println(QueryConfig.getInstance().getQueryTypeList().get(0));
		
		HashMap<String, String> inputProperty = new HashMap<String, String>();
//		inputProperty.put("����", "V17176443862");
		inputProperty.put("����", "5");
		Query query = new Query("Query1", inputProperty);
		EntityDao entityDao = null;
		try {
			entityDao = new EntityDao();
			ArrayList<Query> resultItem = entityDao.runAQuery(query);
			System.out.println(resultItem.get(0).getOutputProperty().get("��������"));
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			entityDao.destroy();
		}
	}
	public void test5(){
		try {
			System.out.println(new JSONObject().put("value", new JSONArray()));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

package test;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import util.ExcelUtil;
import model.Entity;
import model.EntityBuilder;
import model.Property;
import model.PropertyType;
import config.EntityConfig;
import config.PropertyConfig;
import controller.EntityController;
import dao.EntityDao;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Tester().test3();

	}

	public void test1(){
		System.out.println(EntityConfig.getInstance().getEntityList().get(0));
		System.out.println(EntityConfig.getInstance().getPropertyListByEntityName("Sheet").get(0));
		System.out.println(PropertyConfig.getInstance().getPropertyList().get(0));
		System.out.println(PropertyConfig.getInstance().getPropertyTypeByName("Currency"));
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
		new ExcelUtil().generateAXlsByEntity(EntityConfig.getInstance().getEntityList().get(0));
	}
}

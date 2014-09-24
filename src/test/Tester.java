package test;

import config.EntityConfig;
import config.PropertyConfig;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Tester().test1();

	}

	public void test1(){
		System.out.println(EntityConfig.getInstance().getEntityList().get(0));
		System.out.println(EntityConfig.getInstance().getPropertyListByEntityName("Sheet").get(0));
		System.out.println(PropertyConfig.getInstance().getPropertyList().get(0));
		System.out.println(PropertyConfig.getInstance().getPropertyTypeByName("Currency"));
	}
}

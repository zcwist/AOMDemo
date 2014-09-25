package config;

import java.util.ArrayList;

import util.XMLUtil;

public class QueryConfig extends Config {
	private final String fileName = "QueryType";
	private static QueryConfig QueryConfig = null; 
	private QueryConfig() {
		// TODO Auto-generated constructor stub
		xmlUtil = new XMLUtil(fileName);
	}
	public static QueryConfig getInstance(){
		if (QueryConfig == null){
			QueryConfig = new QueryConfig();
		}
		return QueryConfig;
	}
	public ArrayList<String> getQueryTypeList(){
		return xmlUtil.getListByTag("Name");
	}
	
	public ArrayList<String> getInputPropertyListByQueryType(String queryType){
		return xmlUtil.getValueListByUpperTagAndName("Query", queryType, "InputProperty");
	}
	public ArrayList<String> getOutputPropertyListByQueryType(String queryType){
		return xmlUtil.getValueListByUpperTagAndName("Query", queryType, "OutputProperty");
	}
	
	
}

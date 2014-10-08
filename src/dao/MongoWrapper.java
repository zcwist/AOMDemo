package dao;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class MongoWrapper {
	private MongoClient mongoClient = null;
	public DB db = null;
	private String ip = "127.0.0.1";
//	private String ip = "166.111.55.99";
	private int port = 27017;
	private String dbname = "AOMDemo";
	
	public MongoWrapper() throws UnknownHostException{
		mongoClient = new MongoClient(ip, port);
		db = mongoClient.getDB(dbname);
	}
	
	public void destroy(){
		mongoClient.close();
		if (mongoClient != null){
			mongoClient = null;
		}
		if (db != null){
			db = null;
		}
	}
	
	
}

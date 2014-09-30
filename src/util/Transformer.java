package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Transformer {
	public static JSONObject array2Json(String key, ArrayList<String> arrayList) throws JSONException{
		JSONArray jsonArray = new JSONArray(arrayList); 
		return new JSONObject().put(key, jsonArray);
	}
	public static HashMap<String, String> json2Map(JSONObject obj) throws JSONException{
		HashMap<String, String> map = new HashMap<String, String>();
		Iterator<?> keys = obj.keys();
		while (keys.hasNext()){
			String key = (String) keys.next();
			map.put(key, obj.getString(key));
			System.out.println(obj.get(key));
		}
		
		return map;
	}
}

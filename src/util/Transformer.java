package util;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Transformer {
	public static JSONObject array2Json(String key, ArrayList<String> arrayList) throws JSONException{
		JSONArray jsonArray = new JSONArray(arrayList); 
		return new JSONObject().append(key, jsonArray);
	}
}

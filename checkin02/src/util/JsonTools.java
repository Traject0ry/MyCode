package util;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

//导入gson 的jar包
public class JsonTools {
	public JsonTools() {
		// TODO 自动生成的构造函数存根
	}

	public static String getLoginCode(String jsonString) {
		String code = "";
		try {
			JsonObject jsonObj = new JsonParser().parse(jsonString)
					.getAsJsonObject();
			code = jsonObj.get("code").toString();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return code;
	}

	public static List<String> usernameList(String jsonString) {
		List<String> list = new ArrayList<String>();
		try {
			JSONObject jsonObject = new JSONObject(jsonString);
			JSONArray jsonArray = jsonObject.getJSONArray("username");
			for (int i = 0; i < jsonArray.length(); i++) {
				list.add(jsonArray.getString(i));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	public static List<String> CourseList(String jsonString) {
		List<String> list = new ArrayList<String>();
		try {
			JSONObject jsonObject = new JSONObject(jsonString);
			JSONArray jsonArray = jsonObject.getJSONArray("CourseList");
			for (int i = 0; i < jsonArray.length(); i++) {
				list.add(jsonArray.getString(i));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
}

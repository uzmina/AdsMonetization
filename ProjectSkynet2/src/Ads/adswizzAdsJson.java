package Ads;

//import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.Map;
class adswizzAdsJson {

	@Test
	
		 public static Map<String, Object> convertJSONStringToMap(String json) {
		        Map<String, Object> map = (Map)(new Gson()).fromJson(json, (new TypeToken<Map<String, Object>>(){}).getType());
		        return map;
		    }

		    public static boolean actionIsPrerollStart(Map<String, Object> map) {
		        if (map.containsKey("")) {
		            String action = (String)((String)map.get("description_url"));
		            return action.contains("https://www.iheart.com/");
		        } else {
		            return false;
		        }
		    }

		    public static String custParams(Map<String, Object> map) {
		        Map<String, Object> desc = (Map)((Map)map.get("cust_params"));
		        String id = (String)desc.get("id");
		        return id;
		    }

		    public static String adSize(Map<String, Object> map) {
		        Map<String, Object> desc = (Map)((Map)map.get("sz"));
		        String id = (String)desc.get("id");
		        return id;
		    }

		    public static String assetId(Map<String, Object> map) {
		        Map<String, Object> station = (Map)((Map)map.get("station"));
		        Map<String, Object> asset = (Map)((Map)station.get("asset"));
		        String id = (String)asset.get("id");
		        return id;
		    }
		

	}



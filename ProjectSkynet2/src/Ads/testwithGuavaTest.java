package Ads;

//import static org.junit.jupiter.api.Assertions.*;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

class testwithGuavaTest {

	String url = "https://pubads.g.doubleclick.net/gampad/ads?output=xml_vast4&url=com.clearchannel.iheartradio&sz=640x480&gdfp_req=1&cust_params=genre%3DACMAINSTREAM%26provider%3Dgrupoacir%26ccrcontent1%3Dnull%26ccrcontent2%3Dnull%26ccrcontent3%3Dnull%26ccrpos%3D8000%26g%3Dfemale%26a%3D23%26rzip%3D00000%26at%3DIHR%26id%3Dnull%26locale%3Den-US%26env%3D%26vers%3DiOS_12.4_2019081506_9.1.0%26ts%3Dnull&correlator=4354152255639451&unviewed_position_start=1&m_ast=vast&iu=%2F6663%2Fgru.allstations.int%2Fxhnb-fm&ciu_szs=640x480%2C400x24&env=vp&ms=rybkCGbuX_UZgmHdrgeFSBNJfWov8bea5dbo3JN4tiCfPEy8siMo90sfanE9TzYT14ZpEGM_X4xK2YFUOEUsb_B5YWj5G68L-gfH_4WhASYxBgYoLlTXn_C7jFbGyFCiLGHhAt50DY9wETeVlm3be5X2u22p6JOd-BYyRrhc0InOAJV-JisC23mwwfB6d5Z37s9P79642PEkDTKuXfiD5tuop_E09pCsl4dWl2Pi4c4pal0_2a_NW_7egFglmmDrAAgJi90uWR7HBHh-TFxhnh4yUEHGm-qD9qH_jf5be3c6C_X-dx1QIy1CFcHfXVtCoaQGOYT9xNVam0dCcQK47w&sdkv=h.3.151.0%2Fn.ios.3.8.1%2Fcom.clearchannel.iheartradio&osd=2&frm=0&vis=1&sdr=1&hl=en&is_amp=0&js=ima-ios.3.8.1&an=com.clearchannel.iheartradio&u_so=l&sdki=405&sdk_apis=7&omid_p=Google1%2Fios.3.8.1&dlt=1565962671751&idt=551&dt=1565962789794&scor=3410740761970336&submodel=iPhone11%2C6";
	@Test

	 
		public static Map<String, List<String>> splitQuery(URL url) throws UnsupportedEncodingException {
		
			  final Map<String, List<String>> query_pairs = new LinkedHashMap<String, List<String>>();
			  final String[] pairs = url.getQuery().split("&");
			  for (String pair : pairs) {
			    final int idx = pair.indexOf("=");
			    final String key = idx > 0 ? URLDecoder.decode(pair.substring(0, idx), "UTF-8") : pair;
			    if (!query_pairs.containsKey(key)) {
			      query_pairs.put(key, new LinkedList<String>());
			    }
			    final String value = idx > 0 && pair.length() > idx + 1 ? URLDecoder.decode(pair.substring(idx + 1), "UTF-8") : null;
			    query_pairs.get(key).add(value);
			  }
			  return query_pairs;
			}
	

}

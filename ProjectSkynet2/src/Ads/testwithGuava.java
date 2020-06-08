package Ads;
import java.util.Map;
import com.google.common.base.Splitter;

import org.apache.poi.EmptyFileException;
import org.junit.jupiter.api.Test;

class testwithGuava {

	@Test
	void test() {
		try{String uri = "https://clearchannel.deliveryengine.adswizz.com/www/delivery/swfIndex.php?aw_0_1st.reqtype=AdsSetup&aw_0_1st.protocolversion=2.0-compliant&aw_0_1st.zoneid=45286&componentVersion=Adswizz_SDK_6.11.1:ios13.4.1&aw_0_1st.companionzone=45287&aw_0_1st.referrer=http://iHeartiOSApp&dist=iheart&clientType=iPhone&iheartradioversion=9.19.2&osVersion=13.4.1&deviceid=20d43b1f78f5b971d07208e1193d642e&Devicename=iPhone&gender=male&yob=1985&ProfileId=4259191&init_id=8169&terminalid=180&streamid=5c4788eed0400b00012eb9f0&carrier=Verizon&at=1&amsparams=playerid:iHeartRadioiPhoneApp;skey:1590212527&zip=10013&host=iphone.mobile.us&awParams=n:35;g:1;playerid:iHeartRadioiPhoneApp;ccaud:null;companionAds:true&aw_0_req.bundleId=com.clearchannel.iheartradio.290638154&playedFrom=68&us-privacy=1-N-&aw_0_1st.sessionid=20d43b1f78f5b971d07208e1193d642e-1590208940&aw_0_1st.sessionstart=false&aw_0_1st.playlistid=39361&aw_0_1st.ihmgenre=genre_classic-rock&aw_0_1st.playlisttype=seedtype_artist&aw_0_1st.sessionid=1590208957452.425049.260876&aw_0_1st.cb=1590212527178.322998.53170&aw_0_1st.version=6.11.1%3Aios13.4.1&aw_0_awz.listenerid=6CC4B9AB-5891-4EB6-8C91-35849A86DAAC&aw_0_req.lmt=0&aw_0_1st.playerid=iHeartiOSApp&aw_0_1st.ts=1590212527&companionAds=true&aw_0_req.permissions=NNNNNNNN11&calendar=N&sdkiad=1&inAppNotif=1&call=1&pkpass=1&aw_0_1st.suppstatus=LOC_NOE-SON_NOI";
        String query = uri.split("%26")[0];
        final Map<String, String> map = Splitter.on('&').trimResults().withKeyValueSeparator('=').split(query);
        System.out.println(map + "\n");
		}catch (IllegalArgumentException e) {
			System.out.println(e);
		}
       //<map>.get("cust_params");
	}
}

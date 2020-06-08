package Ads;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.web.util.UriComponentsBuilder;

import com.google.common.base.Splitter;



public class UrlReader
{
	@Test
	public void testwithURI() throws NullPointerException{
		
	    String uri = "https://pubads.g.doubleclick.net/gampad/ads?should_silence_audio=0&os_version=13.3.1&ms=D8k3DiMqNdIG9ZmijoR0HKOXX4YtO2J6iKkwh2fOpJjxLJt44nLvEABjLbJ8hqifmWUmhRyxRn1zz1TYqBFcFGHQsn9i7XEduxseHppsQkFZbLy6cXPFPnnOVfVWN_z1_iUeJEopwj6WyUoX4isP0y_U1BOHNyWoaq4bfjdPX7s9zahmX2Z344nIWVcWg0SZWUVChJN5fzjjHSR8zwyKLir3yeNxSRfDyv2Cu2DvZUL9EPHF26sL0A9L6w6TIGjqKp6V5UyjI-ZiSxIz1QGZwCSKAp4HmwJbJN9_JnjCrDRyxWHkogNbx0dVIrDfOgfi2WL7p9geHG4LN4g4oWbkfA&u_so=p&omid_v=1.2.21-google_20191111&hl=en&submodel=iPhone11%2C6&ios_app_volume=1&is_nonagon=true&binary_arch=arm64&is_pseud=false&eid=318486741&net=wi&u_sd=3&ios_base_sdk=13.2&js=afma-sdk-i-v7.53.1&u_sso=p&fbs_aiid=857D566814FD4EA3AD019D3D694B7AF9&is_other_audio_playing=0&u_h=896&fbs_aeid=6031070428168708819&u_w=414&_c_csdk_npa_o=false&guci=0.0.0.0.0.0.0.0&_ad_b=300x50&sz=320x50%7C300x50&format=300x50_as&_package_name=com.clearchannel.iheartradio.enterprise&an=9.7.0.iphone.com.clearchannel.iheartradio.enterprise&u_audio=5&swipeable=1&dtxcb=11B500&dtsdk=iphoneos13.2&m_os_tgt=12.0&pf_wv=wkwebview&_ats=LMW&adk=2381134107&preqs=1&seq_num=4&time_in_session=47670&preqs_in_session=1&dload=1336&output=html&region=mobile_app&u_tz=-300&url=9.7.0.iphone.com.clearchannel.iheartradio.enterprise.adsenseformobileapps.com&gdfp_req=1&markup=html&m_ast=afmajs&impl=ifr&iu=%2F6663%2Fccr.ihr%2Fhom&correlator=1743597515710731&_hl=en-us&gsb=wi&caps=interactiveVideo_inlineVideo_mraid1_mraid2_mraid3_th_autoplay_mediation_av_sdkAdmobApiForAds_di_transparentBackground_sdkVideo_aso_sfv_dinm_dim_nav_navc_ct_scroll_dinmo_gls_cpcbg_omidEnabled_gcache_xSeconds&swdr=false&cap=a&blockAutoClicks=true&cust_params=rzip%3D08902%26a%3D19%26Latitude%26ccrpos%3D8004%26Udid%3D6CC4B9AB-5891-4EB6-8C91-35849A86DAAC%26hometab%3Dyourlibrary%26locale%3Den-US%26UdidType%3D1%26at%3D1%26Longitude%26vers%3DiOS_13.3.1_2020021401_9.7.0%26env%3Dprod%26g%3Dfemale&includeDoritos=true&rdidl=36&idtypel=4&is_latl=1&blob=ABPQqLGdY5hSJGRbPgBcxjEPhy4yBq0RU6c6jMa-_3ndwOE8iGzZqYv0Sdtqv8pOKGQzPHFLl2C0NtylTZW_UxKnfBdkc-BAIeejFetYEoqIJApeKYmJcu7NnSRdhAWDhl4TDiwayuPHaR4kBPvgwYe05r2x6TzVRWjTTPwPLtAH9AC2uADPDw5ohOEPuoxVjd0p1aHKBoQua6kpguYMgXCpkcu__KSkT2dMjxE1u2qESS_q68BtakNQAntcIzAIlmF4VgS7z2ZKmZV0IfTYfJTR4MKxhsBX3uYbstmeAJfn1xcjPUbDT8ASBsh1AA&et=11&tcar=13&jsv=sdk_20190107_RC02-production-sdk_20200210_RC00&urll=2301";
		
	    org.springframework.util.MultiValueMap<String, String> parameters = UriComponentsBuilder.fromUriString(uri).build().getQueryParams();
	    //List<String> param1 = (List<String>) parameters.get("caps");
	    List<String> param2 = (List<String>) parameters.get("cust_params");
	    System.out.println("param1: " + param2.get(0));
	    //System.out.println("param2: " + param2.get(0) + "," + param2.get(1));
	    final Map<String, String> map = Splitter.on('%').trimResults().withKeyValueSeparator('=').split((CharSequence) param2);
	}

}
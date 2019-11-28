package cn.xzcp.utils;



import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;


public class SMSUtils {

	public static boolean sendMessage(String[] phoneNumbers,String[] params) {
		// 短信应用 SDK AppID
		int appid = 1400214773; 

		// 短信应用 SDK AppKey
		String appkey = "725839ecd94a33c1aac3fa090cd179f2";

		// 短信模板 ID，需要在短信应用中申请
		int templateId = 339644; 

		// 签名
		String smsSign = ""; 
		
		try {
		  
		    SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
		    
		    SmsSingleSenderResult result = ssender.sendWithParam("86", phoneNumbers[0],
		        templateId, params, smsSign, "", "");  // 签名参数未提供或者为空时，会使用默认签名发送短信
		    //System.out.println(result);
		    return true;
		  
		} catch (Exception e) {
		    // HTTP 响应码错误
		    e.printStackTrace();
		    return false;
		} 
	}
}

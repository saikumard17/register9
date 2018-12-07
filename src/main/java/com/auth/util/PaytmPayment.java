package com.auth.util;

import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.paytm.pg.merchant.CheckSumServiceHelper;

@Controller
public class PaytmPayment {
	
	TreeMap<String, String> paytmParams = new TreeMap<String, String>();
	
	String merchantMid = "eFAncs74618577678119";
	// Key in your staging and production MID available in your dashboard
	String merchantKey = "rLSdPZFVrHXlssNf";
	// Key in your staging and production merchant key available in your dashboard
	String orderId = "order7";
	String channelId = "WEB";
	String custId = "cust123";
	String mobileNo = "";
	String email = "";
	String txnAmount = "10";
	String website = "DEFAULT";
	// This is the staging value. Production value is available in your dashboard
	String industryTypeId = "Retail";
	// This is the staging value. Production value is available in your dashboard
	
	String callbackUrl = "http://localhost:5000/paymentConfirmation";
	
	@RequestMapping(value = "/initiatePayment", method = RequestMethod.GET)
	public ModelAndView initiatePayment(Model model)
	{
	paytmParams.put("MID",merchantMid);
	paytmParams.put("ORDER_ID",orderId);
	paytmParams.put("CHANNEL_ID",channelId);
	paytmParams.put("CUST_ID",custId);
	paytmParams.put("MOBILE_NO",mobileNo);
	paytmParams.put("EMAIL",email);
	paytmParams.put("TXN_AMOUNT",txnAmount);
	paytmParams.put("WEBSITE",website);
	paytmParams.put("INDUSTRY_TYPE_ID",industryTypeId);
	paytmParams.put("CALLBACK_URL", callbackUrl);
	String paytmChecksum ="";
	try {
		paytmChecksum = CheckSumServiceHelper.getCheckSumServiceHelper().genrateCheckSum(merchantKey, paytmParams);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	paytmParams.put("CHECKSUMHASH", paytmChecksum);
	
	ModelAndView mav = new ModelAndView();
	mav.setViewName("payment");
	mav.addAllObjects(paytmParams);
	
	
	return mav;
	}
	
	@RequestMapping(value = "/paymentConfirmation", method = RequestMethod.POST)
	public String paymentConfirmation(@RequestParam Map<String, String> payment)
	{
		System.out.println("congrats");
		System.out.println("payment Id "+ payment);
		return "Ok";
	}
	
	
}

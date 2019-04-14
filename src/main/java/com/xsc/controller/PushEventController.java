package com.xsc.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xsc.model.WechatAppInfo;
import com.xsc.service.WechatAppInfoService;
import com.xsc.util.SHA1;

@Controller
public class PushEventController {

	private static Logger logger = Logger.getLogger(PushEventController.class);
	
	@Autowired
	private WechatAppInfoService wechatAppInfoService;
	
	/*@Value("${imagePath}")
	private String imagePath;*/
	
	@ResponseBody
	@RequestMapping(value = "/sending/pushEvent/{appid}", produces = "text/plain;charset=utf-8")
	public String pushEvent(HttpServletRequest request,@PathVariable("appid") String appid) {
		//DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");  
		//Date datetime = new Date();
		//String folderName = imagePath + dateformat.format(datetime) + "/";
		try {
			WechatAppInfo wechatAppInfo = wechatAppInfoService.selectWechatAppByAppid(appid);
			if (request.getMethod().equals("GET")) {
				// 微信加密签名
				String signature = request.getParameter("signature");
				// 时间戳
				String timestamp = request.getParameter("timestamp");
				// 随机数
				String nonce = request.getParameter("nonce");
				// 随机字符串
				String echostr = request.getParameter("echostr");
				
				String sign = SHA1.getSHA11(wechatAppInfo.getToken(), timestamp, nonce);
				if (sign.equals(signature)) {
					return echostr;
				}else {
					return "";
				}
			}else{
				
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
}

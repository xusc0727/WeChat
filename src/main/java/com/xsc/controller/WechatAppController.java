package com.xsc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xsc.model.WechatApp;
import com.xsc.service.WechatAppService;
import com.xsc.util.JsonHelper;

@Controller
public class WechatAppController {

	private static final Logger logger = Logger.getLogger(WechatAppController.class);
	
	@Autowired
	private WechatAppService wechatAppService;
	
	@ResponseBody
	@RequestMapping("/wechatApp/select")
	public String selectWechatAppList(){
		Map<String,Object> ResponseMap = new HashMap<String, Object>();
		List<WechatApp> wechatAppList = wechatAppService.selectWechatAppList();
		ResponseMap.put("status",200);
		ResponseMap.put("Object",wechatAppList);
		return JsonHelper.beanToJson(ResponseMap);
	}
}

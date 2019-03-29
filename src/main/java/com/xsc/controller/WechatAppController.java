package com.xsc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.xsc.model.WechatApp;
import com.xsc.service.WechatAppService;
import com.xsc.util.JsonHelper;

@RestController
public class WechatAppController {

	private static final Logger logger = Logger.getLogger(WechatAppController.class);
	
	@Autowired
	private WechatAppService wechatAppService;
	
	@ResponseBody
	@RequestMapping(value = "/wechatApp/select",method = RequestMethod.GET )
	public String selectWechatAppList(){
		Map<String,Object> ResponseMap = new HashMap<String, Object>();
		List<WechatApp> wechatAppList = wechatAppService.selectWechatAppList();
		if(wechatAppList.size()==0){
			ResponseMap.put("status",202);
			ResponseMap.put("message","找不到数据");
		}
		ResponseMap.put("status",200);
		ResponseMap.put("message","查询成功");
		ResponseMap.put("wechatAppList",wechatAppList);
		return JsonHelper.beanToJson(ResponseMap);
	}
}

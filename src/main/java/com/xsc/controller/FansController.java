package com.xsc.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.xsc.service.FansService;
import com.xsc.util.JsonHelper;

@RestController
public class FansController {

	private static final Logger logger = Logger.getLogger(FansController.class);
	
	@Autowired
	private FansService fansService;
	
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value = "/fans/initFans",method = RequestMethod.POST )
	public String initFans(@RequestBody String json){
		Map<String,Object> ResponseMap = new HashMap<String, Object>();
		Map<String,Object> paramsMap = JsonHelper.jsonToBean(json, Map.class);
		if(paramsMap.get("appid")==null) {
			ResponseMap.put("status",500);
			ResponseMap.put("message","参数有误");
			return JsonHelper.beanToJson(ResponseMap);
		}
		String appid = paramsMap.get("appid").toString();
		try {
			ResponseMap = fansService.initFans(appid);
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		}
		return JsonHelper.beanToJson(ResponseMap);
	}
}

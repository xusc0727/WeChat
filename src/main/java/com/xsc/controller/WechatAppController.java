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

import com.xsc.service.WechatAppService;
import com.xsc.util.JsonHelper;

@RestController
public class WechatAppController {

	private static final Logger logger = Logger.getLogger(WechatAppController.class);
	
	@Autowired
	private WechatAppService wechatAppService;
	
	@ResponseBody
	@RequestMapping(value = "/wechatApp/selectWechatAppList",method = RequestMethod.GET )
	public String selectWechatAppList(){
		Map<String,Object> ResponseMap = new HashMap<String, Object>();
		try {
			ResponseMap = wechatAppService.selectWechatAppList();
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		}
		return JsonHelper.beanToJson(ResponseMap);
	}
	
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value = "/wechatApp/selectWechatAppByAppId",method = RequestMethod.POST )
	public String selectWechatAppByAppId(@RequestBody String json){
		Map<String,Object> paramsMap = JsonHelper.jsonToBean(json, Map.class);
		Map<String,Object> ResponseMap = new HashMap<String, Object>();
		try {
			ResponseMap = wechatAppService.selectWechatAppByAppId(paramsMap);
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		}
		return JsonHelper.beanToJson(ResponseMap);
	}
	
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value = "/wechatApp/insertWechatApp",method = RequestMethod.POST )
	public String insertWechatApp(@RequestBody String json){
		Map<String,Object> paramsMap = JsonHelper.jsonToBean(json, Map.class);
		Map<String,Object> ResponseMap = new HashMap<String, Object>();
		try {
			ResponseMap = wechatAppService.insertWechatApp(paramsMap);
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		}
		return JsonHelper.beanToJson(ResponseMap);
	}
	
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value = "/wechatApp/updateWechatApp",method = RequestMethod.POST )
	public String updateWechatApp(@RequestBody String json){
		Map<String,Object> paramsMap = JsonHelper.jsonToBean(json, Map.class);
		Map<String,Object> ResponseMap = new HashMap<String, Object>();
		try {
			ResponseMap = wechatAppService.updateWechatApp(paramsMap);
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		}
		return JsonHelper.beanToJson(ResponseMap);
	}
	
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value = "/wechatApp/deleteWechatAppByAppId",method = RequestMethod.POST )
	public String deleteWechatAppByAppId(@RequestBody String json){
		Map<String,Object> paramsMap = JsonHelper.jsonToBean(json, Map.class);
		Map<String,Object> ResponseMap = new HashMap<String, Object>();
		try {
			ResponseMap = wechatAppService.deleteWechatAppByAppId(paramsMap);
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		}
		return JsonHelper.beanToJson(ResponseMap);
	}
}

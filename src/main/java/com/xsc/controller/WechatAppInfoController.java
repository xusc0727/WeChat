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

import com.xsc.service.WechatAppInfoService;
import com.xsc.util.JsonHelper;

@RestController
public class WechatAppInfoController {

	private static final Logger logger = Logger.getLogger(WechatAppInfoController.class);
	
	@Autowired
	private WechatAppInfoService wechatAppService;
	
	@ResponseBody
	@RequestMapping(value = "/wechatAppInfo/selectWechatAppList",method = RequestMethod.GET )
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
	@RequestMapping(value = "/wechatAppInfo/selectWechatAppByAppid",method = RequestMethod.POST )
	public String selectWechatAppByAppid(@RequestBody String json){
		Map<String,Object> paramsMap = JsonHelper.jsonToBean(json, Map.class);
		Map<String,Object> ResponseMap = new HashMap<String, Object>();
		try {
			ResponseMap = wechatAppService.selectWechatAppByAppid(paramsMap);
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		}
		return JsonHelper.beanToJson(ResponseMap);
	}
	
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value = "/wechatAppInfo/insertWechatApp",method = RequestMethod.POST )
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
	@RequestMapping(value = "/wechatAppInfo/updateWechatApp",method = RequestMethod.POST )
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
	@RequestMapping(value = "/wechatAppInfo/deleteWechatAppByAppid",method = RequestMethod.POST )
	public String deleteWechatAppByAppid(@RequestBody String json){
		Map<String,Object> paramsMap = JsonHelper.jsonToBean(json, Map.class);
		Map<String,Object> ResponseMap = new HashMap<String, Object>();
		try {
			ResponseMap = wechatAppService.deleteWechatAppByAppid(paramsMap);
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		}
		return JsonHelper.beanToJson(ResponseMap);
	}
}

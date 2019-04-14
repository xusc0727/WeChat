package com.xsc.service;

import java.util.Map;

import com.xsc.model.WechatAppInfo;

public interface WechatAppInfoService {

	Map<String,Object> selectWechatAppList() throws Exception;
	
	Map<String,Object> selectWechatAppByAppid(Map<String,Object> tempMap) throws Exception;
	
	WechatAppInfo selectWechatAppByAppid(String appid) throws Exception;
	
	Map<String,Object> insertWechatApp(Map<String,Object> tempMap) throws Exception;
	
	Map<String,Object> updateWechatApp(Map<String,Object> tempMap) throws Exception;
	
	Map<String,Object> deleteWechatAppByAppid(Map<String,Object> tempMap) throws Exception;
}

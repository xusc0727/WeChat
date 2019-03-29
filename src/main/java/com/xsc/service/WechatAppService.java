package com.xsc.service;

import java.util.Map;

public interface WechatAppService {

	Map<String,Object> selectWechatAppList() throws Exception;
	
	Map<String,Object> selectWechatAppByAppId(Map<String,Object> tempMap) throws Exception;
	
	Map<String,Object> insertWechatApp(Map<String,Object> tempMap) throws Exception;
	
	Map<String,Object> updateWechatApp(Map<String,Object> tempMap) throws Exception;
	
	Map<String,Object> deleteWechatAppByAppId(Map<String,Object> tempMap) throws Exception;
}

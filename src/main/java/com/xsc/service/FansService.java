package com.xsc.service;

import java.util.Map;

public interface FansService {

	Map<String,Object> selectFansList() throws Exception;
	
	Map<String,Object> selectFansByOpenid(Map<String,Object> tempMap) throws Exception;
	
	Map<String, Object> initFans(String appid) throws Exception;
	
	//Map<String,Object> updateFans(Map<String,Object> tempMap) throws Exception;
	
	Map<String,Object> deleteFansByOpenid(Map<String,Object> tempMap) throws Exception;
}

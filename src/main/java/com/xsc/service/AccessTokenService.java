package com.xsc.service;

import java.util.Map;

public interface AccessTokenService {

	String getAccessToken(String appid) throws Exception;
	
	Map<String,Object> createAccessToken(String appid) throws Exception;
}

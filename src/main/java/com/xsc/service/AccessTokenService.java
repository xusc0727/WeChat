package com.xsc.service;

import java.util.Map;

public interface AccessTokenService {

	Map<String,Object> selectAccessTokenService(Map<String,Object> tempMap) throws Exception;
	
	Map<String,Object> createAccessToken(String appid) throws Exception;
}

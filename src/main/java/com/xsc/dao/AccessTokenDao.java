package com.xsc.dao;

import org.springframework.stereotype.Repository;

import com.xsc.model.AccessToken;

@Repository("AccessTokenDao")
public interface AccessTokenDao {

	AccessToken selectAccessToken(String appid);
	
	int insertAccessToken(AccessToken accessToken);
	
	int updateAccessToken(AccessToken accessToken);
	
	
}

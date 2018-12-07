package com.xsc.dao;

import java.util.List;

import com.xsc.model.WechatApp;

public interface WechatAppDao {

	List<WechatApp> selectWechatAppList();
	
	int insertWechatApp();
	
	int updateWechatApp();
	
	int deleteWechatApp();
}

package com.xsc.service;

import java.util.List;

import com.xsc.model.WechatApp;

public interface WechatAppService {

	List<WechatApp> selectWechatAppList();
	
	int insertWechatApp();
	
	int updateWechatApp();
	
	int deleteWechatApp(String appId);
}

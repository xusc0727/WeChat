package com.xsc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xsc.model.WechatApp;

@Repository("WechatAppDao")
public interface WechatAppDao {

	List<WechatApp> selectWechatAppList();
	
	WechatApp selectWechatAppByAppId(String appId);
	
	int insertWechatApp(WechatApp wechatApp);
	
	int updateWechatApp(WechatApp wechatApp);
	
	int deleteWechatApp(String appId);
}

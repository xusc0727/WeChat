package com.xsc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xsc.model.WechatApp;

@Repository("WechatAppDao")
public interface WechatAppDao {

	List<WechatApp> selectWechatAppList();
	
	int insertWechatApp();
	
	int updateWechatApp();
	
	int deleteWechatApp(String appId);
}

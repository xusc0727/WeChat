package com.xsc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xsc.model.WechatAppInfo;

@Repository("WechatAppInfoDao")
public interface WechatAppInfoDao {

	List<WechatAppInfo> selectWechatAppList();
	
	WechatAppInfo selectWechatAppByAppid(String appid);
	
	int insertWechatApp(WechatAppInfo wechatApp);
	
	int updateWechatApp(WechatAppInfo wechatApp);
	
	int deleteWechatAppByAppid(String appid);
}

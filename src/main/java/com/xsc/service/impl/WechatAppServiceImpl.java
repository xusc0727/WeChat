package com.xsc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xsc.dao.WechatAppDao;
import com.xsc.model.WechatApp;
import com.xsc.service.WechatAppService;

@Service("WechatAppServiceImpl")
public class WechatAppServiceImpl implements WechatAppService {

	@Autowired
	private WechatAppDao wechatAppDao;
	
	public List<WechatApp> selectWechatAppList() {
		return wechatAppDao.selectWechatAppList();
	}

	public int insertWechatApp() {
		return wechatAppDao.insertWechatApp();
	}

	public int updateWechatApp() {
		return wechatAppDao.updateWechatApp();
	}

	public int deleteWechatApp(String appId) {
		return wechatAppDao.deleteWechatApp(appId);
	}

}

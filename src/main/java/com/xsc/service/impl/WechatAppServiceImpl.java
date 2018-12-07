package com.xsc.service.impl;

import java.util.List;

import com.xsc.dao.WechatAppDao;
import com.xsc.model.WechatApp;
import com.xsc.service.WechatAppService;

public class WechatAppServiceImpl implements WechatAppService {

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

	public int deleteWechatApp() {
		return wechatAppDao.deleteWechatApp();
	}

}

package com.xsc.service.impl;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xsc.dao.WechatAppDao;
import com.xsc.model.WechatApp;
import com.xsc.service.WechatAppService;

@Service("WechatAppServiceImpl")
public class WechatAppServiceImpl implements WechatAppService {

	@Autowired
	private WechatAppDao wechatAppDao;
	
	public Map<String,Object> selectWechatAppList() throws Exception{
		Map<String,Object> responseMap = new HashMap<String, Object>();
		List<WechatApp> wechatAppList = wechatAppDao.selectWechatAppList();
		if(wechatAppList.size()==0) {
			responseMap.put("status",202);
			responseMap.put("message","找不到记录");
			return responseMap;
		}
		responseMap.put("status",200);
		responseMap.put("message","查询成功");
		responseMap.put("wechatAppList",wechatAppList);
		return responseMap;
	}

	public Map<String,Object> selectWechatAppByAppId(Map<String,Object> tempMap) throws Exception {
		Map<String,Object> responseMap = new HashMap<String, Object>();
		String appId = tempMap.get("appId").toString();
		WechatApp wechatApp = wechatAppDao.selectWechatAppByAppId(appId);
		if(wechatApp==null) {
			responseMap.put("status",202);
			responseMap.put("message","找不到记录");
			return responseMap;
		}
		responseMap.put("status",200);
		responseMap.put("message","查询成功");
		responseMap.put("wechatApp",wechatApp);
		return responseMap;
	}
	
	public Map<String,Object> insertWechatApp(Map<String,Object> tempMap) throws Exception{
		Map<String,Object> responseMap = new HashMap<String, Object>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		WechatApp wechatApp = new WechatApp();
		wechatApp.setAppId(tempMap.get("appId").toString());
		wechatApp.setSecret(tempMap.get("secret").toString());
		wechatApp.setWechatAppName(tempMap.get("wechatAppName").toString());
		wechatApp.setToken(tempMap.get("token").toString());
		wechatApp.setIsDel(Integer.valueOf(tempMap.get("isDel").toString()));
		wechatApp.setCreateDate(sdf.parse(tempMap.get("createDate").toString()));
		wechatApp.setCreateBy(tempMap.get("createBy").toString());
		wechatApp.setUpdateDate(sdf.parse(tempMap.get("updateDate").toString()));
		wechatApp.setUpdateBy(tempMap.get("updateBy").toString());
		int i = wechatAppDao.insertWechatApp(wechatApp);
		if(i==0){
			responseMap.put("status",202);
			responseMap.put("message","添加失败");
			return responseMap;
		}
		responseMap.put("status",200);
		responseMap.put("message","添加成功");
		return responseMap;
	}
	
	public Map<String,Object> updateWechatApp(Map<String,Object> tempMap) throws Exception {
		Map<String,Object> responseMap = new HashMap<String, Object>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		WechatApp wechatApp = new WechatApp();
		wechatApp.setAppId(tempMap.get("appId").toString());
		wechatApp.setSecret(tempMap.get("secret").toString());
		wechatApp.setWechatAppName(tempMap.get("wechatAppName").toString());
		wechatApp.setToken(tempMap.get("token").toString());
		wechatApp.setIsDel(Integer.valueOf(tempMap.get("isDel").toString()));
		wechatApp.setCreateDate(sdf.parse(tempMap.get("createDate").toString()));
		wechatApp.setCreateBy(tempMap.get("createBy").toString());
		wechatApp.setUpdateDate(sdf.parse(tempMap.get("updateDate").toString()));
		wechatApp.setUpdateBy(tempMap.get("updateBy").toString());
		int i = wechatAppDao.updateWechatApp(wechatApp);
		if(i==0){
			responseMap.put("status",202);
			responseMap.put("message","修改失败");
			return responseMap;
		}
		responseMap.put("status",200);
		responseMap.put("message","修改成功");
		return responseMap;
	}

	public Map<String,Object> deleteWechatAppByAppId(Map<String,Object> tempMap) throws Exception {
		Map<String,Object> responseMap = new HashMap<String, Object>();
		String appId = tempMap.get("appId").toString();
		int i = wechatAppDao.deleteWechatApp(appId);
		if(i==0) {
			responseMap.put("status",202);
			responseMap.put("message","删除失败");
			return responseMap;
		}
		responseMap.put("status",200);
		responseMap.put("message","删除成功");
		return responseMap;
	}


}

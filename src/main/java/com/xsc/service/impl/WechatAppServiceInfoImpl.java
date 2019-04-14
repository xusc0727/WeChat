package com.xsc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.xsc.dao.WechatAppInfoDao;
import com.xsc.model.WechatAppInfo;
import com.xsc.service.WechatAppInfoService;

@Service("WechatAppServiceInfoImpl")
public class WechatAppServiceInfoImpl implements WechatAppInfoService {

	@Autowired
	private WechatAppInfoDao wechatAppDao;
	
	public Map<String,Object> selectWechatAppList() throws Exception{
		Map<String,Object> responseMap = new HashMap<String, Object>();
		List<WechatAppInfo> wechatAppList = wechatAppDao.selectWechatAppList();
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

	public Map<String,Object> selectWechatAppByAppid(Map<String,Object> tempMap) throws Exception {
		Map<String,Object> responseMap = new HashMap<String, Object>();
		if(tempMap.get("appid")==null) {
			responseMap.put("status",500);
			responseMap.put("message","参数有误");
			return responseMap;
		}
		String appid = tempMap.get("appid").toString();
		WechatAppInfo wechatApp = wechatAppDao.selectWechatAppByAppid(appid);
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
	
	public WechatAppInfo selectWechatAppByAppid(String appid) throws Exception {
		if(StringUtils.isEmpty(appid)) {
			return null;
		}
		WechatAppInfo wechatApp = wechatAppDao.selectWechatAppByAppid(appid);
		if(wechatApp==null) {
			return null;
		}
		return wechatApp;
	}
	
	public Map<String,Object> insertWechatApp(Map<String,Object> tempMap) throws Exception{
		Map<String,Object> responseMap = new HashMap<String, Object>();
		
		WechatAppInfo wechatApp = new WechatAppInfo();
		if(tempMap.get("appid")==null) {
			responseMap.put("status",500);
			responseMap.put("message","参数有误");
			return responseMap;
		}
		wechatApp.setAppid(tempMap.get("appid").toString());
		wechatApp.setSecret(tempMap.get("secret").toString());
		wechatApp.setWechatAppName(tempMap.get("wechatAppName").toString());
		wechatApp.setToken(tempMap.get("token").toString());
		//0表示未删除
		wechatApp.setIsDel(0);
		wechatApp.setCreateDate(new java.util.Date());
		wechatApp.setCreateBy(tempMap.get("createBy").toString());
		wechatApp.setUpdateDate(new java.util.Date());
		wechatApp.setUpdateBy(tempMap.get("createBy").toString());
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
		WechatAppInfo wechatApp = new WechatAppInfo();
		if(tempMap.get("appid")==null) {
			responseMap.put("status",500);
			responseMap.put("message","参数有误");
			return responseMap;
		}
		wechatApp.setAppid(tempMap.get("appid").toString());
		if(tempMap.get("secret")!=null){
			wechatApp.setSecret(tempMap.get("secret").toString());
		}
		if(tempMap.get("wechatAppName")!=null){
			wechatApp.setWechatAppName(tempMap.get("wechatAppName").toString());
		}
		if(tempMap.get("token")!=null){
			wechatApp.setToken(tempMap.get("token").toString());
		}
		if(tempMap.get("isDel")!=null){
			wechatApp.setIsDel(Integer.valueOf(tempMap.get("isDel").toString()));
		}
		if(tempMap.get("updateBy")!=null){
			wechatApp.setUpdateBy(tempMap.get("updateBy").toString());
		}
		wechatApp.setUpdateDate(new java.util.Date());
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

	public Map<String,Object> deleteWechatAppByAppid(Map<String,Object> tempMap) throws Exception {
		Map<String,Object> responseMap = new HashMap<String, Object>();
		if(tempMap.get("appid")==null) {
			responseMap.put("status",500);
			responseMap.put("message","参数有误");
			return responseMap;
		}
		String appid = tempMap.get("appid").toString();
		int i = wechatAppDao.deleteWechatAppByAppid(appid);
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

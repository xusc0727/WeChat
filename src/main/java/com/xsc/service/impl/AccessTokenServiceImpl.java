package com.xsc.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.xsc.dao.AccessTokenDao;
import com.xsc.dao.WechatAppInfoDao;
import com.xsc.model.AccessToken;
import com.xsc.model.WechatAppInfo;
import com.xsc.service.AccessTokenService;
import com.xsc.util.Constants;
import com.xsc.util.DateUtils;
import com.xsc.util.HttpUtils;

@Service("AccessTokenServiceImpl")
public class AccessTokenServiceImpl implements AccessTokenService {

	private static final Logger logger = Logger.getLogger(AccessTokenServiceImpl.class);
	
	@Autowired
	private AccessTokenDao accessTokenDao;
	
	@Autowired
	private WechatAppInfoDao wechatAppDao;
	
	public String getAccessToken(String appid) throws Exception {
		String accessTokenStr = "";
		if(StringUtils.isEmpty(appid)) {
			return accessTokenStr;
		}
		AccessToken accessToken = accessTokenDao.selectAccessToken(appid);
		if(accessToken==null) {
			return accessTokenStr;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowDate = sdf.format(new Date());
		String refreshDate = accessToken.getRefreshDate();
		boolean needRefresh = DateUtils.compare(refreshDate,nowDate);
		if(needRefresh){
			createAccessToken(appid);
			accessToken = accessTokenDao.selectAccessToken(appid);
		}
		return accessToken.getAccessToken();
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> createAccessToken(String appid) throws Exception {
		Map<String,Object> responseMap = new HashMap<String, Object>();
		WechatAppInfo wechatAppInfo = wechatAppDao.selectWechatAppByAppid(appid);
		String secret = wechatAppInfo.getSecret();
		String getAccessTokenUrl = String.format(Constants.GET_ACCESS_TOKEN,appid,secret);
		String jsonStr = HttpUtils.get(getAccessTokenUrl, null);
		logger.info("getAccessToken:"+jsonStr);
		ObjectMapper mapper = new ObjectMapper();
		Map<String,Object> map = mapper.readValue(jsonStr,Map.class);
		Integer errcode = (Integer)map.get("errcode");
		if(errcode == null) {
			AccessToken accessToken = new AccessToken();
			String accessTokenStr = map.get("access_token").toString();
			int expiresIn = (Integer)map.get("expires_in");
			Date nowDate = new Date();
			Date refreshDate = new Date(nowDate.getTime()+expiresIn*1000-300*1000);
			accessToken.setAppid(appid);
			accessToken.setAccessToken(accessTokenStr);
			accessToken.setExpiresIn(expiresIn);
			accessToken.setCreateDate(nowDate);
			accessToken.setRefreshDate(refreshDate);
			AccessToken selectAccessToken = accessTokenDao.selectAccessToken(appid);
			int i = 0;
			if(selectAccessToken==null) {
				i = accessTokenDao.insertAccessToken(accessToken);
			}else {
				i = accessTokenDao.updateAccessToken(accessToken);
			}
			if(i==0) {
				responseMap.put("status",500);
				responseMap.put("message","access_token update fail!");
			}else {
				responseMap.put("status",200);
				responseMap.put("message","access_token update success!");
			}
		}else {
			String errmsg = map.get("errmsg").toString();
			logger.error("GET_ACCESS_TOKEN fail!errcode:"+errcode+" errmsg:"+errmsg);
			responseMap.put("status",500);
			responseMap.put("errcode", errcode);
			responseMap.put("errmsg", errmsg);
		}
		return responseMap;
	}

}

package com.xsc.service.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xsc.dao.FansDao;
import com.xsc.model.Fans;
import com.xsc.service.AccessTokenService;
import com.xsc.service.FansService;
import com.xsc.util.Constants;
import com.xsc.util.HttpUtils;

@Service("FansServiceImpl")
public class FansServiceImpl implements FansService {
	
	private static final Logger logger = Logger.getLogger(FansServiceImpl.class);
	
	@Autowired
	private FansDao fansDao;
	
	@Autowired
	private AccessTokenService accessTokenService;

	public Map<String, Object> selectFansList() throws Exception {
		Map<String,Object> responseMap = new HashMap<String, Object>();
		List<Fans> fansList = fansDao.selectFansList();
		if(fansList.size()==0){
			responseMap.put("status",202);
			responseMap.put("message","找不到记录");
			return responseMap;
		}
		responseMap.put("status",200);
		responseMap.put("message","查询成功");
		responseMap.put("fansList",fansList);
		return responseMap;
	}

	public Map<String, Object> selectFansByOpenid(Map<String, Object> tempMap) throws Exception {
		Map<String,Object> responseMap = new HashMap<String, Object>();
		if(tempMap.get("openid")==null) {
			responseMap.put("status",500);
			responseMap.put("message","参数有误");
			return responseMap;
		}
		String openid = tempMap.get("openid").toString();
		Fans fans = fansDao.selectFansByOpenid(openid);
		if(fans==null){
			responseMap.put("status",202);
			responseMap.put("message","找不到记录");
			return responseMap;
		}
		responseMap.put("status",200);
		responseMap.put("message","查询成功");
		responseMap.put("fans",fans);
		return responseMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> initFans(String appid) throws Exception {
		Map<String,Object> responseMap = new HashMap<String, Object>();
		String accessTokenStr = accessTokenService.getAccessToken(appid);
		String getUserListUrl = String.format(Constants.USER_GET_URL,accessTokenStr,"");
		String getUserListJsonStr = HttpUtils.get(getUserListUrl, null);
		logger.info("getUserList:"+getUserListJsonStr);
		ObjectMapper mapper = new ObjectMapper();
		Map<String,Object> map = mapper.readValue(getUserListJsonStr,Map.class);
		Integer errcode = (Integer)map.get("errcode");
		if(errcode == null) {
			Map<String, Object> data = (Map<String, Object>) map.get("data");
			List<String> openList = (List<String>) data.get("openid");
			String openid = "";
			String getUserInfoJsonStr = "";
			Map<String,Object> getUserInfoMap = new HashMap<String, Object>();
			Fans fans = new Fans();
			for (int i = 0; i < openList.size(); i++) {
				openid = openList.get(i);
				String getUserInfoUrl = String.format(Constants.USER_INFO_URL,accessTokenStr,openid);
				getUserInfoJsonStr = HttpUtils.get(getUserInfoUrl, null);
				logger.info("getUserInfoJsonStr:"+getUserInfoJsonStr);
				getUserInfoMap = mapper.readValue(getUserInfoJsonStr,Map.class);
				fans.setOpenid(openid);
				fans.setIsSubscribe((Integer)getUserInfoMap.get("subscribe"));
				fans.setNickname((String)getUserInfoMap.get("nickname"));
				fans.setSex((Integer)getUserInfoMap.get("sex"));
				fans.setCity((String)getUserInfoMap.get("city"));
				fans.setCountry((String)getUserInfoMap.get("country"));
				fans.setProvince((String)getUserInfoMap.get("province"));
				fans.setLanguage((String)getUserInfoMap.get("language"));
				fans.setHeadimgurl((String)getUserInfoMap.get("headimgurl"));
				fans.setSubscribeTime(new Date(Integer.valueOf((Integer)getUserInfoMap.get("subscribe_time")).longValue()));
				fans.setUnionid((String)getUserInfoMap.get("unionid"));
				fans.setRemark((String)getUserInfoMap.get("remark"));
				fans.setGroupid(String.valueOf((Integer)getUserInfoMap.get("groupid")));
				fans.setTagidList("[]");
				//fans.setTagidList((List<Integer>) getUserInfoMap.get("tagid_list"));
				fans.setSubscribeScene((String)getUserInfoMap.get("subscribe_scene"));
				fans.setCreateDate(new Date());
				fans.setCreateBy("system");
				fans.setUpdateDate(new Date());
				fans.setUpdateBy("system");
				fans.setWechatAppid(appid);
				fansDao.insertFans(fans);
			}
			responseMap.put("status",200);
			responseMap.put("message","initFans success!");
		}else{
			String errmsg = map.get("errmsg").toString();
			logger.error("GET_ACCESS_TOKEN fail!errcode:"+errcode+" errmsg:"+errmsg);
			responseMap.put("status",500);
			responseMap.put("errcode", errcode);
			responseMap.put("errmsg", errmsg);
		}
		return responseMap;
	}

	public Map<String, Object> deleteFansByOpenid(Map<String, Object> tempMap) throws Exception {
		return null;
	}

}

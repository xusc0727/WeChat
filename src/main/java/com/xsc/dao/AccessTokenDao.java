package com.xsc.dao;

import org.apache.ibatis.annotations.Param;

import com.xsc.model.AccessToken;

public interface AccessTokenDao {

	AccessToken selectAccessToken(@Param("wechatAppId") String wechatAppId);
}

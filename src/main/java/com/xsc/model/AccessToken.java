package com.xsc.model;

import java.util.Date;

import com.xsc.util.DateUtils;

public class AccessToken {
	
	//公众号id
	private String appid;
	//公众号的accessToken
	private String accessToken;
	//凭证有效时间
	private int expiresIn;
	//创建时间
	private String createDate;
	//刷新时间
	private String refreshDate;
	
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public int getExpiresIn() {
		return expiresIn;
	}
	public void setExpiresIn(int expiresIn) {
		this.expiresIn = expiresIn;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = DateUtils.format(createDate, "yyyy-MM-dd HH:mm:ss");
	}
	public String getRefreshDate() {
		return refreshDate;
	}
	public void setRefreshDate(Date refreshDate) {
		this.refreshDate = DateUtils.format(refreshDate, "yyyy-MM-dd HH:mm:ss");;
	}
	
}

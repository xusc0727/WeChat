package com.xsc.model;

public class AccessToken {
	
	//公众号id
	private String appid;
	//公众号的accessToken
	private String accessToken;
	//凭证有效时间
	private String expiresIn;
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
	public String getExpiresIn() {
		return expiresIn;
	}
	public void setExpiresIn(String expiresIn) {
		this.expiresIn = expiresIn;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getRefreshDate() {
		return refreshDate;
	}
	public void setRefreshDate(String refreshDate) {
		this.refreshDate = refreshDate;
	}
	
}

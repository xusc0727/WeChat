package com.xsc.model;

public class AccessToken {
	
	//公众号id
	private Long wechatAppId;
	//公众号的accessToken
	private String accessToken;
	//刷新时间
	private String refreshTime;
	//凭证有效时间
	private String expiresIn;
	
	public Long getCode() {
		return wechatAppId;
	}
	public void setCode(Long wechatAppId) {
		this.wechatAppId = wechatAppId;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getRefreshTime() {
		return refreshTime;
	}
	public void setRefreshTime(String refreshTime) {
		this.refreshTime = refreshTime;
	}
	public String getExpiresIn() {
		return expiresIn;
	}
	public void setExpiresIn(String expiresIn) {
		this.expiresIn = expiresIn;
	}
	
}

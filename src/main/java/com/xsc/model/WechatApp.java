package com.xsc.model;

import java.util.Date;

public class WechatApp {
	
	//公众号id
	private Long wechatAppId;
	//公众号appid
	private String appId;
	//公众号secret
	private String secret;
	//公众号名称
	private String wechatAppName;
	//公众号验证token
	private String token;
	//是否删除
	private Integer isDel;
	//创建时间
	private Date createDate;
	//创建者
	private String createBy;
	//更新时间
	private Date updateDate;
	//更新者
	private String updateBy;
	
	public Long getWechatAppId() {
		return wechatAppId;
	}
	public void setWechatAppId(Long wechatAppId) {
		this.wechatAppId = wechatAppId;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getSecret() {
		return secret;
	}
	public void setSecret(String secret) {
		this.secret = secret;
	}
	public String getWechatAppName() {
		return wechatAppName;
	}
	public void setWechatAppName(String wechatAppName) {
		this.wechatAppName = wechatAppName;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Integer getIsDel() {
		return isDel;
	}
	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	
}

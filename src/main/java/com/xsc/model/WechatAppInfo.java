package com.xsc.model;

import java.util.Date;

import com.xsc.util.DateUtils;

public class WechatAppInfo {
	
	//id
	private Integer id;
	//公众号appid
	private String appid;
	//公众号secret
	private String secret;
	//公众号名称
	private String wechatAppName;
	//公众号验证token
	private String token;
	//是否删除
	private Integer isDel;
	//创建时间
	private String createDate;
	//创建者
	private String createBy;
	//更新时间
	private String updateDate;
	//更新者
	private String updateBy;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
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
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = DateUtils.format(createDate, "yyyy-MM-dd hh:mm:ss");
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = DateUtils.format(updateDate, "yyyy-MM-dd hh:mm:ss");
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	
}

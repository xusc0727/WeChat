package com.xsc.model;

import java.util.Date;

public class User {

	private Long userId;
	//用户名
	private String userName;
	//密码
	private String password;
	//角色id
	private Long roleId;
	//公众号id
	private Long wechatAppId;
	//创建时间
	private Date createDate;
	//创建者
	private String createBy;
	//更新时间
	private Date updateDate;
	//更新者
	private String updateBy;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public Long getWechatId() {
		return wechatAppId;
	}
	public void setWechatId(Long wechatAppId) {
		this.wechatAppId = wechatAppId;
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

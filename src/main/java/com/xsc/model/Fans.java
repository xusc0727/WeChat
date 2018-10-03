package com.xsc.model;

import java.util.Date;

public class Fans {

	private Long id;
	//用户的标识，对当前公众号唯一
	private String openId;
	//用户的昵称
	private String nickName;
	//用户的性别
	private String sex;
	//用户所在国家
	private String country;
	//用户所在省份
	private String province;
	//用户所在城市
	private String city;
	//用户头像地址
	private String headimgUrl;
	//用户关注时间
	private Date subscribeDate;
	//公众号运营者对粉丝的备注
	private String remark;
	//用户被打上的标签ID列表
	private String tagidList;
	/*
	 * 用户关注的渠道来源
	 * ADD_SCENE_SEARCH 公众号搜索，
	 * ADD_SCENE_ACCOUNT_MIGRATION 公众号迁移，
	 * ADD_SCENE_PROFILE_CARD 名片分享，
	 * ADD_SCENE_QR_CODE 扫描二维码，
	 * ADD_SCENEPROFILE LINK 图文页内名称点击，
	 * ADD_SCENE_PROFILE_ITEM 图文页右上角菜单，
	 * ADD_SCENE_PAID 支付后关注，
	 * ADD_SCENE_OTHERS 其他
	 */
	private String subscribeScene;
	//是否审核人
	private String isChecker;
	//是否黑名单
	private Integer isBlack;
	//是否取消关注
	private Integer isDel;
	//创建时间
	private Date createDate;
	//修改时间
	private Date updateDate;
	//所属公众号id
	private Long weixinAppId;
	//更新人
	private String updateBy;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getHeadimgUrl() {
		return headimgUrl;
	}
	public void setHeadimgUrl(String headimgUrl) {
		this.headimgUrl = headimgUrl;
	}
	public Date getSubscribeDate() {
		return subscribeDate;
	}
	public void setSubscribeDate(Date subscribeDate) {
		this.subscribeDate = subscribeDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getTagidList() {
		return tagidList;
	}
	public void setTagidList(String tagidList) {
		this.tagidList = tagidList;
	}
	public String getSubscribeScene() {
		return subscribeScene;
	}
	public void setSubscribeScene(String subscribeScene) {
		this.subscribeScene = subscribeScene;
	}
	public String getIsChecker() {
		return isChecker;
	}
	public void setIsChecker(String isChecker) {
		this.isChecker = isChecker;
	}
	public Integer getIsBlack() {
		return isBlack;
	}
	public void setIsBlack(Integer isBlack) {
		this.isBlack = isBlack;
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
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public Long getWeixinAppId() {
		return weixinAppId;
	}
	public void setWeixinAppId(Long weixinAppId) {
		this.weixinAppId = weixinAppId;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	
}

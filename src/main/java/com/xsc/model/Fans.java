package com.xsc.model;

import java.util.Date;

import com.xsc.util.DateUtils;

public class Fans {

	private Long id;
	//用户的标识，对当前公众号唯一
	private String openid;
	//用户是否关注公众号
	private int isSubscribe;
	//用户的昵称
	private String nickname;
	//用户的性别
	private int sex;
	//用户所在城市
	private String city;
	//用户所在国家
	private String country;
	//用户所在省份
	private String province;
	//用户的语言
	private String language;
	//用户头像地址
	private String headimgurl;
	//用户关注时间
	private String subscribeTime;
	//unionid
	private String unionid;
	//公众号运营者对粉丝的备注
	private String remark;
	//用户所在的分组ID（兼容旧分组接口）
	private String groupid;
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
	//所属公众号id
	private String wechatAppid;
	//是否审核人
	private int isChecker;
	//是否黑名单
	private int isBlack;
	//创建时间
	private String createDate;
	//创建人
	private String createBy;
	//修改时间
	private String updateDate;
	//更新人
	private String updateBy;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public int getIsSubscribe() {
		return isSubscribe;
	}
	public void setIsSubscribe(int isSubscribe) {
		this.isSubscribe = isSubscribe;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
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
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getHeadimgurl() {
		return headimgurl;
	}
	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}
	public String getSubscribeTime() {
		return subscribeTime;
	}
	public void setSubscribeTime(Date subscribeTime) {
		this.subscribeTime = DateUtils.format(subscribeTime, "yyyy-MM-dd HH:mm:ss");
	}
	public String getUnionid() {
		return unionid;
	}
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getGroupid() {
		return groupid;
	}
	public void setGroupid(String groupid) {
		this.groupid = groupid;
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
	public String getWechatAppid() {
		return wechatAppid;
	}
	public void setWechatAppid(String wechatAppid) {
		this.wechatAppid = wechatAppid;
	}
	public int getIsChecker() {
		return isChecker;
	}
	public void setIsChecker(int isChecker) {
		this.isChecker = isChecker;
	}
	public int getIsBlack() {
		return isBlack;
	}
	public void setIsBlack(int isBlack) {
		this.isBlack = isBlack;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = DateUtils.format(createDate, "yyyy-MM-dd HH:mm:ss");
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
		this.updateDate = DateUtils.format(updateDate, "yyyy-MM-dd HH:mm:ss");
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	
	
}

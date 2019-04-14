package com.xsc.util;
/**
 * 常量
 * @author xusc
 *
 */
public class Constants {

	//获取access_token
	public static final String GET_ACCESS_TOKEN="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";
	//创建标签
	public static final String CREATE_TAGS_URL="https://api.weixin.qq.com/cgi-bin/tags/create?access_token=%s";
	//获取已创建标签
	public static final String GET_TAGS_URL="https://api.weixin.qq.com/cgi-bin/tags/get?access_token=%s";
	
	public static final String UPLOAD_MATERIAL_URL="https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=%s&type=%s";
	
	public static final String ADD_NEWS_URL="https://api.weixin.qq.com/cgi-bin/material/add_news?access_token=%s";
	
	public static final String UPDATE_NEWS_URL="https://api.weixin.qq.com/cgi-bin/material/update_news?access_token=%s";
	
	public static final String UPLOAD_IMG_URL="https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=%s";
	//获取用户列表
	public static final String USER_GET_URL="https://api.weixin.qq.com/cgi-bin/user/get?access_token=%s&next_openid=%s";
	//获取用户基本信息
	public static final String USER_INFO_URL="https://api.weixin.qq.com/cgi-bin/user/info?access_token=%s&openid=%s&lang=zh_CN";
	 
	public static final String BATCHTAGGING_URL="https://api.weixin.qq.com/cgi-bin/tags/members/batchtagging?access_token=%s";
	 
	public static final String BATCHUNTAGGING_URL="https://api.weixin.qq.com/cgi-bin/tags/members/batchuntagging?access_token=%s";
	 
	//上传永久素材
	public static final String MATERIAL_ADDNEWS_URL="https://api.weixin.qq.com/cgi-bin/material/add_news?access_token=%s";
	 
	//消息预览
	public static final String PREVIEW_URL="https://api.weixin.qq.com/cgi-bin/message/mass/preview?access_token=%s";
	//根据openid列表群发
	public static final String MESSAGE_SEND_OPENIDS="https://api.weixin.qq.com/cgi-bin/message/mass/send?access_token=%s";
	//根据标签群发
	public static final String MESSAGE_SEND_TAGS="https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token=%s";
	 
	//创建菜单
	public static final String MENU_CREATE_URL="https://api.weixin.qq.com/cgi-bin/menu/create?access_token=%s";
	//获取自定义菜单
	public static final String GET_SELFMENU_URL="https://api.weixin.qq.com/cgi-bin/get_current_selfmenu_info?access_token=%s";
	//下载多媒体
	public static final String MEDIA_GET_URL="https://api.weixin.qq.com/cgi-bin/media/get?access_token=%s&media_id=%s";
	//拉黑用户
	public static final String BATCH_BLACK_LIST = "https://api.weixin.qq.com/cgi-bin/tags/members/batchblacklist?access_token=%s";
	//移出黑名单
	public static final String BATCH_UNBLACK_LIST = "https://api.weixin.qq.com/cgi-bin/tags/members/batchunblacklist?access_token=%s";
	//移出黑名单
	public static final String GET_BLACK_LIST = "https://api.weixin.qq.com/cgi-bin/tags/members/getblacklist?access_token=%s";
	//批量获取
	public static final String USER_BATCHGET_URL = "https://api.weixin.qq.com/cgi-bin/user/info/batchget?access_token=%s";

}

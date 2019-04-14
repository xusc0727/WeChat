package com.xsc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xsc.model.Fans;

@Repository("FansDao")
public interface FansDao{

	List<Fans> selectFansList();
	
	Fans selectFansByOpenid(String openid);
	
	int insertFans(Fans fans);
	
	//int updateFans(Fans fans);
	
	int deleteFansByOpenid(String openid);
}

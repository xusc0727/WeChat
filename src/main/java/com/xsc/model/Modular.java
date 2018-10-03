package com.xsc.model;

public class Modular {

	//模块id
	private Long modularId;
	//模块名称
	private String modularName;
	//模块url
	private String modularUrl;
	//排序
	private Integer sort;
	//状态
	private Integer status;
	
	public Long getModularId() {
		return modularId;
	}
	public void setModularId(Long modularId) {
		this.modularId = modularId;
	}
	public String getModularName() {
		return modularName;
	}
	public void setModularName(String modularName) {
		this.modularName = modularName;
	}
	public String getModularUrl() {
		return modularUrl;
	}
	public void setModularUrl(String modularUrl) {
		this.modularUrl = modularUrl;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
}

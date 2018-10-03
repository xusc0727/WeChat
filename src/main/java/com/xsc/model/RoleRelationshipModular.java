package com.xsc.model;

public class RoleRelationshipModular {

	//关系id
	private Long relationshipId;
	//角色id
	private Long roleId;
	//模块id
	private Long modularId;
	//是否删除
	private Integer isDel;

	public Long getRelationshipId() {
		return relationshipId;
	}

	public void setRelationshipId(Long relationshipId) {
		this.relationshipId = relationshipId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getModularId() {
		return modularId;
	}

	public void setModularId(Long modularId) {
		this.modularId = modularId;
	}

	public Integer getIsDel() {
		return isDel;
	}

	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}
	
}

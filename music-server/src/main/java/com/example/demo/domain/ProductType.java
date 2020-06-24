package com.example.demo.domain;

import java.util.Date;

public class ProductType {
	private Long productTypeId;
	
	private String productTypeName;
	
	private Date createTime;
	
	private Date updateTime;

	public Long getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(Long productTypeId) {
		this.productTypeId = productTypeId;
	}

	public String getProductTypeName() {
		return productTypeName;
	}

	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName == null ? null : productTypeName.trim();
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTIme) {
		this.updateTime = updateTIme;
	}
	
	
	

}

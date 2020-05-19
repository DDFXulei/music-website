package com.example.demo.domain;

import java.util.Date;

public class Product {

	private Integer id;

	private Integer productId;

	private String productName;

	private String productIntro;

	private Date createDate;

	private String pic;

	private String lyric;

	private String url;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductIntro() {
		return productIntro;
	}

	public void setProductIntro(String productIntro) {
		this.productIntro = productIntro == null ? null : productIntro.trim();
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic == null ? null : pic.trim();
	}

	public String getlyric() {
		return lyric;
	}

	public void setlyric(String lyric) {
		this.lyric = lyric == null ? null : pic.trim();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	
}

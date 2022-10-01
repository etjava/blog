package com.etjava.bean;

/**
 * 友情链接实体类
 * @author etjav
 *
 */
public class Link {

	private Integer id;
	private String linkName;
	private String linkUrl;
	private Integer orderNo;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLinkName() {
		return linkName;
	}
	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}
	public String getLinkUrl() {
		return linkUrl;
	}
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}
	public Integer getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}
	@Override
	public String toString() {
		return "Link [id=" + id + ", linkName=" + linkName + ", linkUrl=" + linkUrl + ", orderNo=" + orderNo + "]";
	}
}

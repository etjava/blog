package com.etjava.bean;

import java.util.Date;

/**
 *  博客文章实体 - 拉取其他网站的
 * @author etjav
 *
 */
public class CrawlerBlog extends Blog{

	private Integer state;
	private String originalUrl;
	private Date createDate;
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getOriginalUrl() {
		return originalUrl;
	}
	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "CrawlerBlog [state=" + state + ", originalUrl=" + originalUrl + ", createDate=" + createDate + "]";
	}
}

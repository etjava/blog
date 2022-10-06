package com.etjava.mapper;

import java.util.List;
import java.util.Map;

import com.etjava.bean.CrawlerBlog;

public interface CrawlerBlogMapper {

	List<CrawlerBlog> list(Map<String,Object> map);
	
	Integer total(Map<String,Object> map);
	
	Integer add(CrawlerBlog blog);
	
	Integer update(CrawlerBlog blog);
	
	Integer delete(Integer id);
	
	Integer insert(CrawlerBlog blog);
}

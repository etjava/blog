package com.etjava.mapper;

import java.util.List;
import java.util.Map;

import com.etjava.bean.Blog;

public interface BlogMapper {

	/**
	 * 	按日期分组查询
	 * @return
	 */
	List<Blog> countList();
	
	/**
	 * 分页查询数据
	 * @param map
	 * @return
	 */
	List<Blog> list(Map<String,Object> map);
	
	/**
	 * 总记录数 - 分页用
	 * @param map
	 * @return
	 */
	Integer total(Map<String,Object> map);
}
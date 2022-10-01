package com.etjava.mapper;

import java.util.List;

import com.etjava.bean.Blog;

public interface BlogMapper {

	/**
	 * 	按日期分组查询
	 * @return
	 */
	List<Blog> countList();
}

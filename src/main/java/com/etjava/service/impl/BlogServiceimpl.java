package com.etjava.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.etjava.bean.Blog;
import com.etjava.mapper.BlogMapper;
import com.etjava.service.BlogService;

@Service("blogService")
public class BlogServiceimpl implements BlogService {

	@Resource
	private BlogMapper blogMapper;
	
	@Override
	public List<Blog> countList() {
		return blogMapper.countList();
	}

}

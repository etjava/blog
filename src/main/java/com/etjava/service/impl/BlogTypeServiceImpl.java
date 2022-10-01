package com.etjava.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.etjava.bean.BlogType;
import com.etjava.mapper.BlogTypeMapper;
import com.etjava.service.BlogTypeService;

@Service("blogTypeService")
public class BlogTypeServiceImpl implements BlogTypeService {

	@Resource
	private BlogTypeMapper bligTypeMapper;
	
	@Override
	public List<BlogType> countList() {
		return bligTypeMapper.countList();
	}

	@Override
	public BlogType findById(Integer id) {
		return bligTypeMapper.findById(id);
	}

}

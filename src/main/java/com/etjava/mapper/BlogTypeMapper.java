package com.etjava.mapper;

import java.util.List;

import com.etjava.bean.BlogType;

public interface BlogTypeMapper {

	List<BlogType> countList();
	
	BlogType findById(Integer id);
}

package com.etjava.service;

import java.util.List;

import com.etjava.bean.BlogType;

public interface BlogTypeService {

	List<BlogType> countList();
	
	BlogType findById(Integer id);
}

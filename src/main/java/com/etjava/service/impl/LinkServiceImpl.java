package com.etjava.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.etjava.bean.Link;
import com.etjava.mapper.LinkMapper;
import com.etjava.service.LinkService;

@Service("linkService")
public class LinkServiceImpl implements LinkService {
	
	@Resource
	private LinkMapper linkMapper;

	@Override
	public List<Link> list(Map<String, Object> map) {
		return linkMapper.list(map);
	}

}

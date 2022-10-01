package com.etjava.service;

import java.util.List;
import java.util.Map;

import com.etjava.bean.Link;

public interface LinkService {

	public List<Link> list(Map<String,Object> map);
}

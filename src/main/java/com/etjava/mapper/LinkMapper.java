package com.etjava.mapper;

import java.util.List;
import java.util.Map;

import com.etjava.bean.Link;

public interface LinkMapper {

	public List<Link> list(Map<String,Object> map);
}

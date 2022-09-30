package com.etjava.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.etjava.bean.Users;
import com.etjava.mapper.UsersMapper;
import com.etjava.service.UsersService;

@Service("userService")
public class UsersServiceImpl implements UsersService{


	@Resource
	private UsersMapper usersMapper;
	
	@Override
	public Users findByUserName(String userName) {
		return usersMapper.findByUserName(userName);
	}

}

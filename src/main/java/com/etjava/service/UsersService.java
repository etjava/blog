package com.etjava.service;

import com.etjava.bean.Users;

/**
 * 博主信息Service接口
 * @author etjav
 *
 */
public interface UsersService {

	Users findByUserName(String userName);
}

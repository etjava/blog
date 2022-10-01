package com.etjava.mapper;

import com.etjava.bean.Users;

/**
 * 博主信息DAO(mapper)接口
 * @author etjav
 *
 */
public interface UsersMapper {

	/**
	 * 根据userName查找用户
	 * @param userName
	 * @return
	 */
	Users findByUserName(String userName);
	
	Users findById(Integer id);
	
}

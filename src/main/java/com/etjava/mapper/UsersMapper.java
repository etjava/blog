package com.etjava.mapper;

import com.etjava.bean.Users;

/**
 * ������ϢDAO(mapper)�ӿ�
 * @author etjav
 *
 */
public interface UsersMapper {

	/**
	 * ����userName�����û�
	 * @param userName
	 * @return
	 */
	Users findByUserName(String userName);
	
	Users findById(Integer id);
	
}

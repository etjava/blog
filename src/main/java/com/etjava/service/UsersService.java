package com.etjava.service;

import com.etjava.bean.Users;

/**
 * ������ϢService�ӿ�
 * @author etjav
 *
 */
public interface UsersService {

	Users findByUserName(String userName);
}

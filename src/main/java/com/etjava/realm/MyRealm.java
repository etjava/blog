package com.etjava.realm;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.etjava.bean.Users;
import com.etjava.service.UsersService;

public class MyRealm extends AuthorizingRealm{

	@Resource
	private UsersService usersService;
	
	/**
	 * Role Assignment (only one user)
	 * 角色分配(当前项目没有用到 因为只有一个用户)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Validition Sign in
	 * 登录验证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

		String userName = (String)token.getPrincipal();
		Users user = usersService.findByUserName(userName);
		if(user!=null) {
			// 把当前用户信息放到session中
			SecurityUtils.getSubject().getSession().setAttribute("currentUser", user);
			// 验证登录密码
			AuthenticationInfo auth = new SimpleAuthenticationInfo(user.getUserName(), user.getPassword(),"others wirte");
			return auth;
		}else {
			return null;
		}
	}

}

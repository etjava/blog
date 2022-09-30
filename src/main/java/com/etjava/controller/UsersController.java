package com.etjava.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.etjava.bean.Users;
import com.etjava.service.UsersService;
import com.etjava.util.CryptographyUtil;

/**
 * the controller of blog personal 
 * ������Ϣcontroller
 * 
 * @author etjav
 *
 */
@Controller
@RequestMapping("/blogger")
public class UsersController {
	
	private Logger logger = LoggerFactory.getLogger(UsersController.class);

	@Resource
	private UsersService userService;
	
	@RequestMapping("/login")
	public String login(Users user,HttpServletRequest req) {
		// shiro�л�ȡ��ǰ�û�
		Subject subject = SecurityUtils.getSubject();
		// ��װ�û����������token
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(),CryptographyUtil.md5(user.getPassword(), "etjava") );
		try {
			// ��¼��֤ - �����MyRealm��doGetAuthenticationInfo������֤
			subject.login(token);
			logger.info("["+user+"] ��¼�ɹ�");
			return "redirect:/admin/main.jsp";
		} catch (Exception e) {
			logger.error("�û�["+user+"]��¼ʧ�� ��"+e.getMessage());
			req.setAttribute("errorInfo", "�û������������");
			req.setAttribute("blogger", user);
			return "login";
		}
		
	}
}

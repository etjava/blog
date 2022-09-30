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
 * 博主信息controller
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
		// shiro中获取当前用户
		Subject subject = SecurityUtils.getSubject();
		// 封装用户名和密码的token
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(),CryptographyUtil.md5(user.getPassword(), "etjava") );
		try {
			// 登录验证 - 会调用MyRealm中doGetAuthenticationInfo进行验证
			subject.login(token);
			logger.info("["+user+"] 登录成功");
			return "redirect:/admin/main.jsp";
		} catch (Exception e) {
			logger.error("用户["+user+"]登录失败 ："+e.getMessage());
			req.setAttribute("errorInfo", "用户名或密码错误");
			req.setAttribute("blogger", user);
			return "login";
		}
		
	}
}

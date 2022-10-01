package com.etjava.service.impl;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.etjava.bean.Link;
import com.etjava.bean.Users;
import com.etjava.service.LinkService;
import com.etjava.service.UsersService;

@Component
public class InitComponent implements ApplicationContextAware,ServletContextListener{
	
	private Logger logger = LoggerFactory.getLogger(InitComponent.class);

	
	private static ApplicationContext ac;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.ac = applicationContext;
		System.out.println(ac);
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		logger.info("contextInitialized............ ");
		ServletContext application=sce.getServletContext();
		UsersService bloggerService=(UsersService) ac.getBean("userService");
		Users blogger=bloggerService.findByUserName("etjava"); // 获取博主信息
		blogger.setPassword(null);
		application.setAttribute("blogger", blogger);
		
		LinkService linkService=(LinkService) ac.getBean("linkService");
		List<Link> linkList=linkService.list(null); // 查询所有的友情链接信息
		application.setAttribute("linkList", linkList);
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("applicaion destoryed......");
	}
	
	
	

	
}

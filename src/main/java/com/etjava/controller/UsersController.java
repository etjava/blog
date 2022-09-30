package com.etjava.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.etjava.service.UsersService;

/**
 * the controller of blog personal 
 * ²©Ö÷ÐÅÏ¢controller
 * 
 * @author etjav
 *
 */
@Controller
@RequestMapping("/blogger")
public class UsersController {

	@Resource
	private UsersService userService;
}

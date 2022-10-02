package com.etjava.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.etjava.bean.Blog;
import com.etjava.service.BlogService;

@Controller
@RequestMapping("/blog")
public class BlogController {

	@Resource
	private BlogService blogService;
	
	/*
	 * /articles/{id} 请求后边的id 是获取的@PathVariable("id")里面的值  这个值是点击链接访问的时候传递过来的
	 */
	@RequestMapping("/articles/{id}")
	public ModelAndView articles(@PathVariable("id") Integer id,HttpServletRequest request)throws Exception{
		ModelAndView mav = new ModelAndView();
		Blog blog = blogService.findbyId(id);
		blog.setClickHit(blog.getClickHit()+1);
		blogService.update(blog);
		
		mav.addObject("blog",blog);
		mav.addObject("pageTitle",blog.getTitle());
		mav.addObject("mainPage","foreground/blog/view.jsp");
		mav.setViewName("template");
		return mav;
	}
}

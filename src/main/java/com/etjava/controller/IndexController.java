package com.etjava.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.etjava.bean.Blog;
import com.etjava.bean.PageBean;
import com.etjava.service.BlogService;
import com.etjava.util.PageUtil;
import com.etjava.util.StringUtil;

@Controller
@RequestMapping("/")
public class IndexController {

	@Resource
	private BlogService blogService;
	
	@RequestMapping("/index")
	public ModelAndView index(@RequestParam(value="page",required = false) String page,HttpServletRequest req) throws Exception {
		if(StringUtil.isEmpty(page)) {
			page="1";
		}
		PageBean pageBean = new PageBean(Integer.parseInt(page),10);
		Map<String,Object> map = new HashMap<>();
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		
		List<Blog> list = blogService.list(map);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageTitle","ETJAVA BLOG");
		mav.addObject("blogList", list);
		
		// 分页页码
		StringBuffer parm = new StringBuffer();
		mav.addObject("pageCode",
				PageUtil.genPagination(req.getContextPath()+"/index.html", 
						blogService.total(map), Integer.parseInt(page)
						, 10, parm.toString()));
		
		
		
		
		/*
		 * template include content.jsp ->
		 * content include blog/list.jsp
		 */
		mav.addObject("mainPage","foreground/common/content.jsp");
		mav.setViewName("template"); // template.jsp  但 springMVC 中做了映射 这里可以不需要在写后缀名了
		return mav;
	}
}

package com.etjava.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
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
		// 提取内容中的所有图片
		for(Blog blog:list) {
			List<String> imageList = blog.getImageList();
			String blogInfo = blog.getContent();
			// Jsoup 解析内容中图片信息 (内容是带有html标签的)
			Document doc = Jsoup.parse(blogInfo);
			// 解析img元素中后缀为jpg的元素    不加[src$=.jpg] 表示获取所有img标签
			Elements elements = doc.select("img[src$=.jpg]");
			for(int i=0;i<elements.size();i++) {
				if(i==3) { // 最多只选三张图片
					break; 
				}
				Element element = elements.get(i);
				// element.toString() 对应的图片访问路径
				imageList.add(element.toString());
			}
		}
		
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

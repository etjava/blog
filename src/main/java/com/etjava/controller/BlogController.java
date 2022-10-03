package com.etjava.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.etjava.bean.Blog;
import com.etjava.bean.Comment;
import com.etjava.lucene.ContentLucene;
import com.etjava.service.BlogService;
import com.etjava.service.CommentService;
import com.etjava.util.StringUtil;

@Controller
@RequestMapping("/blog")
public class BlogController {

	@Resource
	private BlogService blogService;
	@Resource
	private CommentService commentService;
	
	private ContentLucene index = new ContentLucene();
	
	private Logger logger = LoggerFactory.getLogger(BlogController.class);
	
	
	/**
	 * 	检索博客信息
	 * @param keyword
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/search")
	public ModelAndView search(@RequestParam(value="keyword",required = false) String keyword) throws Exception{
		ModelAndView mav = new ModelAndView();
		List<Blog> list = index.search(keyword);
		mav.addObject("blogList",list);
		mav.addObject("keyword",keyword);
		mav.addObject("resultTotal",list.size());
		mav.addObject("pageTitle", "search '"+keyword+"' - ETJAVA Blog");
		mav.addObject("mainPage","foreground/blog/search.jsp");
		mav.setViewName("template");
		logger.info("搜索 ["+keyword+"] 找到 "+list.size()+" 条内容");
		return mav;
	}
	
	/*
	 * /articles/{id} 请求后边的id 是获取的@PathVariable("id")里面的值  这个值是点击链接访问的时候传递过来的
	 */
	@RequestMapping("/articles/{id}")
	public ModelAndView articles(@PathVariable("id") Integer id,HttpServletRequest request)throws Exception{
		ModelAndView mav = new ModelAndView();
		Blog blog = blogService.findbyId(id);
		
		String keyword = blog.getKeyword();
		if(StringUtil.isNotEmpty(keyword)) {
			String[] data = keyword.split(" ");
			List<String> keywordList = StringUtil.filterWhite(Arrays.asList(data));// 剔除数组内多余的空格元素
			mav.addObject("keywords",keywordList);
		}else {
			mav.addObject("keywords",null);
		}
		
		blog.setClickHit(blog.getClickHit()+1);
		blogService.update(blog);
		Map<String,Object> map = new HashMap<>();
		map.put("state", 1);
		map.put("blogId", blog.getId());
		List<Comment> commentList = commentService.list(map);
		mav.addObject("commentList",commentList);
		mav.addObject("blog",blog);
		mav.addObject("pageCode", this.getUpAndDownPageCode(blogService.lastBlog(id), blogService.nextBlog(id), request.getServletContext().getContextPath()));
		mav.addObject("pageTitle",blog.getTitle()+" - ETJAVA Blog");
		mav.addObject("mainPage","foreground/blog/view.jsp");
		mav.setViewName("template");
		
		logger.info("查看 id = "+id+" title = "+blog.getTitle()+" 的博客内容 ");
		return mav;
	}
	
	/**
	 * 获取上一篇和下一篇博客
	 * @param lastBlog 上一篇
	 * @param nextBlog 下一篇
	 * @param projectContext  项目的根路径 发布后会映射成域名
	 * @return
	 */
	private String getUpAndDownPageCode(Blog lastBlog,Blog nextBlog,String projectContext){
		StringBuffer pageCode=new StringBuffer();
		if(lastBlog==null || lastBlog.getId()==null){
			pageCode.append("<p>Previous:&nbsp;&nbsp;&nbsp;&nbsp;Nothing</p>");
		}else{
			pageCode.append("<p>Previous:&nbsp;&nbsp;&nbsp;&nbsp;<a href='"+projectContext+"/blog/articles/"+lastBlog.getId()+".html'>"+lastBlog.getTitle()+"</a></p>");
		}
			
		if(nextBlog==null || nextBlog.getId()==null){
			pageCode.append("<p>Next:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Nothing</p>");
		}else{
			pageCode.append("<p>Next:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='"+projectContext+"/blog/articles/"+nextBlog.getId()+".html'>"+nextBlog.getTitle()+"</a></p>");
		}
		return pageCode.toString();
	}
}

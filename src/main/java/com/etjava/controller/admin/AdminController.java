package com.etjava.controller.admin;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.etjava.bean.Blog;
import com.etjava.bean.Status;
import com.etjava.service.BlogService;
import com.etjava.util.ResponseUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/admin/blog")
public class AdminController {

	@Resource
	private BlogService blogService;
	
	/**
	 *  添加或修改博客信息
	 * @param blog
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public String save(Blog blog,HttpServletResponse response) throws Exception {
		Integer total = 0;
		if(blog.getId()==null) {
			// insert
			total = blogService.add(blog);
		}else {
			// update
		}
		
		JSONObject result = new JSONObject();
		if(total>0) {
			result.put("success", true);
		}else {
			result.put("success", false);
			result.put("errorInfo",Status.ERROR_CODE);
		}
		
		ResponseUtil.write(response, result);
		
		return null;
	}
}

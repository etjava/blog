package com.etjava.crawler;

import com.etjava.service.CrawlerBlogService;

/**
 * CNBLOG文章
 * @author etjav
 *
 */
public class CNCrawler {

	public CNCrawler(CrawlerBlogService crawlerBlogService){
		System.out.println("show method 5555555 "+crawlerBlogService.list(null)); 
	}
	
}

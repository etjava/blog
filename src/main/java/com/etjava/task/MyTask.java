package com.etjava.task;

import javax.annotation.Resource;

import com.etjava.crawler.CNCrawler;
import com.etjava.service.CrawlerBlogService;

public class MyTask {

	@Resource
	private CrawlerBlogService crawlerBlogService;
	
	public void show() { 
	    new CNCrawler(crawlerBlogService);
	  } 
	 
//	  public void print() { 
//	    System.out.println("print method 1"); 
//	  } 
}

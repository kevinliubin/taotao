package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 页面跳转Controller
 * <p>Title PageController</p>
 * @author liubin
 * @date 2016年3月14日上午10:01:05
 */
/*
 * 打开首页
 */
@Controller
public class PageController {
	@RequestMapping("/")
	public String showIndex(){
		return "index";
	}
	/*
	 * 展示其他页面
	 */
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page){
		return page;
	}
	
	
} 

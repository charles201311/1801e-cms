package com.bw.cms.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bw.cms.domain.Article;
import com.bw.cms.domain.Category;
import com.bw.cms.domain.Channel;
import com.bw.cms.service.ArticleService;
import com.bw.cms.service.ChannelService;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @ClassName: IndexController 
 * @Description:首页
 * @author: charles
 * @date: 2020年5月6日 下午4:26:58
 */
@Controller
public class IndexController {
	@Resource
	private ChannelService channelService;
	@Resource
	private ArticleService articleService;
	/**
	 * 
	 * @Title: index 
	 * @Description: 进入系统首页
	 * @return
	 * @return: String
	 */
	@RequestMapping(value = {"","/","index"})
	public String index(Model model,Article article,@RequestParam(defaultValue = "1")Integer pageNum,@RequestParam(defaultValue = "5")Integer pageSize) {
		
		model.addAttribute("article", article);//封装查询条件
		
		//1.查询所有的栏目
		List<Channel> channels = channelService.selects();
		model.addAttribute("channels", channels);
		//2.根据栏目id查询所有分类
		List<Category> categorys = channelService.selectCategorysByChannelId(article.getChannelId());
		model.addAttribute("categorys", categorys);
		//3.查询栏目下的文章
		if(article.getChannelId()!=null) {
			PageInfo<Article> info = articleService.selects(article, pageNum, pageSize);
			model.addAttribute("info", info);
		}
		//4.显示热点文章
		if(article.getChannelId()==null) {
			article.setHot(1);//热点文章
			PageInfo<Article> info = articleService.selects(article, pageNum, pageSize);
			model.addAttribute("info", info);
		}
		
		return "index/index";
		
	}

}

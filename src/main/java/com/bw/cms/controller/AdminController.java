package com.bw.cms.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bw.cms.domain.Article;
import com.bw.cms.service.ArticleService;
import com.github.pagehelper.PageInfo;

@RequestMapping("admin")
@Controller
public class AdminController {
	
	@Resource
	private ArticleService articleService;
	/**
	 * 
	 * @Title: index 
	 * @Description: 管理员首页
	 * @return
	 * @return: String
	 */
	@RequestMapping(value = {"","/","index"})
	public String index() {
		
		return "admin/index";
	}

	/**
	 * 
	 * @Title: articles 
	 * @Description: 显示系统所有的文章
	 * @return
	 * @return: String
	 */
	@RequestMapping("articles")
	public String articles(Model model,Article article,@RequestParam(defaultValue = "1")Integer pageNum,@RequestParam(defaultValue = "8")Integer pageSize) {
		//默认显示待审的文章
		if(article.getStatus()==null)
			article.setStatus(0);	
		
		PageInfo<Article> info = articleService.selects(article, pageNum, pageSize);
		model.addAttribute("info", info);
		model.addAttribute("article", article);
		return "admin/articles";
	}
}

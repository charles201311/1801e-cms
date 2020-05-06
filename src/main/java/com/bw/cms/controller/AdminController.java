package com.bw.cms.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bw.cms.domain.Article;
import com.bw.cms.domain.User;
import com.bw.cms.service.ArticleService;
import com.bw.cms.service.UserService;
import com.github.pagehelper.PageInfo;

@RequestMapping("admin")
@Controller
public class AdminController {
	
	@Resource
	private ArticleService articleService;
	@Resource
	private UserService userService;
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
	 * @Title: users 
	 * @Description: 查询所有用户
	 * @param model
	 * @param user
	 * @param pageNum
	 * @param pageSize
	 * @return
	 * @return: String
	 */
	@RequestMapping("users")
	public String users(Model model,User user,@RequestParam(defaultValue = "1")Integer pageNum,@RequestParam(defaultValue = "8")Integer pageSize) {
		
		PageInfo<User> info = userService.selects(user, pageNum, pageSize);
		model.addAttribute("info", info);
		model.addAttribute("user", user);
		
		return "admin/users";
	}
	/**
	 * 
	 * @Title: updateUser
	 * @Description: 更新用户
	 * @param article
	 * @return
	 * @return: boolean
	 */
	@ResponseBody
	@PostMapping("updateUser")
	public boolean updateUpdate(User user) {
	
		return userService.update(user)>0;
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
	
	
	/**
	 * 
	 * @Title: article
	 * @Description: 文章详情
	 * @param id
	 * @return
	 * @return: Article
	 */
	@ResponseBody
	@RequestMapping("article")
	public Article article(Integer id) {
		return articleService.select(id);

	}
	
	/**
	 * 
	 * @Title: updateArticle 
	 * @Description: 更新文章
	 * @param article
	 * @return
	 * @return: boolean
	 */
	@ResponseBody
	@PostMapping("updateArticle")
	public boolean updateArticle(Article article) {
	
		return articleService.update(article)>0;
	}
}

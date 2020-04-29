package com.bw.cms.service;

import com.bw.cms.domain.Article;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @ClassName: ArticleService 
 * @Description: 
 * @author: charles
 * @date: 2020年4月27日 下午4:54:27
 */
public interface ArticleService {
	
	/**
	 * 
	 * @Title: select 
	 * @Description: 文章详情
	 * @param id
	 * @return
	 * @return: Article
	 */
	Article select(Integer id);
	/**
	 * 
	 * @Title: selects 
	 * @Description: 文章列表
	 * @param articles
	 * @param pageNum
	 * @param pageSize
	 * @return
	 * @return: PageInfo<Article>
	 */
	PageInfo<Article> selects(Article articles,Integer pageNum,Integer pageSize);
}

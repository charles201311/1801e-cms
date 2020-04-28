package com.bw.cms.dao;

import java.util.List;

import com.bw.cms.domain.Article;

/**
 * 
 * @ClassName: ArticleMapper 
 * @Description: 文章mapper
 * @author: charles
 * @date: 2020年4月27日 下午4:52:39
 */
public interface ArticleMapper { 
	/**
	 * 
	 * @Title: selects 
	 * @Description: 文章的列表查询
	 * @param articles
	 * @return
	 * @return: List<Article>
	 */
	List<Article> selects(Article articles);
}

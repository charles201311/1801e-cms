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
	 * @Title: update 
	 * @Description: 更新文章
	 * @param article
	 * @return
	 * @return: int
	 */
	int update(Article article);
	/**
	 * 
	 * @Title: insert 
	 * @Description: 增加文章
	 * @param article
	 * @return
	 * @return: int
	 */
	int insert(Article article);
	
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
	 * @Description: 文章的列表查询
	 * @param articles
	 * @return
	 * @return: List<Article>
	 */
	List<Article> selects(Article articles);
	
	/**
	 * 
	 * @Title: selects 
	 * @Description: 按照评论数量显示文章
	 * @param articles
	 * @return
	 * @return: List<Article>
	 */
	List<Article> selectsOrderComments(Article articles);
}

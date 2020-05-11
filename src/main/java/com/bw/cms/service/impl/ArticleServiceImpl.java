package com.bw.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bobo.common.utils.DateUtil;
import com.bw.cms.dao.ArticleMapper;
import com.bw.cms.domain.Article;
import com.bw.cms.service.ArticleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Resource
	ArticleMapper articleMapper;

	@Override
	public PageInfo<Article> selects(Article articles, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Article> list = articleMapper.selects(articles);
		//处理文章发布时间的格式改为 人性化时间  刚刚  1分钟前 1小时前 4个月前  2年前
		 for (Article article : list) {
			 article.setFormateDate(DateUtil.getDisplayTime(article.getCreated()));
		}
		
		return new PageInfo<Article>(list);
	}

	@Override
	public Article select(Integer id) {
		// TODO Auto-generated method stub
		return articleMapper.select(id);
	}

	@Override
	public int insert(Article article) {
		// TODO Auto-generated method stub
		return articleMapper.insert(article);
	}

	@Override
	public int update(Article article) {
		// TODO Auto-generated method stub
		return articleMapper.update(article);
	}

	@Override
	public PageInfo<Article> selectsOrderComments(Article articles,Integer pageNum,Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Article> list = articleMapper.selectsOrderComments(articles);
		
		return new PageInfo<Article>(list);
	}


}

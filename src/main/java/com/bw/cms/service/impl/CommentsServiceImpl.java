package com.bw.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bw.cms.dao.CommentsMapper;
import com.bw.cms.domain.Comments;
import com.bw.cms.service.CommentsService;
import com.bw.cms.util.CMSException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class CommentsServiceImpl implements CommentsService {
	@Resource
	private CommentsMapper commentsMapper;

	@Override
	public boolean insert(Comments comments) {
		try {
			// 1增加评论表
			commentsMapper.insert(comments);
			// 2更新文章表的comments字段，数值递增1
			commentsMapper.updateArticle(comments.getArticleId());
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			throw new CMSException("评论失败");
		}

	}

	@Override
	public PageInfo<Comments> selects(Integer articleId, Integer pageNum, Integer pageSize) {
		 PageHelper.startPage(pageNum, pageSize);
		  List<Comments> list = commentsMapper.selects(articleId);
		  return new PageInfo<Comments>(list);
	}

}

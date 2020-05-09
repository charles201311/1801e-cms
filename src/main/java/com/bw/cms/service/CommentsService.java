package com.bw.cms.service;

import com.bw.cms.domain.Comments;
import com.github.pagehelper.PageInfo;

public interface CommentsService {
	/**
	 * 
	 * @Title: insert 
	 * @Description: 增加评论
	 * @param comments
	 * @return
	 * @return: int
	 */
	boolean insert(Comments comments);
	/**
	 * 
	 * @Title: selects 
	 * @Description: 查询某一个文章的评论
	 * @param articleId
	 * @return
	 * @return: List<Comments>
	 */
	PageInfo<Comments> selects(Integer articleId,Integer pageNum,Integer pageSize);

}

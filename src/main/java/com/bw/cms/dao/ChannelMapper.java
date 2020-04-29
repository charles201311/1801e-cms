package com.bw.cms.dao;

import java.util.List;

import com.bw.cms.domain.Category;
import com.bw.cms.domain.Channel;

/**
 * 
 * @ClassName: ChannelMapper 
 * @Description: 栏目
 * @author: charles
 * @date: 2020年4月29日 下午4:31:14
 */
public interface ChannelMapper {
	/**
	 * 
	 * @Title: selects 
	 * @Description: 查询所有栏目
	 * @return
	 * @return: List<Channel>
	 */
	List<Channel> selects();
	/**
	 * 
	 * @Title: selectCategorysByChannelId 
	 * @Description: 根据栏目查询分类
	 * @param channelId
	 * @return
	 * @return: List<Category>
	 */
	List<Category> selectCategorysByChannelId(Integer channelId);

}

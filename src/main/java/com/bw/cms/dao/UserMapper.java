package com.bw.cms.dao;

import java.util.List;

import com.bw.cms.domain.User;

public interface UserMapper {

	/**
	 * 
	 * @Title: selects 
	 * @Description: 用户列表
	 * @param user
	 * @return
	 * @return: List<User>
	 */
	List<User> selects(User user);
	
	/**
	 * 
	 * @Title: update 
	 * @Description: 修改用户
	 * @param user
	 * @return: void
	 */
	int update(User user);
}

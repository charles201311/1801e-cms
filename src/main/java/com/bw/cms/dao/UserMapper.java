package com.bw.cms.dao;

import java.util.List;

import com.bw.cms.domain.User;

public interface UserMapper {
	/**
	 * 
	 * @Title: selectByName 
	 * @Description: 根据用户名称查询用户
	 * @param username
	 * @return
	 * @return: User
	 */
	User selectByName(String username);
	
	
	/**
	 * 
	 * @Title: insert 
	 * @Description: 注册
	 * @param user
	 * @return
	 * @return: int
	 */
	int insert(User user);
	
	

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

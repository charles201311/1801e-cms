package com.bw.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bw.cms.dao.UserMapper;
import com.bw.cms.domain.User;
import com.bw.cms.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;
	@Override
	public PageInfo<User> selects(User user, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<User> list = userMapper.selects(user);
		
		return new PageInfo<User>(list);
	}

	@Override
	public int update(User user) {
		// TODO Auto-generated method stub
		return userMapper.update(user);
	}

	
}

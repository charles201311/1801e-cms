package com.bw.cms.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bw.cms.domain.Channel;
import com.bw.cms.service.ChannelService;

/**
 * 
 * @ClassName: IndexController 
 * @Description:首页
 * @author: charles
 * @date: 2020年5月6日 下午4:26:58
 */
@Controller
public class IndexController {
	@Resource
	private ChannelService channelService;
	/**
	 * 
	 * @Title: index 
	 * @Description: 进入系统首页
	 * @return
	 * @return: String
	 */
	@RequestMapping(value = {"","/","index"})
	public String index(Model model) {
		
		//1.查询所有的栏目
		List<Channel> channels = channelService.selects();
		model.addAttribute("channels", channels);
		return "index/index";
		
	}

}

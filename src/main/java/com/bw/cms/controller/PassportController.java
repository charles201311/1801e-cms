package com.bw.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bw.cms.domain.User;

/**
 * 
 * @ClassName: PassportController
 * @Description: 登录注册
 * @author: charles
 * @date: 2020年5月8日 上午10:57:49
 */
@Controller
@RequestMapping("passport")
public class PassportController {
	/**
	 * 
	 * @Title: reg
	 * @Description: 去注册
	 * @return
	 * @return: String
	 */
	@GetMapping("reg")
	public String reg() {

		return "passport/reg";

	}
	/**
	 * 
	 * @Title: reg 
	 * @Description: 执行注册
	 * @param user
	 * @return
	 * @return: boolean
	 */
	@ResponseBody
	@PostMapping("reg")
	public boolean reg(User user) {
		
		return true;
		
	}
}

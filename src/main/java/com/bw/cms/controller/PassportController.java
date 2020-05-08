package com.bw.cms.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bw.cms.dao.UserMapper;
import com.bw.cms.domain.User;
import com.bw.cms.service.UserService;
import com.bw.cms.util.CMSException;
import com.bw.cms.util.CMSResult;

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
	
	
	@Resource
	private UserService userService;
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
	public CMSResult<User> reg(User user) {
		CMSResult<User> result =new CMSResult<User>();
		//捕获异常，并封装消息
		try {
		     userService.insert(user);
		     result.setCode(200);
		     result.setMsg("恭喜注册成功,请登录");
			
		} catch (CMSException e) {
			e.printStackTrace();
			result.setCode(300);
			result.setMsg(e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			result.setCode(500);
			result.setMsg("系统崩溃，请联系管理员。");
		}
		return result;
	}
	/**
	 * 
	 * @Title: login 
	 * @Description: 去登录
	 * @return
	 * @return: String
	 */
	@GetMapping("login")
	public String login() {
		return "passport/login";
	}
	/**
	 * 
	 * @Title: login 
	 * @Description: 执行登录
	 * @param user
	 * @return
	 * @return: CMSResult<User>
	 */
	@ResponseBody
	@PostMapping("login")
	public CMSResult<User> login(User user,HttpSession session) {
		CMSResult<User> result =new CMSResult<User>();
		//捕获异常，并封装消息
		try {
		     User u = userService.login(user);
		     session.setAttribute("user", u);//登录成功，存入session
		     result.setCode(200);
		     result.setMsg("恭喜登录成功");
			
		} catch (CMSException e) {
			e.printStackTrace();
			result.setCode(300);
			result.setMsg(e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			result.setCode(500);
			result.setMsg("系统崩溃，请联系管理员。");
		}
		return result;
	}
}

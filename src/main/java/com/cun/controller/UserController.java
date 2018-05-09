package com.cun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cun.bean.User;
import com.cun.dao.UserDao;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserDao userDao;

	/**
	 * 登录拦截，暂未启用
	 * @param userName
	 * @param password
	 * @return
	 */
	@RequestMapping("/login")
	public String login(String userName, String password) {
		User user = userDao.login(userName, password);
		if (user != null) {
			System.out.println("有");
			return "main";
		} else {
			System.out.println("没");
			return "fail";
		}
	}
	
	/**
	 * 主页右上角显示博主个人信息
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/usermsg")
	public User userMessage() {
		return userDao.findOne(1);//个人信息只有一个，除非做成一个社区，才改1为n
	}
}

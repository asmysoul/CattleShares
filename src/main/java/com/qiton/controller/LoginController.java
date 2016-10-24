package com.qiton.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.qiton.exception.BussinessException;
import com.qiton.model.Admin;
import com.qiton.model.User;
import com.qiton.service.IAdminService;
import com.qiton.service.IUserService;
import com.qiton.service.impl.AdminServiceImpl;

/**
 * 登录
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController{
	
	@Autowired
	private IAdminService adminService;
	
	@Autowired
	private IUserService userservice;
	
	/**
	 * 后台登录验证
	 * @param admin
	 * @param request
	 * @return
	 */
	@RequestMapping("/login")
	@ResponseBody
	public Object login(Admin admin,HttpServletRequest request){
		HttpSession session=request.getSession();
		try{
			Admin selectadmin=adminService.login(admin);
			session.setAttribute("current_admin", selectadmin);
		}catch(BussinessException e){
			e.printStackTrace();
			return renderError(e.getLocalizedMessage());
		}
		return renderSuccess();
	}
	
	
	/**
	 * 用户登录验证
	 * @param user
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/userLogin")
	public Object userlogin(User user,HttpServletRequest request){
		HttpSession session=request.getSession();
		try{
			User selectUser=userservice.userlogin(user);
			session.setAttribute("current_user",selectUser);
		}catch(BussinessException e){
			e.printStackTrace();
			return renderError(e.getLocalizedMessage());
		}
		return renderSuccess();
	}
	
	
}

package com.qiton.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qiton.exception.BussinessException;

/**
 * 用户管理模块
 * @author yqc
 *
 */
@RequestMapping("/userManager")
public class UserManagerController extends BaseController{
	
	
	
	@RequestMapping("/getallUser")
	@ResponseBody
	public Object getAllUser(HttpServletRequest request){
		try{
			
		}catch(BussinessException e){
			e.printStackTrace();
			renderError(e.getLocalizedMessage());
		}catch (Exception e) {
			renderError("访问失败请重试");
		}
		return request;
	}
}

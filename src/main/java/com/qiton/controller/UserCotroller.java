/******************************************************************
 *
 *    
 *
 *    Copyright (c) 2016-forever 
 *    http://www.fzqblog.top
 *
 *    Package:     com.qiton.controller
 *
 *    Filename:    UserCotroller.java
 *
 *    Description: TODO(用一句话描述该文件做什么)
 *
 *    Copyright:   Copyright (c) 2001-2014
 *
 *    Company:     fzqblog
 *
 *    @author:     抽离
 *
 *    @version:    1.0.0
 *
 *    Create at:   2016年10月21日 下午5:10:05
 *
 *    Revision:
 *
 *    2016年10月21日 下午5:10:05
 *        - first revision
 *
 *****************************************************************/
package com.qiton.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.plugins.Page;
import com.qiton.exception.BussinessException;
import com.qiton.model.SelectOptionTime;
import com.qiton.model.User;
import com.qiton.model.VipManage;
import com.qiton.service.ISmsService;
import com.qiton.service.IUserService;
import com.qiton.utils.Config;
import com.qiton.utils.StringUtils;

/**
 * @ClassName UserCotroller
 * @Description TODO用户注册控制层
 * @author 抽离
 * @Date 2016年10月21日 下午5:10:05
 * @version 1.0.0
 */
@Controller
@RequestMapping("/user")
public class UserCotroller extends BaseController{
	
    private static final Logger LOGGER = LogManager.getLogger(UserCotroller.class);
	
    private static HttpSession currentsession;
    
	@Autowired
	private ISmsService smsService;
	
	@Autowired
	private IUserService userService;
	
	
	/**
	 * @author 抽离
	 * @Description 用户注册时填写手机号发送验证码
	 * @param phone 用户手机号
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("sendSms")
	public Object sendSms(String phone, 
			HttpSession session){
		currentsession=session;
		String validateCode = StringUtils.getRandomCode();
		session.setAttribute("validateCode", validateCode);
		try{
			smsService.sendSms(phone, validateCode);
			currentsession.setAttribute("rightValidateCode", validateCode);
		}catch(BussinessException e){
			LOGGER.info(phone + "----" + e.getLocalizedMessage());
			return renderError(e.getLocalizedMessage());
		}
		return renderSuccess();
	}
	
	
	
	
	
	/**
	 * 
	 * @author 抽离
	 * @Description 注册用户
	 * @param user
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("regist")
	public Object regist(User user,String sessionId,HttpSession session){
		try{
			this.userService.regist(user, (String) currentsession.getAttribute("rightValidateCode"));
		}catch(BussinessException e){
			LOGGER.info(e.getLocalizedMessage());
			return renderError(user.getPhone() + "----" + e.getLocalizedMessage());
		}catch (Exception e) {
			LOGGER.info(user.getPhone() + "----" + e.getLocalizedMessage());
			return renderError("注册失败请重试");
		}
		return renderSuccess();
	}
	
	
	/**
	 * 
	* @Title: getUserList 
	* @Description: 会员管理
	* @author 尤
	* @date 2016年11月14日 上午11:03:57  
	* @param @param current
	* @param @param request
	* @param @return    设定文件 
	* @return Object    返回类型 
	* @throws
	 */
	@RequestMapping("/getUserList")
	@ResponseBody
	public Object getUserList(String current, HttpServletRequest request) {
		Page<User> page2 = new Page<User>(Integer.parseInt(current), Config.PAGENUM);
		try{
			userService.selectVipList(page2);
		} catch (BussinessException e) {
			e.printStackTrace();
			return renderError(e.getLocalizedMessage());
		} catch (Exception e) {
			return  renderError("访问失败请重试");
		}
		return renderSuccess(page2);
	}
	
	/**
	 * 
	* @Title: selectByCommandUser 
	* @Description: 条件查询会员用户
	* @author 尤
	* @date 2016年11月14日 上午11:27:59  
	* @param @param user
	* @param @param current
	* @param @param request
	* @param @return    设定文件 
	* @return Object    返回类型 
	* @throws
	 */
	@RequestMapping("/selectByCommandUser")
	@ResponseBody
	public Object selectByCommandUser(User user,String current,HttpServletRequest request){
		Page<User> page2=new Page<User>(Integer.parseInt(current), Config.PAGENUM);
		try{
			userService.selectByCommandUser(user,page2);
		}catch(BussinessException e){
			LOGGER.info("查询错误");
			return renderError(e.getLocalizedMessage());
		}catch (Exception e) {
			LOGGER.info("查询错误");
			return renderError(e.getLocalizedMessage());
		}
		
		return renderSuccess(page2);
	}
	
	
	/**
	 * 
	* @Title: getSelectUserSatate 
	* @Description: 财户类型查询用户
	* @author 尤
	* @date 2016年11月14日 上午11:27:52  
	* @param @param page
	* @param @param userState
	* @param @param request
	* @param @return    设定文件 
	* @return Object    返回类型 
	* @throws
	 */
	@RequestMapping("/getSelectUserByType")
	@ResponseBody
	public Object getSelectUserByType(String current,String accountType, HttpServletRequest request) {
		Page<User> page2 = new Page<User>(Integer.parseInt(current), Config.PAGENUM);
		try {
			userService.getSelectUserByType(page2, accountType);
		} catch (BussinessException e) {
			e.printStackTrace();
			return renderError(e.getLocalizedMessage());
		} catch (Exception e) {
			return  renderError("访问失败请重试-"+e.getLocalizedMessage());
		}
		return renderSuccess(page2);
	}
	
	
	@RequestMapping("/getSelectTime")
	@ResponseBody
	public Object getSelectVIPUserByTime(String current,SelectOptionTime optionTime, HttpServletRequest request) {
		Page<User> page2 = new Page<User>(Integer.parseInt(current), Config.PAGENUM);
		try {
			System.out.println("----"+optionTime.toString());
			userService.getSelectVIPUserByTime(page2, optionTime);
		} catch (BussinessException e) {
			e.printStackTrace();
			return renderError(e.getLocalizedMessage());
		} catch (Exception e) {
			return  renderError("访问失败请重试-"+e.getLocalizedMessage());
		}
		return renderSuccess(page2);
	}
	
	/**
	 * 
	* @Title: Update_UserInfo 
	* @Description: 会员管理操作
	* @author 尤
	* @date 2016年11月7日 上午11:13:48  
	* @param @param user
	* @param @param request
	* @param @return    设定文件 
	* @return Object    返回类型 
	* @throws
	 */
	@RequestMapping("/Update_VIPUserInfo")
	@ResponseBody
	public Object Update_VIPUserInfo(User user,HttpServletRequest request){
		try{
			userService.updateVIPUser_Info(user);
		}catch(BussinessException e){
			e.printStackTrace();
			LOGGER.info("--修改会员信息失败---------" + e.getLocalizedMessage());
			return renderError(e.getLocalizedMessage());
		}catch (Exception e) {
			e.printStackTrace();
			LOGGER.info("--修改会员信息失败---------" + e.getLocalizedMessage());
			return renderError("修改会员信息失败");
		}
		return renderSuccess("修改会员信息成功");
	}
	
	/**
	 * 
	* @Title: gotMember_account 
	* @Description: 跳转到会员管理页面
	* @author 尤
	* @date 2016年11月15日 上午9:11:04  
	* @param @param request
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	@RequestMapping("/gotMember_account")
	public String gotMember_account(HttpServletRequest request){
	return "member-account";
	}
	
}

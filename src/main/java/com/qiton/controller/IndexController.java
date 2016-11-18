/******************************************************************
 *
 *    
 *
 *    Copyright (c) 2016-forever 
 *    http://www.fzqblog.top
 *
 *    Package:     com.qiton.controller
 *
 *    Filename:    IndexController.java
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
 *    Create at:   2016年11月8日 上午10:50:51
 *
 *    Revision:
 *
 *    2016年11月8日 上午10:50:51
 *        - first revision
 *
 *****************************************************************/
package com.qiton.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
* @ClassName: IndexController 
* @Description: 页面跳转模块 
* @author 尤
* @date 2016年11月17日 下午4:20:34 
*
 */
@Controller
public class IndexController extends BaseController{

	/**
	 * 
	* @Title: index 
	* @Description: 登录页
	* @author 尤
	* @date 2016年11月18日 上午9:45:46  
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	@RequestMapping("/")
	public String index() {
		return "login";
	}
	
	/**
	 * 
	* @Title: main 
	* @Description: 主页面
	* @author 尤
	* @date 2016年11月18日 上午9:45:56  
	* @param @param request
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	@RequestMapping("/index")
	public String main(HttpServletRequest request){
		return "/index";
	}
	
	/**
	 * 
	* @Title: gotTechListJsp 
	* @Description: 老师管理页面
	* @author 尤
	* @date 2016年11月18日 上午9:58:27  
	* @param @param request
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	 @RequestMapping("/gotTechListJsp")
	    public String gotTechListJsp(HttpServletRequest request){
			return "/teacher-manage";
	    }
	
	 /**
	  * 
	 * @Title: addServerJsp 
	 * @Description: 客服管理页面
	 * @author 尤
	 * @date 2016年11月18日 上午10:38:22  
	 * @param @param request
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	  */
	 @RequestMapping("/addServer")
		public String addServerJsp(HttpServletRequest request){
			return "/addserver";
		}
	 
	 
	 /**
		 * 
		* @Title: gotGoldRecordManageJsp 
		* @Description: 跳转到邀请管理页面
		* @author 尤
		* @date 2016年11月16日 上午10:14:31  
		* @param @param request
		* @param @return    设定文件 
		* @return String    返回类型 
		* @throws
		 */
		@RequestMapping("/gotGoldRecordManageJsp")
		public String gotGoldRecordManageJsp(HttpServletRequest request){
			return "GoldRecordController";
		}
		
		
		
		/**
		 * 
		* @Title: gotInviteManageJsp 
		* @Description: 跳转到邀请管理页面
		* @author 尤
		* @date 2016年11月16日 上午10:14:31  
		* @param @param request
		* @param @return    设定文件 
		* @return String    返回类型 
		* @throws
		 */
		@RequestMapping("/gotInviteManageJsp")
		public String gotInviteManageJsp(HttpServletRequest request){
			return "invaite-manage";
		}
		
		
		/**
		 * 
		* @Title: gotmarkRecodeManageJsp 
		* @Description: 跳转到邀请管理页面
		* @author 尤
		* @date 2016年11月16日 上午10:14:31  
		* @param @param request
		* @param @return    设定文件 
		* @return String    返回类型 
		* @throws
		 */
		@RequestMapping("/gotmarkRecodeManageJsp")
		public String gotmarkRecodeManageJsp(HttpServletRequest request){
			return "MarkRecordController";
		}
		
		/**
		 * 
		* @Title: gotReference 
		* @Description: 跳转到内参管理页面
		* @author 尤
		* @date 2016年11月18日 上午10:55:36  
		* @param @param request
		* @param @return    设定文件 
		* @return String    返回类型 
		* @throws
		 */
		@RequestMapping("/reference")
		public String gotReference(HttpServletRequest request){
			return "publishMessage";
		}
		
		/**
		 * 
		* @Title: gotReflectRecodeManageJsp 
		* @Description: 跳转到邀请管理页面
		* @author 尤
		* @date 2016年11月16日 上午10:14:31  
		* @param @param request
		* @param @return    设定文件 
		* @return String    返回类型 
		* @throws
		 */
		@RequestMapping("/gotReflectRecodeManageJsp")
		public String gotReflectRecodeManageJsp(HttpServletRequest request){
			return "ReflectRecode";
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
		
		
		/**
		 * 
		* @Title: gotMember_Manage 
		* @Description: 资金管理页面
		* @author 尤
		* @date 2016年11月9日 上午10:55:11  
		* @param @param request
		* @param @return    设定文件 
		* @return String    返回类型 
		* @throws
		 */
		@RequestMapping("/gotMember_Manage")
		public String gotMember_Manage(HttpServletRequest request){
			return "/member-manage";
		}
		
		/**
		 * 
		* @Title: gotInviteManageJsp 
		* @Description: 跳转到会员记录页面
		* @author 尤
		* @date 2016年11月16日 上午10:14:31  
		* @param @param request
		* @param @return    设定文件 
		* @return String    返回类型 
		* @throws
		 */
		@RequestMapping("/gotVipRecordJsp")
		public String gotVipRecordJsp(HttpServletRequest request){
			return "Viprecord";
		}
	
}

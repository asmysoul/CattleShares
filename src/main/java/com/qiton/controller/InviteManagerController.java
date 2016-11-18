package com.qiton.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.plugins.Page;
import com.qiton.exception.BussinessException;
import com.qiton.model.Invite;
import com.qiton.model.SelectOptionTime;
import com.qiton.model.VipManage;
import com.qiton.service.IInviteService;
import com.qiton.service.IUserService;
import com.qiton.utils.Config;

/**
 * 
* @ClassName: InviteManagerController 
* @Description: 邀请管理 
* @author 尤
* @date 2016年11月15日 上午11:11:38 
*
 */
@Controller
@RequestMapping("/inviteManager")
public class InviteManagerController extends BaseController {
	
	private static final Logger log=LogManager.getLogger(InviteManagerController.class);
	
	@Autowired
	private IInviteService iInviteService;
	
	
	/**
	 * 
	* @Title: getInviteList 
	* @Description: 获取邀请列表
	* @author 尤
	* @date 2016年11月15日 上午11:14:06  
	* @param @param current
	* @param @param request
	* @param @return    设定文件 
	* @return Object    返回类型 
	* @throws
	 */
	@RequestMapping("/getInviteList")
	@ResponseBody
	public Object getInviteList(String current,HttpServletRequest request){
		Page<Invite> page=new Page<>(Integer.parseInt(current), Config.PAGENUM);
		try{
			iInviteService.getInviteList(page);
		}catch(BussinessException e){
			log.info(e.getLocalizedMessage());
			return renderError("数据查询出错"+e.getLocalizedMessage());
		}catch (Exception e) {
			// TODO: handle exception
			log.info(e.getLocalizedMessage());
			return renderError("数据查询出错"+e.getLocalizedMessage());
		}
		return renderSuccess(page);
	}
	
	/**
	 * 
	* @Title: getSelectTime 
	* @Description: 根据时间区间获得邀请列表
	* @author 尤
	* @date 2016年11月15日 上午11:28:20  
	* @param @param current
	* @param @param optionTime
	* @param @param request
	* @param @return    设定文件 
	* @return Object    返回类型 
	* @throws
	 */
	@RequestMapping("/getInviteByTime")
	@ResponseBody
	public Object getInviteByTime(String current,SelectOptionTime optionTime, HttpServletRequest request) {
		Page<Invite> page2 = new Page<Invite>(Integer.parseInt(current), Config.PAGENUM);
		try {
			iInviteService.getInviteByTime(page2, optionTime);
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
		 * @Title: getAllUser @Description:根据用户状态获得用户列表 @author 尤 @date 2016年10月26日
		 * 上午10:37:35 @param @param current @param @param request @param @return
		 * 设定文件 @return Object 返回类型 @throws
		 */
		@RequestMapping("/getInviteSatate")
		@ResponseBody
		public Object getInviteSatate(String current,String acceptuserstate, HttpServletRequest request) {
			Page<Invite> page2 = new Page<Invite>(Integer.parseInt(current), Config.PAGENUM);
			try {
				iInviteService.getInviteSatate(page2, acceptuserstate);
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
		* @Title: selectByCommand 
		* @Description: 条件查询
		* @author 尤
		* @date 2016年11月7日 上午11:13:20  
		* @param @param user
		* @param @param page
		* @param @param request
		* @param @return    设定文件 
		* @return Object    返回类型 
		* @throws
		 */
		@RequestMapping("/getInviteByCommand")
		@ResponseBody
		public Object getInviteByCommand(Invite invite,String current,HttpServletRequest request){
			Page<Invite> page2=new Page<Invite>(Integer.parseInt(current), Config.PAGENUM);
			try{
				iInviteService.getInviteByCommand(invite,page2);
			}catch(BussinessException e){
				log.info("查询错误");
				return renderError(e.getLocalizedMessage());
			}catch (Exception e) {
				log.info("查询错误");
				return renderError(e.getLocalizedMessage());
			}
			
			return renderSuccess(page2);
		}
	
}

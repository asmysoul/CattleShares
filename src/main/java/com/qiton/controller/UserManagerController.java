package com.qiton.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.plugins.Page;
import com.qiton.exception.BussinessException;
import com.qiton.model.Invite;
import com.qiton.model.Teacher;
import com.qiton.model.User;
import com.qiton.service.IInviteService;
import com.qiton.service.IUserService;
import com.qiton.utils.Config;
import com.sun.xml.internal.xsom.impl.scd.Iterators.Map;

/**
 *
 * @ClassName: UserManagerController
 * @Description: 用户管理功能模块
 * @author 尤
 * @date 2016年10月26日 上午10:34:20
 *
 */
@RequestMapping("/userManager")
public class UserManagerController extends BaseController {

	private static final Logger log = LogManager.getLogger(UserManagerController.class);

	@Autowired
	private IInviteService inviteService;// 邀请

	@Autowired
	private IUserService userService;// 用户

	/**
	 * 
	 * @Title: getAllUser @Description:获得用户列表 @author 尤 @date 2016年10月26日
	 * 上午10:37:35 @param @param current @param @param request @param @return
	 * 设定文件 @return Object 返回类型 @throws
	 */
	@RequestMapping("/getallUser")
	@ResponseBody
	public Object getAllUser(Integer current, HttpServletRequest request) {
		Page<Invite> page = new Page<>(0, Config.PAGENUM);
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		try {
			Page<Invite> pages = inviteService.selectPage(page, null);
			List<Invite> invitelist = pages.getRecords();
			System.out.println("--------" + invitelist.size());
			HashMap<String, Object> map = null;
			for (Invite invite : invitelist) {
				map = new HashMap<String, Object>();
				Invite entity = new Invite();
				entity.setInviUsername(invite.getInviUsername());
				// 通过邀请人取得邀请数量
				int count = inviteService.selectCount(entity);
				System.out.println("-----count----" + count);

				User accinviteuser = new User();
				accinviteuser.setUserName(invite.getInviAcceptuser());
				User acceptinviteInfo = userService.selectOne(accinviteuser);
				System.out.println("----acceptinviteInfo-------" + acceptinviteInfo.toString());

				User inviteuser = new User();
				inviteuser.setUserName(invite.getInviUsername());
				User inviteUserInfo = userService.selectOne(inviteuser);
				System.out.println("-----inviteUserInfo------" + inviteUserInfo.toString());
				map.put("inviteCount", count);
				map.put("acceptinviteUser", acceptinviteInfo);
				map.put("inviteUser", inviteUserInfo);
				list.add(map);
			}
			System.out.println("-----------------" + list.toString());
		} catch (BussinessException e) {
			e.printStackTrace();
			renderError(e.getLocalizedMessage());
		} catch (Exception e) {
			renderError("访问失败请重试");
		}
		return request;
	}

	/**
	 * @Title: getCurrentUserCapital @Description: 取得用户资金 @author 尤 @date
	 * 2016年10月26日 上午10:37:54 @param @param acceptId @param @param
	 * request @param @return 设定文件 @return Object 返回类型 @throws
	 */
	@RequestMapping("/getCapital")
	@ResponseBody
	public Object getCurrentUserCapital(String acceptId, HttpServletRequest request) {
		User user = null;
		try {
			user = userService.getCurrentUser(acceptId);
		} catch (BussinessException e) {
			e.printStackTrace();
			log.info("----获取数据出错----" + e.getLocalizedMessage());
			renderError(e.getLocalizedMessage());
		} catch (Exception e) {
			e.printStackTrace();
			log.info("----获取数据出错----" + e.getLocalizedMessage());
			renderError("-获取数据出错");
		}
		return renderSuccess(user);
	}

	/**
	 * 
	 * @Title: Capital_Operation @Description: 资金操作 @author 尤 @date 2016年10月26日
	 * 上午11:01:25 @param @param currentMark @param @param
	 * currentGold @param @param operId @param @param capiId @param @param
	 * money @param @param remark @param @param request @param @return
	 * 设定文件 @return Object 返回类型 @throws
	 */
	public Object Capital_Operation(User user, String operId, String capiId,
			 String money, String remark, HttpServletRequest request) {
		try {
			userService.updateUserCaptical(user, operId, capiId, money, remark);
		} catch (BussinessException e) {
			e.printStackTrace();
			log.info("-----资金操作失败------" + e.getLocalizedMessage());
			renderError(e.getLocalizedMessage());
		} catch (Exception e) {
			e.printStackTrace();
			log.info("--资金操作失败---------" + e.getLocalizedMessage());
			renderError("资金操作失败");
		}
		return renderSuccess("操作成功");
	}

	/**
	 * 
	* @Title: VIP_Delay 
	* @Description: 会员延期
	* @author 尤
	* @date 2016年10月26日 下午3:24:34  
	* @param @param current_Id
	* @param @param endvip_time
	* @param @param delay_time
	* @param @param request
	* @param @return    设定文件 
	* @return Object    返回类型 
	* @throws
	 */
	public Object VIP_Delay(User user,String delay_time, HttpServletRequest request) {
		try {
			userService.updateVIP_Del( user, delay_time);
		} catch (BussinessException e) {
			e.printStackTrace();
			log.info("--会员延期失败---------" + e.getLocalizedMessage());
			renderError(e.getLocalizedMessage());
		} catch (Exception e) {
			e.printStackTrace();
			log.info("--会员延期失败---------" + e.getLocalizedMessage());
			renderError("会员延期失败");
		}
		return renderSuccess("延期成功");
	}
	
	
	public Object Update_UserInfo(User user,HttpServletRequest request){
		try{
			userService.updateUser_Info(user);
		}catch(BussinessException e){
			e.printStackTrace();
			log.info("--修改用户信息失败---------" + e.getLocalizedMessage());
			renderError(e.getLocalizedMessage());
		}catch (Exception e) {
			e.printStackTrace();
			log.info("--修改用户信息失败---------" + e.getLocalizedMessage());
			renderError("修改用户信息失败");
		}
		return renderSuccess("修改用户信息成功");
	}
	
	

}

package com.qiton.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baomidou.mybatisplus.annotations.TableField;
import com.qiton.exception.BussinessException;
import com.qiton.service.IUserService;

/**
 * 
* @ClassName: PersonController 
* @Description: App 个人中心 
* @author 尤
* @date 2016年11月18日 下午3:35:57 
*
 */
@Controller
@RequestMapping("/person")
public class PersonController extends BaseController{
	
	private static final Logger log=LogManager.getLogger(PersonController.class);
	
	@Autowired
	private IUserService userService;
	
	/**
	 * 
	* @Title: Bind_withdrawal 
	* @Description: 提现绑定
	* @author 尤
	* @date 2016年11月18日 下午3:52:52  
	* @param @param userId
	* @param @param accountType   账户类型：0:财付通，1：支付宝 2：银行
	* @param @param reflectAccount   体现账户
	* @param @param realName    实名认证姓名
	* @param @param request
	* @param @return    设定文件 
	* @return Object    返回类型 
	* @throws
	 */
	public Object Bind_withdrawal(String userId,String accountType,String reflectAccount,String realName, HttpServletRequest request){
		try{
			userService.Bind_withdrawal(userId, accountType, reflectAccount, realName);
		}catch(BussinessException e){
			log.info("绑定失败-"+e.getLocalizedMessage());
			return renderError("绑定失败-"+e.getLocalizedMessage());
		}catch (Exception e) {
			log.info("绑定失败-"+e.getLocalizedMessage());
			return renderError("绑定失败-"+e.getLocalizedMessage());
		}
		return renderSuccess("绑定成功");
	}
	
	/**
	 * 
	* @Title: VIP_renew 
	* @Description: TODO
	* @author 尤
	* @date 2016年11月18日 下午4:33:06  
	* @param @param userId
	* @param @param gold       :金币
	* @param @param mark      ：积分
	* @param @param request
	* @param @return    设定文件 
	* @return Object    返回类型 
	* @throws
	 */
	public Object VIP_renew(String userId,String gold,String mark,HttpServletRequest request){
		try{
			userService.VIP_renew(userId,gold,mark);
		}catch(BussinessException e){
			log.info("会员续费失败-"+e.getLocalizedMessage());
			return renderError("会员续费失败-"+e.getLocalizedMessage());
		}catch (Exception e) {
			log.info("会员续费失败-"+e.getLocalizedMessage());
			return renderError("会员续费失败-"+e.getLocalizedMessage());
		}
		return request;
	}
}

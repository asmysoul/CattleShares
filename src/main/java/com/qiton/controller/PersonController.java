package com.qiton.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.annotations.TableField;
import com.qiton.exception.BussinessException;
import com.qiton.service.IUserService;

/**
 * 
* @ClassName: PersonController 
* @Description: App 个人中心 
* @author 尤
* @date 2016年11月18日 下午3:35:57 
*·
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
	* 
	 */
	@RequestMapping("/Bind_withdrawal")
	@ResponseBody
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
	* @Description: 续费操作
	* @author 尤
	* @date 2016年11月18日 下午4:33:06  
	* @param @param userId
	* @param @param gold       :金币
	* @param @param mark      ：积分
	* @param @param request
	* @param @return    设定文件 
	* @return Object    返回类型 
	* @throws
	* http://localhost:8080/CattleShares/person/VIP_renew?userId=2&gold=299&mark=1000
	 */
	@RequestMapping("/VIP_renew")
	@ResponseBody
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
		return renderSuccess();
	}
	
	
	/**
	 * 
	* @Title: FriendInvite 
	* @Description: 好友邀请
	* @author 尤
	* @date 2016年11月21日 上午9:00:37  
	* @param @param username
	* @param @param request
	* @param @return    设定文件 
	* @return Object    返回类型 
	* @throws
	* 
	* http://localhost:8080/CattleShares/person/FriendInvite?username=zhangsan
	* {"success":true,"vip":false,"msg":"","obj":[{"suminvite":{"inviteCount":2,"sumGold":30,"sumMark":30},"inviteList":[{"inviId":1,"inviUsername":"zhangsan","inviAcceptuserid":2,"inviAcceptuser":"maimai","inviAcceptmobile":"18158534652","inviRegisttime":"2016-10-25 00:00:00","inviAcceptuserstate":0,"inviGold":10,"inviMark":10,"inviRecharge":null},{"inviId":3,"inviUsername":"zhangsan","inviAcceptuserid":3,"inviAcceptuser":"lisi","inviAcceptmobile":"18156980164","inviRegisttime":"2016-11-21 00:00:00","inviAcceptuserstate":0,"inviGold":20,"inviMark":20,"inviRecharge":null}]}]}
	* 
	* 
	 */
	@RequestMapping("/FriendInvite")
	@ResponseBody
	public Object FriendInvite(String username,HttpServletRequest request){
		List<Object> list = null;
		try{
			 list=userService.FriendInvite(username);
		}catch(BussinessException e){
			log.info("获取邀请数据失败---"+e.getLocalizedMessage());
			renderError("获取邀请数据失败---"+e.getLocalizedMessage());
		}catch (Exception e) {
			log.info("获取邀请数据失败---"+e.getLocalizedMessage());
			renderError("获取邀请数据失败---"+e.getLocalizedMessage());
		}
		
		return renderSuccess(list);
	}
}

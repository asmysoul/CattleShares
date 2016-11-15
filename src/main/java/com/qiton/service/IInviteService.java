package com.qiton.service;

import com.qiton.exception.BussinessException;
import com.qiton.model.Invite;
import com.qiton.model.SelectOptionTime;
import com.qiton.model.VipManage;
import com.baomidou.framework.service.ISuperService;
import com.baomidou.mybatisplus.plugins.Page;

/**
 *
 * Invite 表数据服务层接口
 *
 */
public interface IInviteService extends ISuperService<Invite> {

	/**
	 * 
	* @Title: getInviteList 
	* @Description: 获取邀请列表
	* @author 尤
	* @date 2016年11月15日 上午11:21:26  
	* @param @param page    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void getInviteList(Page<Invite> page)throws BussinessException;

	
	/**
	 * 
	* @Title: getInviteByTime 
	* @Description: 根据时间区间获取邀请列表
	* @author 尤
	* @date 2016年11月15日 下午1:37:27  
	* @param @param page2
	* @param @param optionTime    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void getInviteByTime(Page<Invite> page2, SelectOptionTime optionTime);

	/**
	 * 
	* @Title: getInviteSatate 
	* @Description: 根据会员状态获取邀请列表
	* @author 尤
	* @date 2016年11月15日 下午1:39:02  
	* @param @param page2
	* @param @param userState    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void getInviteSatate(Page<Invite> page2, String acceptuserstate);


	public void getInviteByCommand(Invite invite, Page<Invite> page2);

	
}
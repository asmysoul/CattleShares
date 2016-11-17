package com.qiton.service;

import com.qiton.exception.BussinessException;
import com.qiton.model.Invite;
import com.qiton.model.SelectOptionTime;
import com.qiton.model.VipRecord;
import com.baomidou.framework.service.ISuperService;
import com.baomidou.mybatisplus.plugins.Page;

/**
 *
 * VipRecord 表数据服务层接口
 *
 */
public interface IVipRecordService extends ISuperService<VipRecord> {

	/**
	 * 
	* @Title: getVipRecordList 
	* @Description: 获取会员记录
	* @author 尤
	* @date 2016年11月16日 上午9:43:34  
	* @param @param page
	* @param @throws BussinessException    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void getVipRecordList(Page<VipRecord> page)throws BussinessException;

	/**
	 * 
	* @Title: insertVipRecord 
	* @Description: 新增会员记录
	* @author 尤
	* @date 2016年11月16日 上午9:53:39  
	* @param @param vipRecord
	* @param @throws BussinessException    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void insertVipRecord(VipRecord vipRecord)throws BussinessException;

	/**
	 * 
	* @Title: getVipRecordByCommand 
	* @Description: 条件查询
	* @author 尤
	* @date 2016年11月16日 上午10:06:30  
	* @param @param page
	* @param @param vipRecord    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void getVipRecordByCommand(Page<VipRecord> page, VipRecord vipRecord)throws BussinessException;
	
	/**
	 * 
	* @Title: getVipRecordByTime 
	* @Description: 根据时间查询会员记录
	* @author 尤
	* @date 2016年11月17日 上午8:51:19  
	* @param @param invite
	* @param @param page2    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void getVipRecordByTime(Page<VipRecord> page, SelectOptionTime optionTime)throws BussinessException;
	
}
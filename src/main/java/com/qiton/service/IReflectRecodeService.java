package com.qiton.service;

import com.qiton.exception.BussinessException;
import com.qiton.model.ReflectManager;
import com.qiton.model.ReflectRecode;
import com.qiton.model.SelectOptionTime;
import com.baomidou.framework.service.ISuperService;
import com.baomidou.mybatisplus.plugins.Page;

/**
 *
 * ReflectRecode 表数据服务层接口
 *
 */
public interface IReflectRecodeService extends ISuperService<ReflectRecode> {

	/**
	 * 
	* @Title: getReflectRecodeList 
	* @Description: 获取提现记录列表
	* @author 尤
	* @date 2016年11月17日 下午2:24:53  
	* @param @param page
	* @param @throws BussinessException    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void getReflectRecodeList(Page<ReflectRecode> page)throws BussinessException;

	/**
	 * 
	* @Title: ReflectRecodeByTime 
	* @Description: 通过时间区间获取提现记录
	* @author 尤
	* @date 2016年11月17日 下午2:25:13  
	* @param @param page2
	* @param @param optionTime
	* @param @throws BussinessException    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void ReflectRecodeByTime(Page<ReflectRecode> page2, SelectOptionTime optionTime)throws BussinessException;

	/**
	 * 
	* @Title: getReflectRecodeProfittype 
	* @Description: 通过账户状态获取提现记录列表
	* @author 尤
	* @date 2016年11月17日 下午2:25:29  
	* @param @param page2
	* @param @param profittype
	* @param @throws BussinessException    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void getReflectRecodeProfittype(Page<ReflectRecode> page2, String profittype)throws BussinessException;

	/**
	 * 
	* @Title: getReflectRecodeByCommand 
	* @Description: 条件查询获取体现记录列表
	* @author 尤
	* @date 2016年11月17日 下午2:25:54  
	* @param @param reflectRecode
	* @param @param page2
	* @param @throws BussinessException    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void getReflectRecodeByCommand(ReflectRecode reflectRecode, Page<ReflectRecode> page2)throws BussinessException;

	/**
	 * 
	* @Title: getReflectManagerList 
	* @Description: 获取体现管理列表
	* @author 尤
	* @date 2016年11月17日 下午2:26:14  
	* @param @param page    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void getReflectManagerList(Page<ReflectManager> page);

	/**
	 * 
	* @Title: getSelectTime 
	* @Description: 通过时间区间获取提现管理列表
	* @author 尤
	* @date 2016年11月17日 下午3:12:56  
	* @param @param page2
	* @param @param optionTime    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void getSelectTime(Page<ReflectManager> page2, SelectOptionTime optionTime);

	/**
	 * 
	* @Title: getSelectSatate 
	* @Description: 通过处理状态获取列表
	* @author 尤
	* @date 2016年11月17日 下午3:15:14  
	* @param @param page2
	* @param @param userState    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void getSelectSatate(Page<ReflectManager> page2, String userState);

	/**
	 * 
	* @Title: selectReflectByCommand 
	* @Description: 条件查询
	* @author 尤
	* @date 2016年11月17日 下午3:16:48  
	* @param @param reflectManager
	* @param @param page2    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void selectReflectByCommand(ReflectManager reflectManager, Page<ReflectManager> page2);


}
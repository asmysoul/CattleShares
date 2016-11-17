package com.qiton.mapper;

import com.qiton.model.ReflectManager;
import com.qiton.model.ReflectRecode;
import com.qiton.model.SelectOptionTime;

import java.util.List;

import com.baomidou.mybatisplus.mapper.AutoMapper;
import com.baomidou.mybatisplus.plugins.Page;

/**
 *
 * ReflectRecode 表数据库控制层接口
 *
 */
public interface ReflectRecodeMapper extends AutoMapper<ReflectRecode> {

	/**
	 * 
	* @Title: getReflectManagerList 
	* @Description: 分页获取体现管理列表
	* @author 尤
	* @date 2016年11月17日 下午2:30:33  
	* @param @param page
	* @param @return    设定文件 
	* @return List<ReflectManager>    返回类型 
	* @throws
	 */
	List<ReflectManager> getReflectManagerList(Page<ReflectManager> page);
	/**
	 * 
	* @Title: getSelectTime 
	* @Description: 通过时间区间获取体现管理列表
	* @author 尤
	* @date 2016年11月17日 下午3:19:49  
	* @param @param page
	* @param @param optionTime
	* @param @return    设定文件 
	* @return List<ReflectManager>    返回类型 
	* @throws
	 */
	List<ReflectManager> getSelectTime(Page<ReflectManager> page, SelectOptionTime optionTime);
	
	/**
	 * 
	* @Title: getSelectSatate 
	* @Description: 通过状态获取体现管理列表
	* @author 尤
	* @date 2016年11月17日 下午3:22:49  
	* @param @param page
	* @param @param userState
	* @param @return    设定文件 
	* @return List<ReflectManager>    返回类型 
	* @throws
	 */
	List<ReflectManager> getSelectSatate(Page<ReflectManager> page, String userState);
	
	/**
	 * 
	* @Title: selectReflectByCommand 
	* @Description:  通过条件查询获取体现管理列表
	* @author 尤
	* @date 2016年11月17日 下午3:28:43  
	* @param @param page
	* @param @param reflectManager
	* @param @return    设定文件 
	* @return List<ReflectManager>    返回类型 
	* @throws
	 */
	List<ReflectManager> selectReflectByCommand(Page<ReflectManager> page, ReflectManager reflectManager);


}
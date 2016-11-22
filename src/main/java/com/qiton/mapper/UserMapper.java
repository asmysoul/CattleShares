package com.qiton.mapper;

import com.qiton.model.FriendsInvite;
import com.qiton.model.SelectOptionTime;
import com.qiton.model.User;
import com.qiton.model.VipManage;

import java.util.List;

import com.baomidou.mybatisplus.mapper.AutoMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

/**
 *
 * User 表数据库控制层接口
 *
 */
public interface UserMapper extends AutoMapper<User> {

	/**
	 * 
	* @Title: selectUserList 
	* @Description: 分页查询用户
	* @author 尤
	* @date 2016年11月10日 上午10:24:52  
	* @param @param page
	* @param @return    设定文件 
	* @return List<VipManage>    返回类型 
	* @throws
	 */
	List<VipManage> selectUserList(Pagination page);
	
	/**
	 * 
	* @Title: selectUserList 
	* @Description: 根据时间分页查询用户
	* @author 尤
	* @date 2016年11月10日 上午10:25:07  
	* @param @param page
	* @param @return    设定文件 
	* @return List<VipManage>    返回类型 
	* @throws
	 */
	List<VipManage> selectUserListByTime(Pagination page,VipManage vipManage);
	
	/**
	 * 
	* @Title: getSelectTime 
	* @Description: 根据时间区间获取列表
	* @author 尤
	* @date 2016年11月14日 上午11:17:06  
	* @param @param page
	* @param @param selectOptionTime
	* @param @return    设定文件 
	* @return List<VipManage>    返回类型 
	* @throws
	 */
	List<VipManage> getSelectTime(Pagination page,SelectOptionTime selectOptionTime);
	/**
	 * 
	* @Title: getSelectUserSatate 
	* @Description: 根据用户状态获得列表
	* @author 尤
	* @date 2016年11月14日 上午11:17:41  
	* @param @param page
	* @param @param userState
	* @param @return    设定文件 
	* @return List<VipManage>    返回类型 
	* @throws
	 */
	List<VipManage> getSelectUserSatate(Pagination page,String userState);
	
	/**
	 * 
	* @Title: selectByCommandUser 
	* @Description: 条件查询获取用户列表
	* @author 尤
	* @date 2016年11月14日 上午11:20:08  
	* @param @param page
	* @param @param user
	* @param @return    设定文件 
	* @return List<User>    返回类型 
	* @throws
	 */
	List<User> selectByCommandUser(Page<User> page, User user);
	
	/**
	 * 
	* @Title: getSelectUserByType 
	* @Description: 根据账户类型获取用户列表
	* @author 尤
	* @date 2016年11月14日 下午2:12:39  
	* @param @param page
	* @param @param accountType
	* @param @return    设定文件 
	* @return List<User>    返回类型 
	* @throws
	 */
	List<User> getSelectUserByType(Pagination page,String accountType);
	
	/**
	 * 
	* @Title: getSelectVIPUserByTime 
	* @Description: 根据注册时间获取
	* @author 尤
	* @date 2016年11月14日 下午2:21:07  
	* @param @param page
	* @param @param selectOptionTime
	* @param @return    设定文件 
	* @return List<User>    返回类型 
	* @throws
	 */
	List<User> getSelectVIPUserByTime(Pagination page,SelectOptionTime selectOptionTime);
	
	/**
	 * 
	* @Title: getSumProfit 
	* @Description: TODO
	* @author 尤
	* @date 2016年11月21日 上午9:25:21  
	* @param @param inviusername
	* @param @return    设定文件 
	* @return List<FriendsInvite>    返回类型 
	* @throws
	 */
	FriendsInvite getSumProfit(String inviusername);
	
}
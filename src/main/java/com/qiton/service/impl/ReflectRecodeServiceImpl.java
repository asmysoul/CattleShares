package com.qiton.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qiton.exception.BussinessException;
import com.qiton.mapper.MarkRecodeMapper;
import com.qiton.mapper.ReflectRecodeMapper;
import com.qiton.model.Invite;
import com.qiton.model.MarkRecode;
import com.qiton.model.ReflectManager;
import com.qiton.model.ReflectRecode;
import com.qiton.model.SelectOptionTime;
import com.qiton.model.User;
import com.qiton.model.VipManage;
import com.qiton.service.IReflectRecodeService;
import com.baomidou.framework.service.impl.SuperServiceImpl;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;

/**
 *
 * ReflectRecode 表数据服务层接口实现类
 *
 */
@Service
public class ReflectRecodeServiceImpl extends SuperServiceImpl<ReflectRecodeMapper, ReflectRecode> implements IReflectRecodeService {

	@Resource
	private ReflectRecodeMapper ReflectRecodeMapper;
	
	/**
	 * 获取体现记录列表
	 */
	@Override
	public void getReflectRecodeList(Page<ReflectRecode> page) throws BussinessException {
		// TODO Auto-generated method stub
		List<ReflectRecode> list=ReflectRecodeMapper.selectPage(page, null);
		page.setRecords(list);
	}

	/**
	 * 通过时间区间获取记录列表
	 */
	@Override
	public void ReflectRecodeByTime(Page<ReflectRecode> page, SelectOptionTime optionTime) throws BussinessException {
		// TODO Auto-generated method stub
		EntityWrapper<ReflectRecode> entityWrapper = new EntityWrapper<ReflectRecode>();
		entityWrapper.between("rrd_applytime", optionTime.getFirstTime(), optionTime.getLastTime());
		List<ReflectRecode> admins = ReflectRecodeMapper.selectPage(page, entityWrapper);
		page.setRecords(admins);
	}
	/**
	 * 通过状态获取记录列表
	 */
	@Override
	public void getReflectRecodeProfittype(Page<ReflectRecode> page, String profittype) throws BussinessException {
		// TODO Auto-generated method stub
		EntityWrapper<ReflectRecode> entityWrapper = new EntityWrapper<ReflectRecode>();
		entityWrapper.where("rrd_state={0}",profittype);
		List<ReflectRecode> admins = ReflectRecodeMapper.selectPage(page, entityWrapper);
		page.setRecords(admins);
	}
	/**
	 * 条件获取记录列表
	 */
	@Override
	public void getReflectRecodeByCommand(ReflectRecode reflectRecode, Page<ReflectRecode> page)
			throws BussinessException {
		// TODO Auto-generated method stub
		if(reflectRecode==null){
			throw new BussinessException("参数错误");
		}
		if(reflectRecode.getRrdUsername()=="") reflectRecode.setRrdUsername(null); 
		EntityWrapper<ReflectRecode> entityWrapper=new EntityWrapper<ReflectRecode>(reflectRecode);
		List<ReflectRecode> invites = ReflectRecodeMapper.selectPage(page, entityWrapper);
		
		if(invites==null){
			throw new BussinessException("查询用户不存在");
		}
		page.setRecords(invites);
	}

	
	
	
	
	
	
	
	
	
	
	//体现管理
	
	
	
	/**
	 * 获取体现管理列表
	 */
	@Override
	public void getReflectManagerList(Page<ReflectManager> page) {
		// TODO Auto-generated method stub
		List<ReflectManager> users =ReflectRecodeMapper.getReflectManagerList(page);
		page.setRecords(users);//page
	}

	/**
	 * 通过时间区间获取体现管理列表
	 */
	@Override
	public void getSelectTime(Page<ReflectManager> page, SelectOptionTime optionTime) {
		// TODO Auto-generated method stub
		List<ReflectManager> users = ReflectRecodeMapper.getSelectTime(page, optionTime);
		page.setRecords(users);
	}
	/**
	 * 通过状态获取体现管理列表
	 */
	@Override
	public void getSelectSatate(Page<ReflectManager> page, String userState) {
		// TODO Auto-generated method stub
		List<ReflectManager> users = ReflectRecodeMapper.getSelectSatate(page, userState);
		page.setRecords(users);
	}
	/**
	 * 条件查询获取体现管理列表
	 */
	@Override
	public void selectReflectByCommand(ReflectManager reflectManager, Page<ReflectManager> page) {
		// TODO Auto-generated method stub
		if(reflectManager==null){
			throw new BussinessException("参数错误");
		}
		List<ReflectManager> lists = ReflectRecodeMapper.selectReflectByCommand(page, reflectManager);
		if(lists==null){
			throw new BussinessException("查询数据不存在");
		}
		page.setRecords(lists);
	}


}
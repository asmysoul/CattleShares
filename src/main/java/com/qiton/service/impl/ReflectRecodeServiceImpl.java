package com.qiton.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qiton.exception.BussinessException;
import com.qiton.mapper.MarkRecodeMapper;
import com.qiton.mapper.ReflectRecodeMapper;
import com.qiton.model.MarkRecode;
import com.qiton.model.ReflectRecode;
import com.qiton.model.SelectOptionTime;
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
	
	
	@Override
	public void getReflectRecodeList(Page<ReflectRecode> page) throws BussinessException {
		// TODO Auto-generated method stub
		List<ReflectRecode> list=ReflectRecodeMapper.selectPage(page, null);
		page.setRecords(list);
	}

	@Override
	public void ReflectRecodeByTime(Page<ReflectRecode> page, SelectOptionTime optionTime) throws BussinessException {
		// TODO Auto-generated method stub
		EntityWrapper<ReflectRecode> entityWrapper = new EntityWrapper<ReflectRecode>();
		entityWrapper.between("rrd_applytime", optionTime.getFirstTime(), optionTime.getLastTime());
		List<ReflectRecode> admins = ReflectRecodeMapper.selectPage(page, entityWrapper);
		page.setRecords(admins);
	}

	@Override
	public void getReflectRecodeProfittype(Page<ReflectRecode> page, String profittype) throws BussinessException {
		// TODO Auto-generated method stub
		EntityWrapper<ReflectRecode> entityWrapper = new EntityWrapper<ReflectRecode>();
		entityWrapper.where("rrd_state={0}",profittype);
		List<ReflectRecode> admins = ReflectRecodeMapper.selectPage(page, entityWrapper);
		page.setRecords(admins);
	}

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


}
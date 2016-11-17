package com.qiton.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qiton.exception.BussinessException;
import com.qiton.mapper.GoldRecordMapper;
import com.qiton.model.GoldRecord;
import com.qiton.model.Invite;
import com.qiton.model.SelectOptionTime;
import com.qiton.service.IGoldRecordService;
import com.baomidou.framework.service.impl.SuperServiceImpl;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;

/**
 *
 * GoldRecord 表数据服务层接口实现类
 *
 */
@Service
public class GoldRecordServiceImpl extends SuperServiceImpl<GoldRecordMapper, GoldRecord> implements IGoldRecordService {

	@Resource
	private GoldRecordMapper goldRecordMapper;
	
	@Override
	public void getgoldRecordList(Page<GoldRecord> page) throws BussinessException {
		// TODO Auto-generated method stub
		List<GoldRecord> invilist=goldRecordMapper.selectPage(page, null);
		page.setRecords(invilist);
	}

	@Override
	public void goldRecordByTime(Page<GoldRecord> page, SelectOptionTime optionTime) {
		// TODO Auto-generated method stub
		EntityWrapper<GoldRecord> entityWrapper = new EntityWrapper<GoldRecord>();
		entityWrapper.between("grd_time", optionTime.getFirstTime(), optionTime.getLastTime());
		List<GoldRecord> admins = goldRecordMapper.selectPage(page, entityWrapper);
		page.setRecords(admins);
	}

	@Override
	public void getGoldRecordProfittype(Page<GoldRecord> page, String Profittype) {
		// TODO Auto-generated method stub
		EntityWrapper<GoldRecord> entityWrapper = new EntityWrapper<GoldRecord>();
		entityWrapper.where("grd_profittype={0}",Profittype);
		List<GoldRecord> admins = goldRecordMapper.selectPage(page, entityWrapper);
		page.setRecords(admins);
	}

	@Override
	public void getGoldRecordByCommand(GoldRecord goldRecord, Page<GoldRecord> page) {
		// TODO Auto-generated method stub
		if(goldRecord==null){
			throw new BussinessException("参数错误");
		}
		if(goldRecord.getGrdUsername()=="") goldRecord.setGrdUsername(null); 
		EntityWrapper<GoldRecord> entityWrapper=new EntityWrapper<GoldRecord>(goldRecord);
		List<GoldRecord> invites = goldRecordMapper.selectPage(page, entityWrapper);
		
		if(invites==null){
			throw new BussinessException("查询用户不存在");
		}
		page.setRecords(invites);
	}


}
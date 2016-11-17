package com.qiton.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qiton.exception.BussinessException;
import com.qiton.mapper.VipRecordMapper;
import com.qiton.model.Invite;
import com.qiton.model.SelectOptionTime;
import com.qiton.model.VipRecord;
import com.qiton.service.IVipRecordService;
import com.qiton.utils.StringUtils;
import com.baomidou.framework.service.impl.SuperServiceImpl;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;

/**
 *
 * VipRecord 表数据服务层接口实现类
 *
 */
@Service
public class VipRecordServiceImpl extends SuperServiceImpl<VipRecordMapper, VipRecord> implements IVipRecordService {

	@Resource
	private VipRecordMapper vipRecordMapper;
	
	/**
	 * 获取会员记录
	 */
	@Override
	public void getVipRecordList(Page<VipRecord> page) throws BussinessException {
		// TODO Auto-generated method stub
		List<VipRecord> list=vipRecordMapper.selectPage(page, null);
		page.setRecords(list);
	}

	
	/**
	 * 新增会员记录
	 */
	@Override
	public void insertVipRecord(VipRecord vipRecord) throws BussinessException {
		// TODO Auto-generated method stub
		if(vipRecord==null||vipRecord.getVrdRechargeprice()<0||vipRecord.getVrdRemark().length()>200
				||StringUtils.isBlank(vipRecord.getVrdUserid().toString())
				||StringUtils.isBlank(vipRecord.getVrdUsername())
				||StringUtils.isBlank(vipRecord.getVrdRechargeprice().toString())
				||StringUtils.isBlank(vipRecord.getVrdRemark())){
			throw new BussinessException("输入参数有误");
		}
		int result=vipRecordMapper.insert(vipRecord);
		if(result!=1){
			throw new BussinessException("新增会员记录失败");
		}
	}

	/**
	 * 条件查询
	 */
	@Override
	public void getVipRecordByCommand(Page<VipRecord> page, VipRecord vipRecord) {
		// TODO Auto-generated method stub
		if(vipRecord==null){
			throw new BussinessException("参数错误");
		}
		if(vipRecord.getVrdUsername()=="") vipRecord.setVrdUsername(null); 
		
		EntityWrapper<VipRecord> entityWrapper=new EntityWrapper<VipRecord>(vipRecord);
		List<VipRecord> invites = vipRecordMapper.selectPage(page, entityWrapper);
		
		if(invites==null){
			throw new BussinessException("查询用户不存在");
		}
		page.setRecords(invites);
	}

	
	/**
	 * 通过时间区间获取会员记录列表
	 */
	@Override
	public void getVipRecordByTime(Page<VipRecord> page, SelectOptionTime optionTime) {
		// TODO Auto-generated method stub
		EntityWrapper<VipRecord> entityWrapper = new EntityWrapper<VipRecord>();
		entityWrapper.between("vrd_rechargetime", optionTime.getFirstTime(), optionTime.getLastTime());
		List<VipRecord> admins = vipRecordMapper.selectPage(page, entityWrapper);
		page.setRecords(admins);
	}
	
}
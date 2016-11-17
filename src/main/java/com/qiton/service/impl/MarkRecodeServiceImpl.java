package com.qiton.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qiton.exception.BussinessException;
import com.qiton.mapper.MarkRecodeMapper;
import com.qiton.model.Invite;
import com.qiton.model.MarkRecode;
import com.qiton.model.SelectOptionTime;
import com.qiton.service.IMarkRecodeService;
import com.baomidou.framework.service.impl.SuperServiceImpl;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;

/**
 *
 * MarkRecode 表数据服务层接口实现类
 *
 */
@Service
public class MarkRecodeServiceImpl extends SuperServiceImpl<MarkRecodeMapper, MarkRecode> implements IMarkRecodeService {

	@Resource
	private MarkRecodeMapper markRecordMapper;
	
	@Override
	public void getmarkRecodeList(Page<MarkRecode> page) throws BussinessException {
		// TODO Auto-generated method stub
		List<MarkRecode> list=markRecordMapper.selectPage(page, null);
		page.setRecords(list);
	}

	@Override
	public void markRecodeByTime(Page<MarkRecode> page, SelectOptionTime optionTime) throws BussinessException {
		// TODO Auto-generated method stub
		EntityWrapper<MarkRecode> entityWrapper = new EntityWrapper<MarkRecode>();
		entityWrapper.between("mrd_time", optionTime.getFirstTime(), optionTime.getLastTime());
		List<MarkRecode> admins = markRecordMapper.selectPage(page, entityWrapper);
		page.setRecords(admins);
	}

	@Override
	public void getmarkRecodeProfittype(Page<MarkRecode> page, String profittype) throws BussinessException {
		// TODO Auto-generated method stub
		EntityWrapper<MarkRecode> entityWrapper = new EntityWrapper<MarkRecode>();
		entityWrapper.where("mrd_profittype={0}",profittype);
		List<MarkRecode> admins = markRecordMapper.selectPage(page, entityWrapper);
		page.setRecords(admins);
	}

	@Override
	public void getmarkRecodeByCommand(MarkRecode markRecode, Page<MarkRecode> page) throws BussinessException {
		// TODO Auto-generated method stub
		if(markRecode==null){
			throw new BussinessException("参数错误");
		}
		if(markRecode.getMrdUsername()=="") markRecode.setMrdUsername(null); 
		EntityWrapper<MarkRecode> entityWrapper=new EntityWrapper<MarkRecode>(markRecode);
		List<MarkRecode> invites = markRecordMapper.selectPage(page, entityWrapper);
		
		if(invites==null){
			throw new BussinessException("查询用户不存在");
		}
		page.setRecords(invites);
	}


}
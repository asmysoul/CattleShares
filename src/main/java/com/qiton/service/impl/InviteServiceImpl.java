package com.qiton.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qiton.exception.BussinessException;
import com.qiton.mapper.InviteMapper;
import com.qiton.model.Admin;
import com.qiton.model.Invite;
import com.qiton.model.SelectOptionTime;
import com.qiton.model.VipManage;
import com.qiton.service.IInviteService;
import com.baomidou.framework.service.impl.SuperServiceImpl;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;

/**
 *
 * Invite 表数据服务层接口实现类
 *
 */
@Service
public class InviteServiceImpl extends SuperServiceImpl<InviteMapper, Invite> implements IInviteService {

	@Resource
	private InviteMapper inviteMapper;
	
	/**
	 * 获取邀请列表
	 */
	@Override
	public void getInviteList(Page<Invite> page) throws BussinessException {
		// TODO Auto-generated method stub
		List<Invite> invilist=inviteMapper.selectPage(page, null);
		page.setRecords(invilist);
	}
	/**
	 * 通过时间区间获取邀请列表
	 */
	@Override
	public void getInviteByTime(Page<Invite> page, SelectOptionTime optionTime) {
		// TODO Auto-generated method stub
		EntityWrapper<Invite> entityWrapper = new EntityWrapper<Invite>();
		entityWrapper.between("invi_recharge", optionTime.getFirstTime(), optionTime.getLastTime());
		List<Invite> admins = inviteMapper.selectPage(page, entityWrapper);
		page.setRecords(admins);
	}
	/**
	 * 通过会员状态获取邀请列表
	 */
	@Override
	public void getInviteSatate(Page<Invite> page, String acceptuserstate) {
		// TODO Auto-generated method stub
		EntityWrapper<Invite> entityWrapper = new EntityWrapper<Invite>();
		entityWrapper.where("invi_acceptuserstate={0}",acceptuserstate);
		List<Invite> admins = inviteMapper.selectPage(page, entityWrapper);
		page.setRecords(admins);
	}
	/**
	 * 通过条件查询获取邀请列表
	 */
	@Override
	public void getInviteByCommand(Invite invite, Page<Invite> page) {
		// TODO Auto-generated method stub
		if(invite==null){
			throw new BussinessException("参数错误");
		}
		if(invite.getInviAcceptuser()=="") invite.setInviAcceptuser(null); 
		if(invite.getInviUsername()=="") invite.setInviUsername(null); 
		EntityWrapper<Invite> entityWrapper=new EntityWrapper<Invite>(invite);
		List<Invite> invites = inviteMapper.selectPage(page, entityWrapper);
		
		if(invites==null){
			throw new BussinessException("查询用户不存在");
		}
		page.setRecords(invites);
	}


}
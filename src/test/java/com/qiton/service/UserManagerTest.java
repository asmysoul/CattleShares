package com.qiton.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.baomidou.mybatisplus.plugins.Page;
import com.qiton.controller.Config;
import com.qiton.exception.BussinessException;
import com.qiton.model.Invite;
import com.qiton.model.User;

/**
 * 用户管理
 * @author Administrator
 *
 */
@RunWith(SpringJUnit4ClassRunner.class) // 整合 
@ContextConfiguration(locations="classpath:spring-config.xml") // 加载配置
public class UserManagerTest {
	
	@Autowired
	private IInviteService inviteService;//邀请
	
	@Autowired
	private IUserService userService;//用户
	
	@Test
	public void getAllUser(){
		Page<Invite> page=new Page<>(0, Config.PAGENUM);
		List<HashMap<String, Object>> list=new ArrayList<HashMap<String,Object>>();
		try{
			Page<Invite> pages=inviteService.selectPage(page, null);
			List<Invite> invitelist=pages.getRecords();
			System.out.println("--------"+invitelist.size());
			HashMap<String, Object> map = null;
			for(Invite invite:invitelist){
				map=new HashMap<String,Object>();
				Invite entity=new Invite();
				entity.setInviUsername(invite.getInviUsername()); 
				//通过邀请人取得邀请数量
				int count=inviteService.selectCount(entity);
				System.out.println("-----count----"+count);
				
				User accinviteuser=new User();
				accinviteuser.setUserName(invite.getInviAcceptuser());
				User acceptinviteInfo=userService.selectOne(accinviteuser);
				System.out.println("----acceptinviteInfo-------"+acceptinviteInfo.toString());
				
				User inviteuser=new User();
				inviteuser.setUserName(invite.getInviUsername());
				User inviteUserInfo=userService.selectOne(inviteuser);
				System.out.println("-----inviteUserInfo------"+inviteUserInfo.toString());
				map.put("inviteCount", count);
				map.put("acceptinviteUser", acceptinviteInfo);
				map.put("inviteUser", inviteUserInfo);
				list.add(map);
			}
			System.out.println("-----------------"+list.toString());
			
		}catch(BussinessException e){
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}

package com.qiton.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.plugins.Page;
import com.qiton.exception.BussinessException;
import com.qiton.model.Invite;
import com.qiton.model.Teacher;
import com.qiton.model.User;
import com.qiton.service.IInviteService;
import com.qiton.service.IUserService;
import com.sun.xml.internal.xsom.impl.scd.Iterators.Map;

/**
 * 用户管理模块
 * @author yqc
 *
 */
@RequestMapping("/userManager")
public class UserManagerController extends BaseController{
	
	@Autowired
	private IInviteService inviteService;//邀请
	
	@Autowired
	private IUserService userService;//用户
	
	
	@RequestMapping("/getallUser")
	@ResponseBody
	public Object getAllUser(Integer current, HttpServletRequest request){
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
			renderError(e.getLocalizedMessage());
		}catch (Exception e) {
			renderError("访问失败请重试");
		}
		return request;
	}
}
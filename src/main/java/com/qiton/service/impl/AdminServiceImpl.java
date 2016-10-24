package com.qiton.service.impl;

import java.util.logging.Logger;

import javax.annotation.Resource;

import org.apache.commons.logging.impl.Log4JLogger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.qiton.exception.BussinessException;
import com.qiton.mapper.AdminMapper;
import com.qiton.mapper.UserMapper;
import com.qiton.model.Admin;
import com.qiton.model.User;
import com.qiton.service.IAdminService;
import com.qiton.utils.StringUtils;
import com.baomidou.framework.service.impl.SuperServiceImpl;

/**
 *
 * Admin 表数据服务层接口实现类
 *
 */
@Service
public class AdminServiceImpl extends SuperServiceImpl<AdminMapper, Admin> implements IAdminService {

	private static final org.slf4j.Logger log = LoggerFactory.getLogger(AdminServiceImpl.class);
	
	@Resource
	private AdminMapper adminmapper;
	
	/**
	 * 后台登录验证
	 */
	@Override
	public Admin login(Admin admin)throws BussinessException{
		if(admin == null || StringUtils.isBlank(admin.getAdminUsername()) || StringUtils.isBlank(admin.getAdminPassword())
				|| admin.getAdminUsername().length() < 6 || admin.getAdminUsername().length() > 20 
				|| admin.getAdminPassword().length() < 6 || admin.getAdminPassword().length() > 20 ){
					throw new BussinessException("参数错误");	
		}
		 Admin admin2=new Admin();
		admin2.setAdminUsername(admin.getAdminUsername());
		Admin selectadmin=adminmapper.selectOne(admin2);
		if(selectadmin==null||!admin.getAdminPassword().trim().equals(selectadmin.getAdminPassword()))
		{
			throw new BussinessException("用户名或密码不正确");
		}
		return selectadmin;
		
	}

}
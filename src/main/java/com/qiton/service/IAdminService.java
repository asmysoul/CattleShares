package com.qiton.service;

import com.qiton.exception.BussinessException;
import com.qiton.model.Admin;
import com.qiton.model.User;
import com.baomidou.framework.service.ISuperService;

/**
 *
 * Admin 表数据服务层接口
 *
 */
public interface IAdminService extends ISuperService<Admin> {
	/**
	 * h后台登录
	 * @param admin
	 * @return
	 * @throws BussinessException
	 */
	public Admin login(Admin admin)throws BussinessException;
	
}
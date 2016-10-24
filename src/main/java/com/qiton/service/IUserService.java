package com.qiton.service;

import com.qiton.exception.BussinessException;
import com.qiton.model.User;
import com.baomidou.framework.service.ISuperService;

/**
 *
 * User 表数据服务层接口
 *
 */
public interface IUserService extends ISuperService<User> {
	
	public void regist(User user, String rightValidateCode) throws BussinessException;

}
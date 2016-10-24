package com.qiton.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qiton.exception.BussinessException;
import com.qiton.mapper.UserMapper;
import com.qiton.model.User;
import com.qiton.service.IUserService;
import com.qiton.utils.StringUtils;
import com.baomidou.framework.service.impl.SuperServiceImpl;

/**
 *
 * User 表数据服务层接口实现类
 *
 */
@Service
public class UserServiceImpl extends SuperServiceImpl<UserMapper, User> implements IUserService {
	
	@Autowired
	private UserMapper userMapper;

	/* Description: 注册用户
	 * @see com.qiton.service.IUserService#regist(com.qiton.model.User)
	 */
	@Override
	public void regist(User user, String rightValidateCode) throws BussinessException {
		if(user == null || StringUtils.isBlank(user.getUserName()) || StringUtils.isBlank(user.getPassword())
				|| StringUtils.isBlank(user.getValidateCode()) || user.getUserName().length() < 6 || user.getUserName().length() > 20 
				|| user.getPassword().length() < 6 || user.getPassword().length() > 20 ){
					throw new BussinessException("参数错误");	
		}
		
		User userQuery = new User();
		userQuery.setUserName(user.getUserName());
		if(this.userMapper.selectOne(userQuery) != null){
			throw new BussinessException("用户名已存在");
		}
		
		if(!user.getValidateCode().equals(rightValidateCode)){
			throw new BussinessException("验证码错误，请重试");
		}
		
		user.setRegisterTime(new Date());
		this.userMapper.insert(user);
	}

	
	/**
	 * 用户登录验证
	 */
	@Override
	public User userlogin(User user) throws BussinessException {
		User user2=new User();
		user2.setUserName(user2.getUserName());
		User selectUser=userMapper.selectOne(user2);
		if(selectUser==null||!user.getPassword().trim().equals(selectUser.getPassword())){
			throw new BussinessException("用户名或密码不正确");
		}
		return selectUser;
	}

	

}
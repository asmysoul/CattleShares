package com.qiton.service.impl;

import org.springframework.stereotype.Service;

import com.qiton.mapper.UserMapper;
import com.qiton.model.User;
import com.qiton.service.IUserService;
import com.baomidou.framework.service.impl.SuperServiceImpl;

/**
 *
 * User 表数据服务层接口实现类
 *
 */
@Service
public class UserServiceImpl extends SuperServiceImpl<UserMapper, User> implements IUserService {


}
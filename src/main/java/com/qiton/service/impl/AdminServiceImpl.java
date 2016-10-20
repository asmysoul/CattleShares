package com.qiton.service.impl;

import org.springframework.stereotype.Service;

import com.qiton.mapper.AdminMapper;
import com.qiton.model.Admin;
import com.qiton.service.IAdminService;
import com.baomidou.framework.service.impl.SuperServiceImpl;

/**
 *
 * Admin 表数据服务层接口实现类
 *
 */
@Service
public class AdminServiceImpl extends SuperServiceImpl<AdminMapper, Admin> implements IAdminService {


}
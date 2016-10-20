package com.qiton.service.impl;

import org.springframework.stereotype.Service;

import com.qiton.mapper.TeacherMapper;
import com.qiton.model.Teacher;
import com.qiton.service.ITeacherService;
import com.baomidou.framework.service.impl.SuperServiceImpl;

/**
 *
 * Teacher 表数据服务层接口实现类
 *
 */
@Service
public class TeacherServiceImpl extends SuperServiceImpl<TeacherMapper, Teacher> implements ITeacherService {


}
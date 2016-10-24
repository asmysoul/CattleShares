package com.qiton.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.qiton.exception.BussinessException;
import com.qiton.mapper.TeacherMapper;
import com.qiton.model.Teacher;
import com.qiton.service.ITeacherService;
import com.baomidou.framework.service.impl.SuperServiceImpl;
import com.baomidou.mybatisplus.plugins.Page;

/**
 *
 * Teacher 表数据服务层接口实现类
 *
 */
@Service
public class TeacherServiceImpl extends SuperServiceImpl<TeacherMapper, Teacher> implements ITeacherService {
	private static final Logger log=LoggerFactory.getLogger(TeacherServiceImpl.class);
	
	
	@Resource
	private TeacherMapper teacherMapper;
	
	@Override
	public int addTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		int b=teacherMapper.insert(teacher);
		if(b!=0){
			return b;
		}else{
			throw new BussinessException("新增失败");
		}
	}

	/* (non-Javadoc)
	 * @see com.qiton.service.ITeacherService#getTeacher(java.lang.Long)
	 */
	@Override
	public Teacher getTeacher(Long id) {
		// TODO Auto-generated method stub
		Teacher teacher2=teacherMapper.selectById(id);
		if(teacher2!=null){
			return teacher2;
		}else{
			throw new BussinessException("操作失败");
		}
	}

	@Override
	public int updateTeacher(Teacher teacher,Teacher whTeacher) {
		// TODO Auto-generated method stub
		int b=teacherMapper.update(teacher, whTeacher);
		if(b!=0){
			return b;
		}else{
			throw new BussinessException("修改失败");
		}
	}

	@Override
	public int deleteTeacher(Long id) {
		// TODO Auto-generated method stub
		int b=teacherMapper.deleteById(id);
		if(b!=0){
			return b;
		}else{
			throw new BussinessException("删除失败");
		}
	}

	
}
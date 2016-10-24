package com.qiton.service;

import com.qiton.model.Teacher;
import com.baomidou.framework.service.ISuperService;
import com.baomidou.mybatisplus.plugins.Page;

/**
 *
 * Teacher 表数据服务层接口
 *
 */
public interface ITeacherService extends ISuperService<Teacher> {

	/**
	 * 新增老师
	 * @param teacher
	 * @return
	 */
	public int addTeacher(Teacher teacher);
	/**
	 * 取得老师信息
	 * @param teacher
	 * @return
	 */
	public Teacher getTeacher(Long id);
	
	/**
	 * 更新老师
	 * @param teacher
	 * @return
	 */
	public int updateTeacher(Teacher teacher,Teacher whereteacher);
	
	/**
	 * 删除老师
	 * @param teacher
	 * @return
	 */
	public int deleteTeacher(Long id);
	
}
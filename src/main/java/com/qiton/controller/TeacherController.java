package com.qiton.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.qiton.exception.BussinessException;
import com.qiton.model.Teacher;
import com.qiton.service.ITeacherService;

/**
 * 教师controller
 * @author yqc
 *
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController extends BaseController{

	@Autowired
	private ITeacherService teacherService;
	
	/**
	 * 新增老师
	 * @param teacher
	 * @return
	 */
	@RequestMapping("/addTeacher")
	public ModelAndView addTeacher(Teacher teacher,HttpServletRequest request){
		ModelAndView view=new ModelAndView();
		try{
			teacherService.addTeacher(teacher);
			view.setViewName("");
		}catch(BussinessException e){
			e.printStackTrace();
			view.addObject("error",e.getLocalizedMessage());
		}
		return view;
	}
	
	/**
	 * 根据id取得老师的信息
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/getTeacherInfo")
	public ModelAndView getTeacherInfo(Long id,HttpServletRequest request){
		ModelAndView view=new ModelAndView();
		try{
			Teacher selectteacher=teacherService.getTeacher(id);
			view.addObject("select_teacher", selectteacher);
			view.setViewName("");
		}catch(BussinessException e){
			e.printStackTrace();
			view.addObject("error",e.getLocalizedMessage());
		}
		return view;
	}
	
	
	/**
	 * 修改老师信息
	 * @param id
	 * @param teacher
	 * @param request
	 * @return
	 */
	@RequestMapping("/updateTeacherInfo")
	public ModelAndView updateTeacherInfo(Long id,Teacher teacher,HttpServletRequest request){
		ModelAndView view=new ModelAndView();
		try{
			Teacher selectteacher=teacherService.selectById(id);
			int b=teacherService.updateTeacher(teacher, teacher);
			view.setViewName("");
		}catch(BussinessException e){
			e.printStackTrace();
			view.addObject("error",e.getLocalizedMessage());
		}
		return view;
	}
	
	/**
	 * 删除老师
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/deleteTeacher")
	public ModelAndView deleteTeacher(Long id,HttpServletRequest request){
		ModelAndView view=new ModelAndView();
		try{
			int b=teacherService.deleteTeacher(id);
			view.setViewName("");
		}catch(BussinessException e){
			e.printStackTrace();
		}
		return view;
	}
	
	
	@RequestMapping("/selectTechList")
	public ModelAndView selectTechList(Integer currentPage,HttpServletRequest request){
		ModelAndView view=new ModelAndView();
		Page<Teacher> page=new Page<Teacher>(currentPage, Config.PAGENUM);
		try{
			Page<Teacher> pages=teacherService.selectPage(page, null);
			List<Teacher> list=pages.getRecords();
			for(Teacher teacher:list){
				System.out.println("-----------"+teacher.toString());
			}
			view.addObject("tech_list", list);
			
		}catch(BussinessException e){
			e.printStackTrace();
			renderError("查询出错");
		}
		return view;
	}
}

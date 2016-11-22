/******************************************************************
 *
 *    
 *
 *    Copyright (c) 2016-forever 
 *    http://www.fzqblog.top
 *
 *    Package:     com.qiton.controller
 *
 *    Filename:    ProblemController.java
 *
 *    Description: TODO(用一句话描述该文件做什么)
 *
 *    Copyright:   Copyright (c) 2001-2014
 *
 *    Company:     fzqblog
 *
 *    @author:     抽离
 *
 *    @version:    1.0.0
 *
 *    Create at:   2016年11月18日 上午8:39:18
 *
 *    Revision:
 *
 *    2016年11月18日 上午8:39:18
 *        - first revision
 *
 *****************************************************************/
package com.qiton.controller;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.plugins.Page;
import com.qiton.exception.BussinessException;
import com.qiton.model.Problem;
import com.qiton.model.User;
import com.qiton.service.IProblemService;
import com.qiton.service.IUserService;
import com.qiton.utils.Config;

/**
 * @ClassName ProblemController
 * @Description 问股
 * @author 抽离
 * @Date 2016年11月18日 上午8:39:18
 * @version 1.0.0
 */
@RequestMapping("problem")
@Controller
public class ProblemController extends BaseController{
	 private static final Logger LOGGER = LogManager.getLogger(ProblemController.class);
	
	@Autowired
	private IProblemService iProblemService;
	
	@Autowired
	private IUserService iUserService;
	
	@RequestMapping("askQuestion")
	@ResponseBody
	public Object askQuestion(Problem problem, HttpSession session){
		User user = (User) session.getAttribute("current_user");
		if(user != null){
			problem.setUserId(user.getUserId());
		}
		Problem problemResult = null;
		try {
			problemResult = iProblemService.askQuestion(problem);
		} catch(BussinessException e){
			LOGGER.info(e.getLocalizedMessage());
			return renderError(e.getLocalizedMessage());
		}catch (Exception e) {
			LOGGER.info(e.getLocalizedMessage());
			return renderError("提问失败，请重试");
		}
		return renderSuccess(problemResult);
	}
	
	@RequestMapping("answerQuestion")
	@ResponseBody
	public Object answerQuestion(Problem problem, HttpSession session){
		Problem problemResult = null;
		try {
			problemResult = iProblemService.answerQuestion(problem);
		} catch(BussinessException e){
			LOGGER.info(e.getLocalizedMessage());
			return renderError(e.getLocalizedMessage());
		}catch (Exception e) {
			LOGGER.info(e.getLocalizedMessage());
			return renderError("回答失败，请重试");
		}
		return renderSuccess(problemResult);
	}
	
	@RequestMapping("findMyQuestion")
	@ResponseBody
	public Object findMyQuestion(Page<Problem> page, Long userId){
		Page<Problem> pageResult = new Page<>(page.getCurrent(), Config.PAGENUM);
		User user = null;
		try {
			user = iUserService.getCurrentUser(userId.toString());
			iProblemService.findMyQuestion(pageResult, user);
		} catch(BussinessException e){
			LOGGER.info(e.getLocalizedMessage());
			return renderError(e.getLocalizedMessage());
		}catch (Exception e) {
			LOGGER.info(e.getLocalizedMessage());
			return renderError("获取已提问失败，请重试");
		}
		return renderSuccess(pageResult);
	}
	
	
	@RequestMapping("findAnswers")
	@ResponseBody
	public Object findAnswers(Page<Problem> page, Long techId, HttpSession session){
		Page<Problem> pageResult = new Page<>(page.getCurrent(), Config.PAGENUM);
		try {
			iProblemService.findAnswers(pageResult, techId);
		} catch(BussinessException e){
			LOGGER.info(e.getLocalizedMessage());
			return renderError(e.getLocalizedMessage());
		}catch (Exception e) {
			LOGGER.info(e.getLocalizedMessage());
			return renderError("获取回答失败，请重试");
		}
		return renderSuccess(pageResult);
	}
	
	@RequestMapping("findMyQuestionCount")
	@ResponseBody
	public Object findMyQuestionCount(Long userId){
		User user = null;
		int questionCount;
		try {
			user = iUserService.getCurrentUser(userId.toString());
			questionCount = iProblemService.findMyQuestionCount(user.getUserId());
		} catch(BussinessException e){
			LOGGER.info(e.getLocalizedMessage());
			return renderError(e.getLocalizedMessage());
		}catch (Exception e) {
			LOGGER.info(e.getLocalizedMessage());
			return renderError("获取提问条数，请重试");
		}
		return renderSuccess(questionCount);
	}
	
	

	
	
	@RequestMapping("findUnSolvedQuestion")
	@ResponseBody
	public Object findUnSolvedQuestion(Page<Problem> page, HttpSession session){
		Page<Problem> pageResult = new Page<>(page.getCurrent(), Config.PAGENUM);
		try {
			iProblemService.findUnSolvedQuestion(pageResult);
		} catch(BussinessException e){
			LOGGER.info(e.getLocalizedMessage());
			return renderError(e.getLocalizedMessage());
		}catch (Exception e) {
			LOGGER.info(e.getLocalizedMessage());
			return renderError("获取未回答问题列表失败，请重试");
		}
		return renderSuccess(pageResult);
	}
	
	@RequestMapping("findSolvedQuestion")
	@ResponseBody
	public Object findSolvedQuestion(Page<Problem> page, HttpSession session){
		Page<Problem> pageResult = new Page<>(page.getCurrent(), Config.PAGENUM);
		try {
			iProblemService.findSolvedQuestion(pageResult);
		} catch(BussinessException e){
			LOGGER.info(e.getLocalizedMessage());
			return renderError(e.getLocalizedMessage());
		}catch (Exception e) {
			LOGGER.info(e.getLocalizedMessage());
			return renderError("获取已回答问题列表失败，请重试");
		}
		return renderSuccess(pageResult);
	}
	
}

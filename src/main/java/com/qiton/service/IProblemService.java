package com.qiton.service;

import com.qiton.exception.BussinessException;
import com.qiton.model.Problem;
import com.qiton.model.User;
import com.baomidou.framework.service.ISuperService;
import com.baomidou.mybatisplus.plugins.Page;

/**
 *
 * Problem 表数据服务层接口
 *
 */
public interface IProblemService extends ISuperService<Problem> {
	
	public Problem askQuestion(Problem problem) throws BussinessException;
	
	public void deleteProblem(Long proId) throws BussinessException;
	
	public Problem answerQuestion(Problem problem) throws BussinessException;
	
	public void findSolvedQuestion(Page<Problem> page)throws BussinessException;
	
	public void findMyQuestion(Page<Problem> page, User user)throws BussinessException;
	
	public void findAnswers(Page<Problem> page, Long techId)throws BussinessException;	
	
	public int findMyQuestionCount(Long userId) throws BussinessException;
	
	public Long findTechAnswserCount(Long techId);
	
	public void findUnSolvedQuestion(Page<Problem> page)throws BussinessException;

}
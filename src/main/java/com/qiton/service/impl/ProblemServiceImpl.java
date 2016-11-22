package com.qiton.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.qiton.exception.BussinessException;
import com.qiton.mapper.ProblemMapper;
import com.qiton.mapper.UserMapper;
import com.qiton.model.Problem;
import com.qiton.model.User;
import com.qiton.service.IProblemService;
import com.qiton.utils.StringUtils;
import com.sun.tools.internal.ws.processor.model.Port;
import com.baomidou.framework.service.impl.SuperServiceImpl;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;

/**
 *
 * Problem 表数据服务层接口实现类
 *
 */
@Service
public class ProblemServiceImpl extends SuperServiceImpl<ProblemMapper, Problem> implements IProblemService {
	
	@Autowired
	private ProblemMapper problemMapper;
	
	@Autowired
	private UserMapper userMapper;

	/* (非 Javadoc)
	 * Description:
	 * @see com.qiton.service.IProblemService#askQuestion(com.qiton.model.Problem)
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW ,rollbackFor=BussinessException.class)
	public Problem askQuestion(Problem problem) throws BussinessException {
		if(problem == null || StringUtils.isBlank(problem.getProTechnick()) || StringUtils.isBlank(problem.getProUserquestion())
				|| problem.getUserId() == null || problem.getTechId() == null || problem.getProUserquestion().length() > 500
				){
			throw new BussinessException("参数错误");
		}
		User user = userMapper.selectById(problem.getUserId());
		
		int questions = findMyQuestionCount(problem.getUserId());
		
		if(user.getGrade() == 0 && questions >=10){
			throw new BussinessException("提问数量已达上限，办理会员才能再提问");
		}
		
		problem.setProCreatetime(new Date());
		problem.setProQuestiontime(new Date());
		int result = problemMapper.insert(problem);
		if(result != 1 ){
			throw new BussinessException("提问失败，请重试");
		}
		return problem;
	}

	/* (非 Javadoc)
	 * Description:
	 * @see com.qiton.service.IProblemService#deleteProblem(long)
	 */
	@Override
	public void deleteProblem(Long proId) throws BussinessException {
		if(proId == null){
			throw new BussinessException("参数错误");
		}
		
		int result = problemMapper.deleteById(proId);
		if(result != 1){
			throw new BussinessException("删除提问失败，请重试");
		}
		
	}

	/* (非 Javadoc)
	 * Description:
	 * @see com.qiton.service.IProblemService#answerQuestion(com.qiton.model.Problem)
	 */
	@Override
	public Problem answerQuestion(Problem problem) throws BussinessException {
		if(problem == null || problem.getProId() == null||StringUtils.isBlank(problem.getProAnswer())
				|| problem.getProAnswer().length() > 500 || problem.getTechId() == null || StringUtils.isBlank(problem.getProTechnick())
				){
			throw new BussinessException("参数错误");
		}
		Problem problemResult = problemMapper.selectById(problem.getProId());
		
		if(problemResult == null){
			throw new BussinessException("问题不存在！请刷新重试");
		}
	
		problem.setProAnswertime(new Date());
		int result = problemMapper.updateSelectiveById(problem);
		
		if(result != 1){
			throw new BussinessException("回答失败，请重试");
			
		}
		
		return problem;
	}

	/* (非 Javadoc)
	 * Description:
	 * @see com.qiton.service.IProblemService#findSolvedQuestion(com.baomidou.mybatisplus.plugins.Page)
	 */
	@Override
	public void findSolvedQuestion(Page<Problem> page) throws BussinessException {
		EntityWrapper<Problem> entityWrapper = new EntityWrapper<>();
		entityWrapper.where("pro_answer is NOT NULL");
		entityWrapper.andNew("order by pro_answertime");
		List<Problem> list = problemMapper.selectPage(page, entityWrapper);
		page.setRecords(list);
	}

	/* (非 Javadoc)
	 * Description:
	 * @see com.qiton.service.IProblemService#findUnSolvedQuestion(com.baomidou.mybatisplus.plugins.Page)
	 */
	@Override
	public void findUnSolvedQuestion(Page<Problem> page) throws BussinessException {
		EntityWrapper<Problem> entityWrapper = new EntityWrapper<>();
		entityWrapper.where("pro_answer is NULL");
		entityWrapper.andNew("order by pro_questiontime");
		List<Problem> list = problemMapper.selectPage(page, entityWrapper);
		page.setRecords(list);
	}

	/* (非 Javadoc)
	 * Description:
	 * @see com.qiton.service.IProblemService#findMyQuestion(com.baomidou.mybatisplus.plugins.Page)
	 */
	@Override
	public void findMyQuestion(Page<Problem> page, User user) throws BussinessException {
		if(user == null || user.getUserId() == null){
			throw new BussinessException("参数错误");
		}
		EntityWrapper<Problem> entityWrapper = new EntityWrapper<>();
		entityWrapper.where("user_id={0}", user.getUserId());
		List<Problem> list = problemMapper.selectPage(page, entityWrapper);
		page.setRecords(list);
		
	}

	/* (非 Javadoc)
	 * Description:
	 * @see com.qiton.service.IProblemService#findAndswers(com.baomidou.mybatisplus.plugins.Page, java.lang.Long)
	 */
	@Override
	public void findAnswers(Page<Problem> page, Long techId) throws BussinessException {
		if(techId == null){
			throw new BussinessException("参数错误");
		}
		EntityWrapper<Problem> entityWrapper = new EntityWrapper<>();
		entityWrapper.where("tech_id={0}", techId);
		List<Problem> list = problemMapper.selectPage(page, entityWrapper);
		page.setRecords(list);
	}
	
	/* (非 Javadoc)
	 * Description:
	 * @see com.qiton.service.IProblemService#findTechAnswserCount(java.lang.Long)
	 */
	@Override
	public Long findTechAnswserCount(Long techId) {
		if(techId == null){
			throw new BussinessException("参数错误");
		}
		Problem problemQuery = new Problem();
		problemQuery.setTechId(techId);
	
		Long result = (long) problemMapper.selectCount(problemQuery);
		
		return result;
	}

	/* (非 Javadoc)
	 * Description:
	 * @see com.qiton.service.IProblemService#findMyQuestionCount(java.lang.Long)
	 */
	@Override
	public int findMyQuestionCount(Long userId) throws BussinessException {
		if(userId == null){
			throw new BussinessException("参数错误");
		}
		//查询已提问数目
		EntityWrapper<Problem> entityWrapper = new EntityWrapper<>();
		entityWrapper.where("user_id={0}", userId);
		int questions = problemMapper.selectCountByEw(entityWrapper);
		return questions;
	}
	
	

}
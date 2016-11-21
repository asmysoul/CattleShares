/******************************************************************
 *
 *    
 *
 *    Copyright (c) 2016-forever 
 *    http://www.fzqblog.top
 *
 *    Package:     com.qiton.service
 *
 *    Filename:    UserServiceTesst.java
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
 *    Create at:   2016年10月24日 上午10:01:12
 *
 *    Revision:
 *
 *    2016年10月24日 上午10:01:12
 *        - first revision
 *
 *****************************************************************/
package com.qiton.service;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.baomidou.mybatisplus.plugins.Page;
import com.qiton.model.Problem;
import com.qiton.model.Purchase;

/**
 * @ClassName UserServiceTesst
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 抽离
 * @Date 2016年10月24日 上午10:01:12
 * @version 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:springmvc-servlet.xml",
		"classpath:spring-config.xml"
})
public class ProblemServiceTest {
	
	@Autowired
	private IProblemService iProblemService;

	
	@Test
	public void testAskQuestion(){
		Problem problem = new Problem();
		problem.setProUserquestion("fasdfasdfasfd");
		problem.setProTechnick("张老师");
		problem.setUserId(1L);
		iProblemService.askQuestion(problem);
	}
}

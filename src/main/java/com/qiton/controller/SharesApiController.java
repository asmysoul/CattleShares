/******************************************************************
 *
 *    
 *
 *    Copyright (c) 2016-forever 
 *    http://www.fzqblog.top
 *
 *    Package:     com.qiton.controller
 *
 *    Filename:    SharesApiController.java
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
 *    Create at:   2016年11月8日 上午8:58:53
 *
 *    Revision:
 *
 *    2016年11月8日 上午8:58:53
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

import com.qiton.exception.BussinessException;
import com.qiton.model.Shares;
import com.qiton.model.User;
import com.qiton.model.vo.SharesVo;
import com.qiton.service.ISharesApiService;

/**
 * @ClassName SharesApiController
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 抽离
 * @Date 2016年11月8日 上午8:58:53
 * @version 1.0.0
 */
@Controller
public class SharesApiController extends BaseController{

	 private static final Logger LOGGER = LogManager.getLogger(SharesApiController.class);
	
	@Autowired
	private ISharesApiService iSharesApiService;
	
	@ResponseBody
	@RequestMapping("getShareVoInfo")
	public Object getSharesInfo(Long code, HttpSession session){
		User user = (User) session.getAttribute("current_user");
		SharesVo sharesVo = null;
		try{
			sharesVo = iSharesApiService.getSharesBySharesCode(code);
		}catch(BussinessException e){
			LOGGER.info(e.getLocalizedMessage());
			return renderError(e.getLocalizedMessage());
		}catch (Exception e) {
			LOGGER.info(e.getLocalizedMessage());
			return renderError("获取股票出错，请重试");
		}
			return renderSuccess(sharesVo);
	}
	
	
	@ResponseBody
	@RequestMapping("getShareInfo")
	public Object getShareInfo(Long code, HttpSession session){
		User user = (User) session.getAttribute("current_user");
		Shares shares = null;
		try{
			shares = iSharesApiService.getSharesByShareCode(code);
		}catch(BussinessException e){
			LOGGER.info(e.getLocalizedMessage());
			return renderError(e.getLocalizedMessage());
		}catch (Exception e) {
			LOGGER.info(e.getLocalizedMessage());
			return renderError("获取股票出错，请重试");
		}
			return renderSuccess(shares);	
	}
	
}

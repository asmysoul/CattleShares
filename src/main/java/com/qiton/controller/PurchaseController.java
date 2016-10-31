/******************************************************************
 *
 *    
 *
 *    Copyright (c) 2016-forever 
 *    http://www.fzqblog.top
 *
 *    Package:     com.qiton.controller
 *
 *    Filename:    PurchaseController.java
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
 *    Create at:   2016年10月31日 下午4:58:42
 *
 *    Revision:
 *
 *    2016年10月31日 下午4:58:42
 *        - first revision
 *
 *****************************************************************/
package com.qiton.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qiton.exception.BussinessException;
import com.qiton.model.vo.SharesVo;
import com.qiton.service.ISharesApiService;

/**
 * @ClassName PurchaseController
 * @Description 买入控制层
 * @author 抽离
 * @Date 2016年10月31日 下午4:58:42
 * @version 1.0.0
 */
@RequestMapping("/purchase")
@Controller
public class PurchaseController extends BaseController {

	 private static final Logger LOGGER = LogManager.getLogger(PurchaseController.class);
	
	@Autowired
	private ISharesApiService iSharesApiService;
	
	
	/**
	 * 
	 * @Description 添加买入前调用api返回对应数据
	 * @param purId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("addPurchaseBefore")
	public Object addPurchaseBefore(Long purId){
		SharesVo sharesVo = null;
		try {
			 sharesVo = iSharesApiService.getSharesBySharesCode(purId);
			 
		}catch (BussinessException e) {
			LOGGER.info(e.getLocalizedMessage());
			return renderError(e.getLocalizedMessage());
		} catch (Exception e) {
			LOGGER.info(e.getLocalizedMessage());
			return renderError("获取股票出错，请重试");
		}	
		return renderSuccess(sharesVo);
	}
	
	
}

package com.qiton.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baomidou.mybatisplus.plugins.Page;
import com.qiton.exception.BussinessException;
import com.qiton.model.Admin;
import com.qiton.model.Reference;
import com.qiton.service.IReferenceService;

/**
 * 
* @ClassName: PubReferenceController 
* @Description: 内参管理 
* @author 尤
* @date 2016年11月2日 上午9:24:20 
*
 */
@Controller
@RequestMapping("/reference")
public class ReferenceController extends BaseController{
	
	private static final Logger log=LogManager.getLogger(ReferenceController.class);
	
	@Autowired
	private IReferenceService rerService;
	
	/**\
	 * 
	* @Title: pubReference 
	* @Description: 发布内参
	* @author 尤
	* @date 2016年11月2日 上午9:36:47  
	* @param @param reference
	* @param @param request
	* @param @return    设定文件 
	* @return Object    返回类型 
	* @throws
	 */
	@RequestMapping("/pubReference")
	public Object pubReference(Reference reference,HttpServletRequest request){
		try{
			rerService.pubReference(reference);
		}catch(BussinessException e){
			e.printStackTrace();
			log.info("--发布失败--"+e.getLocalizedMessage());
			return renderError(e.getLocalizedMessage());
		}
		return renderSuccess();
	}
	
	
	/**\
	 * 
	* @Title: pubReference 
	* @Description: 删除内参
	* @author 尤
	* @date 2016年11月2日 上午9:36:47  
	* @param @param reference
	* @param @param request
	* @param @return    设定文件 
	* @return Object    返回类型 
	* @throws
	 */
	@RequestMapping("/deleteReference")
	public Object deleteReference(Long rerId,HttpServletRequest request){
		try{
			rerService.deleteReference(rerId);
		}catch(BussinessException e){
			e.printStackTrace();
			log.info("--删除失败--"+e.getLocalizedMessage());
			return renderError(e.getLocalizedMessage());
		}
		return renderSuccess();
	}
	
	
	
	/**\
	 * 
	* @Title: pubReference 
	* @Description: 修改内参
	* @author 尤
	* @date 2016年11月2日 上午9:36:47  
	* @param @param reference
	* @param @param request
	* @param @return    设定文件 
	* @return Object    返回类型 
	* @throws
	 */
	@RequestMapping("/updateReference")
	public Object updateReference(Reference reference,Long rerId,HttpServletRequest request){
		try{
			rerService.updateReference(reference, rerId);
		}catch(BussinessException e){
			e.printStackTrace();
			log.info("--更新失败--"+e.getLocalizedMessage());
			return renderError(e.getLocalizedMessage());
		}
		return renderSuccess();
	}
	
	
	/**\
	 * 
	* @Title: pubReference 
	* @Description: 获取内参
	* @author 尤
	* @date 2016年11月2日 上午9:36:47  
	* @param @param reference
	* @param @param request
	* @param @return    设定文件 
	* @return Object    返回类型 
	* @throws
	 */
	@RequestMapping("/getAllReference")
	public Object getAllReference(Page<Reference> page,HttpServletRequest request){
		try{
			rerService.getAllReference(page);
		}catch(BussinessException e){
			e.printStackTrace();
			log.info("--获取失败--"+e.getLocalizedMessage());
			return renderError(e.getLocalizedMessage());
		}
		return renderSuccess(page);
	}
	
}

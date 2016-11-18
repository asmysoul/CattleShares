package com.qiton.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.plugins.Page;
import com.qiton.exception.BussinessException;
import com.qiton.model.Invite;
import com.qiton.model.SelectOptionTime;
import com.qiton.model.VipRecord;
import com.qiton.service.IVipRecordService;
import com.qiton.utils.Config;

/**
 * 
* @ClassName: VipRecordController 
* @Description: 资金记录--会员记录 
* @author 尤
* @date 2016年11月16日 上午9:35:17 
*
 */
@Controller
@RequestMapping("/vipRecord")
public class VipRecordController extends BaseController {
	
	private static final Logger log=LogManager.getLogger(VipRecordController.class);
	
	@Autowired
	private IVipRecordService iVipRecordService;
	
	
	/**
	 * 
	* @Title: getVipRecordList 
	* @Description: 资金记录---查询会员记录
	* @author 尤
	* @date 2016年11月16日 上午9:42:45  
	* @param @param current
	* @param @param request
	* @param @return    设定文件 
	* @return Object    返回类型 
	* @throws
	 */
	//http://localhost:8080/CattleShares/vipRecord/getVipRecordList?current=1  接口
	@RequestMapping("/getVipRecordList")
	@ResponseBody
	public Object getVipRecordList(String current,HttpServletRequest request){
		Page<VipRecord> page=new Page<VipRecord>(Integer.parseInt(current), Config.PAGENUM);
		try{
			iVipRecordService.getVipRecordList(page);
		}catch(BussinessException e){
			log.info(e.getLocalizedMessage());
			return renderError("查询失败"+e.getLocalizedMessage());
		}catch (Exception e) {
			log.info(e.getLocalizedMessage());
			return renderError("查询失败"+e.getLocalizedMessage());
		}
		return renderSuccess(page);
	}
	
	
	/**
	 * 
	* @Title: getVipRecordByCommand 
	* @Description: 条件查询会员记录
	* @author 尤
	* @date 2016年11月16日 上午10:02:48  
	* @param @param vipRecord
	* @param @param request
	* @param @return    设定文件 
	* @return Object    返回类型 
	* @throws
	 */
	@RequestMapping("/getVipRecordByCommand")
	@ResponseBody
	public Object getVipRecordByCommand(VipRecord vipRecord,String current,HttpServletRequest request){
		Page<VipRecord> page=new Page<VipRecord>(Integer.parseInt(current), Config.PAGENUM);
		try{
			iVipRecordService.getVipRecordByCommand(page,vipRecord);
		}catch(BussinessException e){
			log.info("条件查询失败--"+e.getLocalizedMessage());
			return renderError("条件查询失败--"+e.getLocalizedMessage());
		}catch (Exception e) {
			log.info("条件查询失败--"+e.getLocalizedMessage());
			return renderError("条件查询失败--"+e.getLocalizedMessage());
		}
		return renderSuccess(page);
	}
	
	
	/**
	 * 
	* @Title: getSelectTime 
	* @Description: 根据时间区间获得会员记录
	* @author 尤
	* @date 2016年11月15日 上午11:28:20  
	* @param @param current
	* @param @param optionTime
	* @param @param request
	* @param @return    设定文件 
	* @return Object    返回类型 
	* @throws
	 */
	@RequestMapping("/getVipRecordByTime")
	@ResponseBody
	public Object getVipRecordByTime(String current,SelectOptionTime optionTime, HttpServletRequest request) {
		Page<VipRecord> page2 = new Page<VipRecord>(Integer.parseInt(current), Config.PAGENUM);
		try {
			iVipRecordService.getVipRecordByTime(page2, optionTime);
		} catch (BussinessException e) {
			e.printStackTrace();
			return renderError(e.getLocalizedMessage());
		} catch (Exception e) {
			return  renderError("访问失败请重试-"+e.getLocalizedMessage());
		}
		return renderSuccess(page2);
	}
    
}

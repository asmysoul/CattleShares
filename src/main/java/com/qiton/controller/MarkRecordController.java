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
import com.qiton.model.MarkRecode;
import com.qiton.model.SelectOptionTime;
import com.qiton.model.VipManage;
import com.qiton.service.IMarkRecodeService;
import com.qiton.service.IUserService;
import com.qiton.utils.Config;

/**
 * 
* @ClassName: MarkRecordController 
* @Description: 积分记录 
* @author 尤
* @date 2016年11月17日 上午9:17:41 
*
 */
@Controller
@RequestMapping("/markRecord")
public class MarkRecordController extends BaseController {
	
	private static final Logger log=LogManager.getLogger(MarkRecordController.class);
	
	@Autowired
	private IMarkRecodeService imarkRecodeService;
	
	
	/**
	 * 
	* @Title: getmarkRecodeList 
	* @Description: 获得积分记录列表
	* @author 尤
	* @date 2016年11月17日 上午9:19:59  
	* @param @param current
	* @param @param request
	* @param @return    设定文件 
	* @return Object    返回类型 
	* @throws
	* http://localhost:8080/CattleShares/markRecord/getmarkRecodeList?current=1  接口
	 */
	@RequestMapping("/getmarkRecodeList")
	@ResponseBody
	public Object getmarkRecodeList(String current,HttpServletRequest request){
		Page<MarkRecode> page=new Page<>(Integer.parseInt(current), Config.PAGENUM);
		try{
			imarkRecodeService.getmarkRecodeList(page);
		}catch(BussinessException e){
			log.info(e.getLocalizedMessage());
			return renderError("数据查询出错"+e.getLocalizedMessage());
		}catch (Exception e) {
			// TODO: handle exception
			log.info(e.getLocalizedMessage());
			return renderError("数据查询出错"+e.getLocalizedMessage());
		}
		return renderSuccess(page);
	}
	
	/**
	 * 
	* @Title: markRecodeByTime 
	* @Description: 根据时间区间获取积分记录
	* @author 尤
	* @date 2016年11月17日 上午9:20:53  
	* @param @param current
	* @param @param optionTime
	* @param @param request
	* @param @return    设定文件 
	* @return Object    返回类型 
	* @throws
	 */
	@RequestMapping("/markRecodeByTime")
	@ResponseBody
	public Object markRecodeByTime(String current,SelectOptionTime optionTime, HttpServletRequest request) {
		Page<MarkRecode> page2 = new Page<MarkRecode>(Integer.parseInt(current), Config.PAGENUM);
		try {
			imarkRecodeService.markRecodeByTime(page2, optionTime);
		} catch (BussinessException e) {
			e.printStackTrace();
			return renderError(e.getLocalizedMessage());
		} catch (Exception e) {
			return  renderError("访问失败请重试-"+e.getLocalizedMessage());
		}
		return renderSuccess(page2);
	}

    
	 /**
	  * 
	 * @Title: getmarkRecodeProfittype 
	 * @Description: 根据收支类型获得积分列表
	 * @author 尤
	 * @date 2016年11月17日 上午9:21:26  
	 * @param @param current
	 * @param @param Profittype
	 * @param @param request
	 * @param @return    设定文件 
	 * @return Object    返回类型 
	 * @throws
	  */
		@RequestMapping("/getmarkRecodeProfittype")
		@ResponseBody
		public Object getmarkRecodeProfittype(String current,String Profittype, HttpServletRequest request) {
			Page<MarkRecode> page2 = new Page<MarkRecode>(Integer.parseInt(current), Config.PAGENUM);
			try {
				imarkRecodeService.getmarkRecodeProfittype(page2, Profittype);
			} catch (BussinessException e) {
				e.printStackTrace();
				return renderError(e.getLocalizedMessage());
			} catch (Exception e) {
				return  renderError("访问失败请重试-"+e.getLocalizedMessage());
			}
			return renderSuccess(page2);
		}
    
		
		/**
		 * 
		* @Title: getmarkRecodeByCommand 
		* @Description: 条件查询
		* @author 尤
		* @date 2016年11月17日 上午9:05:03  
		* @param @param markRecode
		* @param @param current
		* @param @param request
		* @param @return    设定文件 
		* @return Object    返回类型 
		* @throws
		 */
		@RequestMapping("/getmarkRecodeByCommand")
		@ResponseBody
		public Object getmarkRecodeByCommand(MarkRecode markRecode,String current,HttpServletRequest request){
			Page<MarkRecode> page2=new Page<MarkRecode>(Integer.parseInt(current), Config.PAGENUM);
			try{
				imarkRecodeService.getmarkRecodeByCommand(markRecode,page2);
			}catch(BussinessException e){
				log.info("查询错误");
				return renderError(e.getLocalizedMessage());
			}catch (Exception e) {
				log.info("查询错误");
				return renderError(e.getLocalizedMessage());
			}
			
			return renderSuccess(page2);
		}
	
		/**
		 * 
		* @Title: gotmarkRecodeManageJsp 
		* @Description: 跳转到邀请管理页面
		* @author 尤
		* @date 2016年11月16日 上午10:14:31  
		* @param @param request
		* @param @return    设定文件 
		* @return String    返回类型 
		* @throws
		 */
		@RequestMapping("/gotmarkRecodeManageJsp")
		public String gotmarkRecodeManageJsp(HttpServletRequest request){
			return "";
		}
}

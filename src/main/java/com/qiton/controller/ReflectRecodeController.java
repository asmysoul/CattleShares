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
import com.qiton.model.ReflectRecode;
import com.qiton.model.SelectOptionTime;
import com.qiton.model.VipManage;
import com.qiton.service.IReflectRecodeService;
import com.qiton.service.IReflectRecodeService;
import com.qiton.service.IUserService;
import com.qiton.utils.Config;

/**
 * 
* @ClassName: ReflectRecodeController 
* @Description: 体现记录 
* @author 尤
* @date 2016年11月17日 上午9:17:41 
*
 */
@Controller
@RequestMapping("/ReflectRecode")
public class ReflectRecodeController extends BaseController {
	
	private static final Logger log=LogManager.getLogger(ReflectRecodeController.class);
	
	@Autowired
	private IReflectRecodeService iReflectRecodeService;
	
	
	/**
	 * 
	* @Title: getReflectRecodeList 
	* @Description: 获得体现记录列表
	* @author 尤
	* @date 2016年11月17日 上午9:19:59  
	* @param @param current
	* @param @param request
	* @param @return    设定文件 
	* @return Object    返回类型 
	* @throws
	* http://localhost:8080/CattleShares/ReflectRecode/getReflectRecodeList?current=1
	 */
	@RequestMapping("/getReflectRecodeList")
	@ResponseBody
	public Object getReflectRecodeList(String current,HttpServletRequest request){
		Page<ReflectRecode> page=new Page<>(Integer.parseInt(current), Config.PAGENUM);
		try{
			iReflectRecodeService.getReflectRecodeList(page);
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
	* @Title: ReflectRecodeByTime 
	* @Description: 根据时间区间获取体现记录
	* @author 尤
	* @date 2016年11月17日 上午9:20:53  
	* @param @param current
	* @param @param optionTime
	* @param @param request
	* @param @return    设定文件 
	* @return Object    返回类型 
	* @throws
	 */
	@RequestMapping("/ReflectRecodeByTime")
	@ResponseBody
	public Object ReflectRecodeByTime(String current,SelectOptionTime optionTime, HttpServletRequest request) {
		Page<ReflectRecode> page2 = new Page<ReflectRecode>(Integer.parseInt(current), Config.PAGENUM);
		try {
			iReflectRecodeService.ReflectRecodeByTime(page2, optionTime);
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
	 * @Title: getReflectRecodeProfittype 
	 * @Description: 根据收支类型获得体现列表
	 * @author 尤
	 * @date 2016年11月17日 上午9:21:26  
	 * @param @param current
	 * @param @param Profittype
	 * @param @param request
	 * @param @return    设定文件 
	 * @return Object    返回类型 
	 * @throws
	  */
		@RequestMapping("/getReflectRecodeProfittype")
		@ResponseBody
		public Object getReflectRecodeProfittype(String current,String Profittype, HttpServletRequest request) {
			Page<ReflectRecode> page2 = new Page<ReflectRecode>(Integer.parseInt(current), Config.PAGENUM);
			try {
				iReflectRecodeService.getReflectRecodeProfittype(page2, Profittype);
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
		* @Title: getReflectRecodeByCommand 
		* @Description: 条件查询
		* @author 尤
		* @date 2016年11月17日 上午9:05:03  
		* @param @param ReflectRecode
		* @param @param current
		* @param @param request
		* @param @return    设定文件 
		* @return Object    返回类型 
		* @throws
		 */
		@RequestMapping("/getReflectRecodeByCommand")
		@ResponseBody
		public Object getReflectRecodeByCommand(ReflectRecode ReflectRecode,String current,HttpServletRequest request){
			Page<ReflectRecode> page2=new Page<ReflectRecode>(Integer.parseInt(current), Config.PAGENUM);
			try{
				iReflectRecodeService.getReflectRecodeByCommand(ReflectRecode,page2);
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
		* @Title: gotReflectRecodeManageJsp 
		* @Description: 跳转到邀请管理页面
		* @author 尤
		* @date 2016年11月16日 上午10:14:31  
		* @param @param request
		* @param @return    设定文件 
		* @return String    返回类型 
		* @throws
		 */
		@RequestMapping("/gotReflectRecodeManageJsp")
		public String gotReflectRecodeManageJsp(HttpServletRequest request){
			return "";
		}
}

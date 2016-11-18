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
import com.qiton.model.GoldRecord;
import com.qiton.model.GoldRecord;
import com.qiton.model.SelectOptionTime;
import com.qiton.model.VipManage;
import com.qiton.service.IGoldRecordService;
import com.qiton.service.IUserService;
import com.qiton.utils.Config;

/**
 * 
* @ClassName: GoldRecordController 
* @Description: 金币记录 
* @author 尤
* @date 2016年11月17日 上午8:58:23 
*
 */
@Controller
@RequestMapping("/goldRecord")
public class GoldRecordController extends BaseController {
	
	private static final Logger log=LogManager.getLogger(GoldRecordController.class);
	
	@Autowired
	private IGoldRecordService iGoldRecordService;
	
	
	/**
	 * 
	* @Title: getGoldRecordList 
	* @Description: 获得金币记录列表
	* @author 尤
	* @date 2016年11月17日 上午8:59:12  
	* @param @param current
	* @param @param request
	* @param @return    设定文件 
	* @return Object    返回类型 
	* @throws
	* http://localhost:8080/CattleShares/goldRecord/getgoldRecordList?current=1  接口
	 */
	@RequestMapping("/getgoldRecordList")
	@ResponseBody
	public Object getgoldRecordList(String current,HttpServletRequest request){
		Page<GoldRecord> page=new Page<>(Integer.parseInt(current), Config.PAGENUM);
		try{
			iGoldRecordService.getgoldRecordList(page);
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
	* @Title: goldRecordByTime 
	* @Description: 、根据时间区间获取金币记录
	* @author 尤
	* @date 2016年11月17日 上午9:02:48  
	* @param @param current
	* @param @param optionTime
	* @param @param request
	* @param @return    设定文件 
	* @return Object    返回类型 
	* @throws
	 */
	@RequestMapping("/goldRecordByTime")
	@ResponseBody
	public Object goldRecordByTime(String current,SelectOptionTime optionTime, HttpServletRequest request) {
		Page<GoldRecord> page2 = new Page<GoldRecord>(Integer.parseInt(current), Config.PAGENUM);
		try {
			iGoldRecordService.goldRecordByTime(page2, optionTime);
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
		 * @Title: getAllUser @Description:根据用户状态获得用户列表 @author 尤 @date 2016年10月26日
		 * 上午10:37:35 @param @param current @param @param request @param @return
		 * 设定文件 @return Object 返回类型 @throws
		 */
		@RequestMapping("/getGoldRecordProfittype")
		@ResponseBody
		public Object getGoldRecordProfittype(String current,String Profittype, HttpServletRequest request) {
			Page<GoldRecord> page2 = new Page<GoldRecord>(Integer.parseInt(current), Config.PAGENUM);
			try {
				iGoldRecordService.getGoldRecordProfittype(page2, Profittype);
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
		* @Title: getGoldRecordByCommand 
		* @Description: 条件查询
		* @author 尤
		* @date 2016年11月17日 上午9:05:03  
		* @param @param GoldRecord
		* @param @param current
		* @param @param request
		* @param @return    设定文件 
		* @return Object    返回类型 
		* @throws
		 */
		@RequestMapping("/getGoldRecordByCommand")
		@ResponseBody
		public Object getGoldRecordByCommand(GoldRecord GoldRecord,String current,HttpServletRequest request){
			Page<GoldRecord> page2=new Page<GoldRecord>(Integer.parseInt(current), Config.PAGENUM);
			try{
				iGoldRecordService.getGoldRecordByCommand(GoldRecord,page2);
			}catch(BussinessException e){
				log.info("查询错误");
				return renderError(e.getLocalizedMessage());
			}catch (Exception e) {
				log.info("查询错误");
				return renderError(e.getLocalizedMessage());
			}
			
			return renderSuccess(page2);
		}
	
}

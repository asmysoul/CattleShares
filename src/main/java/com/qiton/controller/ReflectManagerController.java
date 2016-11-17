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
import com.qiton.model.ReflectManager;
import com.qiton.model.ReflectRecode;
import com.qiton.model.SelectOptionTime;
import com.qiton.model.User;
import com.qiton.model.ReflectManager;
import com.qiton.service.IReflectRecodeService;
import com.qiton.service.IUserService;
import com.qiton.utils.Config;
import com.qiton.utils.StringUtils;

/**
 * 
* @ClassName: ReflectManagerController 
* @Description: 体现管理 
* @author 尤
* @date 2016年11月17日 下午2:05:55 
*
 */
@Controller
@RequestMapping("/ReflectManager")
public class ReflectManagerController extends BaseController {
	private static final Logger log=LogManager.getLogger(ReflectManagerController.class);
	
	@Autowired
	private IReflectRecodeService iReflectRecodeService;
	
	@Autowired
	private IUserService userService;
	
	/**
	 * 
	* @Title: getReflectManagerList 
	* @Description: 体现管理列表
	* @author 尤
	* @date 2016年11月17日 下午2:41:30  
	* @param @param current
	* @param @param request
	* @param @return    设定文件 
	* @return Object    返回类型 
	* @throws
	* http://localhost:8080/CattleShares/ReflectManager/getReflectManagerList?current=1  接口
	 */
	@RequestMapping("/getReflectManagerList")
	@ResponseBody
	public Object getReflectManagerList(String current,HttpServletRequest request){
		Page<ReflectManager> page=new Page<>(Integer.parseInt(current), Config.PAGENUM);
		try{
			iReflectRecodeService.getReflectManagerList(page);
		}catch(BussinessException e){
			log.info("获取失败---"+e.getLocalizedMessage());
			return renderError(e.getLocalizedMessage());
		}
		return renderSuccess(page);
	}
	
	
	 /**
	  * 
	 * @Title: getSelectTime 
	 * @Description: 通过时间区间获取体现管理列表
	 * @author 尤
	 * @date 2016年11月17日 下午3:13:21  
	 * @param @param page
	 * @param @param optionTime
	 * @param @param request
	 * @param @return    设定文件 
	 * @return Object    返回类型 
	 * @throws
	  */
		@RequestMapping("/getSelectTime")
		@ResponseBody
		public Object getSelectTime(String current,SelectOptionTime optionTime, HttpServletRequest request) {
			Page<ReflectManager> page2 = new Page<ReflectManager>(Integer.parseInt(current), Config.PAGENUM);
			try {
				iReflectRecodeService.getSelectTime(page2, optionTime);
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
		 * @Title: getSelectSatate 
		 * @Description: 根据处理状态获取列表
		 * @author 尤
		 * @date 2016年11月17日 下午3:14:47  
		 * @param @param current
		 * @param @param userState
		 * @param @param request
		 * @param @return    设定文件 
		 * @return Object    返回类型 
		 * @throws
		  */
			@RequestMapping("/getSelectSatate")
			@ResponseBody
			public Object getSelectSatate(String current,String userState, HttpServletRequest request) {
				Page<ReflectManager> page2 = new Page<ReflectManager>(Integer.parseInt(current), Config.PAGENUM);
				try {
					iReflectRecodeService.getSelectSatate(page2, userState);
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
			* @Title: selectReflectByCommand 
			* @Description: 条件查询
			* @author 尤
			* @date 2016年11月17日 下午3:16:21  
			* @param @param ReflectManager
			* @param @param current
			* @param @param request
			* @param @return    设定文件 
			* @return Object    返回类型 
			* @throws
			 */
			@RequestMapping("/selectReflectByCommand")
			@ResponseBody
			public Object selectReflectByCommand(ReflectManager ReflectManager,String current,HttpServletRequest request){
				Page<ReflectManager> page2=new Page<ReflectManager>(Integer.parseInt(current), Config.PAGENUM);
				try{
					iReflectRecodeService.selectReflectByCommand(ReflectManager,page2);
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
			* @Title: Update_UserInfo 
			* @Description: 体现操作
			* @author 尤
			* @date 2016年11月7日 上午11:13:48  
			* @param @param user
			* @param @param request
			* @param @return    设定文件 
			* @return Object    返回类型 
			* @throws
			 */
			@RequestMapping("/update_UserInfo")
			@ResponseBody
			public Object Update_UserInfo(String rrdId,String rrdPrice,HttpServletRequest request){
				try{
					if(StringUtils.isBlank(rrdId)||Double.parseDouble(rrdPrice)<0){
						throw new BussinessException("参数出错");
					}
					User user=userService.selectById(Long.parseLong(rrdId));
					if(Double.parseDouble(rrdPrice)>user.getGold()){
						throw new BussinessException("用户金额不足");
					}
					
					ReflectRecode whereEntity=new ReflectRecode();
					whereEntity.setRrdId(Long.parseLong(rrdId));
					
					ReflectRecode entity=iReflectRecodeService.selectById(Long.parseLong(rrdId));
					entity.setRrdPrice(Double.parseDouble(rrdPrice));
					entity.setRrdState(0);    //未处理
					//获取体现id，修改体现记录的体现价格
					iReflectRecodeService.update(entity, whereEntity);
				}catch(BussinessException e){
					e.printStackTrace();
					log.info("--修改体现操作失败---------" + e.getLocalizedMessage());
					return renderError(e.getLocalizedMessage());
				}catch (Exception e) {
					e.printStackTrace();
					log.info("--修改体现操作失败---------" + e.getLocalizedMessage());
					return renderError("修改体现操作失败");
				}
				return renderSuccess("修改体现操作成功");
			}
			
			
			/**
			 * 
			* @Title: Update_UserInfo 
			* @Description: 删除体现记录
			* @author 尤
			* @date 2016年11月7日 上午11:13:48  
			* @param @param user
			* @param @param request
			* @param @return    设定文件 
			* @return Object    返回类型 
			* @throws
			 */
			@RequestMapping("/deleteReflectRecord")
			@ResponseBody
			public Object deleteReflectRecord(String rrdId,HttpServletRequest request){
				try{
					if(StringUtils.isBlank(rrdId)){
						throw new BussinessException("参数出错");
					}
					iReflectRecodeService.deleteById(Long.parseLong(rrdId));
				}catch(BussinessException e){
					e.printStackTrace();
					log.info("--删除体现操作失败---------" + e.getLocalizedMessage());
					return renderError(e.getLocalizedMessage());
				}catch (Exception e) {
					e.printStackTrace();
					log.info("--删除体现操作失败---------" + e.getLocalizedMessage());
					return renderError("删除体现操作失败");
				}
				return renderSuccess("删除体现操作成功");
			}
}

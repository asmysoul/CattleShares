package com.qiton.service;

import com.qiton.exception.BussinessException;
import com.qiton.model.GoldRecord;
import com.qiton.model.SelectOptionTime;
import com.baomidou.framework.service.ISuperService;
import com.baomidou.mybatisplus.plugins.Page;

/**
 *
 * GoldRecord 表数据服务层接口
 *
 */
public interface IGoldRecordService extends ISuperService<GoldRecord> {

	/**
	 * 
	 * @Title: getgoldRecordList @Description: TODO @author 尤 @date 2016年11月17日
	 * 上午9:05:56 @param @param page @param @throws BussinessException
	 * 设定文件 @return void 返回类型 @throws
	 */
	void getgoldRecordList(Page<GoldRecord> page) throws BussinessException;

	/**
	 * 
	 * @Title: goldRecordByTime @Description: TODO @author 尤 @date 2016年11月17日
	 * 上午9:06:04 @param @param page2 @param @param optionTime 设定文件 @return void
	 * 返回类型 @throws
	 */
	void goldRecordByTime(Page<GoldRecord> page2, SelectOptionTime optionTime);

	/**
	 * 
	 * @Title: getGoldRecordProfittype @Description: TODO @author 尤 @date
	 * 2016年11月17日 上午9:06:08 @param @param page2 @param @param Profittype
	 * 设定文件 @return void 返回类型 @throws
	 */
	void getGoldRecordProfittype(Page<GoldRecord> page2, String Profittype);

	/**
	 * 
	 * @Title: getGoldRecordByCommand @Description: TODO @author 尤 @date
	 * 2016年11月17日 上午9:06:11 @param @param goldRecord @param @param page2
	 * 设定文件 @return void 返回类型 @throws
	 */
	void getGoldRecordByCommand(GoldRecord goldRecord, Page<GoldRecord> page2);

}
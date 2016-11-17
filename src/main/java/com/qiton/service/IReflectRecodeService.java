package com.qiton.service;

import com.qiton.exception.BussinessException;
import com.qiton.model.ReflectRecode;
import com.qiton.model.SelectOptionTime;
import com.baomidou.framework.service.ISuperService;
import com.baomidou.mybatisplus.plugins.Page;

/**
 *
 * ReflectRecode 表数据服务层接口
 *
 */
public interface IReflectRecodeService extends ISuperService<ReflectRecode> {

	public void getReflectRecodeList(Page<ReflectRecode> page)throws BussinessException;

	public void ReflectRecodeByTime(Page<ReflectRecode> page2, SelectOptionTime optionTime)throws BussinessException;

	public void getReflectRecodeProfittype(Page<ReflectRecode> page2, String profittype)throws BussinessException;

	public void getReflectRecodeByCommand(ReflectRecode reflectRecode, Page<ReflectRecode> page2)throws BussinessException;


}
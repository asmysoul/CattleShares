package com.qiton.service;

import com.qiton.exception.BussinessException;
import com.qiton.model.MarkRecode;
import com.qiton.model.SelectOptionTime;
import com.baomidou.framework.service.ISuperService;
import com.baomidou.mybatisplus.plugins.Page;

/**
 *
 * MarkRecode 表数据服务层接口
 *
 */
public interface IMarkRecodeService extends ISuperService<MarkRecode> {

	public void getmarkRecodeList(Page<MarkRecode> page)throws BussinessException;

	public void markRecodeByTime(Page<MarkRecode> page2, SelectOptionTime optionTime)throws BussinessException;

	public void getmarkRecodeProfittype(Page<MarkRecode> page2, String profittype)throws BussinessException;

	public void getmarkRecodeByCommand(MarkRecode markRecode, Page<MarkRecode> page2)throws BussinessException;


}
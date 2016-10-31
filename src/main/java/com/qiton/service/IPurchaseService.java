package com.qiton.service;

import com.qiton.exception.BussinessException;
import com.qiton.model.Purchase;

import java.util.List;

import com.baomidou.framework.service.ISuperService;

/**
 *@author 抽离
 * Purchase 表数据服务层接口
 *
 */
public interface IPurchaseService extends ISuperService<Purchase> {

	public void addPurchase(Purchase purchase) throws BussinessException;
	
	public void updatePurchase(Purchase purchase) throws BussinessException;
	
	public void deletePurchase(Purchase purchase) throws BussinessException;
	
	public List<Purchase> findPurchases()throws BussinessException;

}
package com.qiton.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qiton.exception.BussinessException;
import com.qiton.mapper.PurchaseMapper;
import com.qiton.model.Purchase;
import com.qiton.model.Shares;
import com.qiton.service.IPurchaseService;
import com.qiton.service.ISharesApiService;
import com.baomidou.framework.service.impl.SuperServiceImpl;

/**
 *
 * Purchase 表数据服务层接口实现类
 *
 */
@Service
public class PurchaseServiceImpl extends SuperServiceImpl<PurchaseMapper, Purchase> implements IPurchaseService {

	@Autowired
	private ISharesApiService iSharesApiService;
	
	/*
	 * Description: 添加买入
	 * @see com.qiton.service.IPurchaseService#addPurchase(com.qiton.model.Purchase)
	 */
	@Override
	public void addPurchase(Purchase purchase) throws BussinessException {
		
	}

	/* (非 Javadoc)
	 * Description:
	 * @see com.qiton.service.IPurchaseService#updatePurchase(com.qiton.model.Purchase)
	 */
	@Override
	public void updatePurchase(Purchase purchase) throws BussinessException {
		// TODO Auto-generated method stub
		
	}

	/* (非 Javadoc)
	 * Description:
	 * @see com.qiton.service.IPurchaseService#deletePurchase(com.qiton.model.Purchase)
	 */
	@Override
	public void deletePurchase(Purchase purchase) throws BussinessException {
		// TODO Auto-generated method stub
		
	}

	/* (非 Javadoc)
	 * Description:
	 * @see com.qiton.service.IPurchaseService#findPurchases()
	 */
	@Override
	public List<Purchase> findPurchases() throws BussinessException {
		// TODO Auto-generated method stub
		return null;
	}


}
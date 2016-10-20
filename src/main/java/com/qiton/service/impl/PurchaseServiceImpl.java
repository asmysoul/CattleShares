package com.qiton.service.impl;

import org.springframework.stereotype.Service;

import com.qiton.mapper.PurchaseMapper;
import com.qiton.model.Purchase;
import com.qiton.service.IPurchaseService;
import com.baomidou.framework.service.impl.SuperServiceImpl;

/**
 *
 * Purchase 表数据服务层接口实现类
 *
 */
@Service
public class PurchaseServiceImpl extends SuperServiceImpl<PurchaseMapper, Purchase> implements IPurchaseService {


}
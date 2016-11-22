package com.qiton.model;

import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
* @ClassName: ReflectManager 
* @Description: 体现管理 model
* @author 尤
* @date 2016年11月17日 下午2:18:30 
*
 */
public class ReflectManager {
	
	private Long rrdId; 
	/** 申请时间 */
	private Date rrdApplytime;
	
	/** 体现用户账号id */
	private Long rrdUserid;

	/** 体现用户昵称 */
	private String rrdUsername;

	/** 体现金额 */
	private Double rrdPrice;

	/** 账户类型：0:财付通，1：支付宝 2：银行 */
	private Integer accountType;

	/** 体现账户 */
	private String reflectAccount;
	
	/** 状态：0.未处理1，已处理 */
	private Integer rrdState;

	
	
	
	public ReflectManager() {
		super();
	}

	public ReflectManager(Date rrdApplytime, Long rrdUserid, String rrdUsername, Double rrdPrice, Integer accountType,
			String reflectAccount, Integer rrdState) {
		super();
		this.rrdApplytime = rrdApplytime;
		this.rrdUserid = rrdUserid;
		this.rrdUsername = rrdUsername;
		this.rrdPrice = rrdPrice;
		this.accountType = accountType;
		this.reflectAccount = reflectAccount;
		this.rrdState = rrdState;
	}

	@Override
	public String toString() {
		return "ReflectManager [rrdApplytime=" + rrdApplytime + ", rrdUserid=" + rrdUserid + ", rrdUsername="
				+ rrdUsername + ", rrdPrice=" + rrdPrice + ", accountType=" + accountType + ", reflectAccount="
				+ reflectAccount + ", rrdState=" + rrdState + "]";
	}

	public Long getRrdId() {
		return rrdId;
	}

	public void setRrdId(Long rrdId) {
		this.rrdId = rrdId;
	}
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	public Date getRrdApplytime() {
		return rrdApplytime;
	}

	public void setRrdApplytime(Date rrdApplytime) {
		this.rrdApplytime = rrdApplytime;
	}

	public Long getRrdUserid() {
		return rrdUserid;
	}

	public void setRrdUserid(Long rrdUserid) {
		this.rrdUserid = rrdUserid;
	}

	public String getRrdUsername() {
		return rrdUsername;
	}

	public void setRrdUsername(String rrdUsername) {
		this.rrdUsername = rrdUsername;
	}

	public Double getRrdPrice() {
		return rrdPrice;
	}

	public void setRrdPrice(Double rrdPrice) {
		this.rrdPrice = rrdPrice;
	}

	public Integer getAccountType() {
		return accountType;
	}

	public void setAccountType(Integer accountType) {
		this.accountType = accountType;
	}

	public String getReflectAccount() {
		return reflectAccount;
	}

	public void setReflectAccount(String reflectAccount) {
		this.reflectAccount = reflectAccount;
	}

	public Integer getRrdState() {
		return rrdState;
	}

	public void setRrdState(Integer rrdState) {
		this.rrdState = rrdState;
	}

	
	
}

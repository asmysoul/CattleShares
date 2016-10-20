package com.qiton.model;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.IdType;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 *
 * 
 *
 */
@TableName("mark_recode")
public class MarkRecode implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/** 账号id */
	@TableId(value = "mrd_id", type = IdType.AUTO)
	private Long mrdId;

	/** 账号昵称 */
	@TableField(value = "mrd_username")
	private String mrdUsername;

	/** 收支类型：0：邀请，1：充值 */
	@TableField(value = "mrd_profittype")
	private Integer mrdProfittype;

	/** 时间 */
	@TableField(value = "mrd_time")
	private Date mrdTime;

	/** 收入 */
	@TableField(value = "mrd_income")
	private Float mrdIncome;

	/** 支出 */
	@TableField(value = "mrd_pay")
	private Float mrdPay;

	/** 余钱 */
	@TableField(value = "mrd_share")
	private Float mrdShare;

	/** 备注 */
	@TableField(value = "mrd_remark")
	private String mrdRemark;


	public Long getMrdId() {
		return this.mrdId;
	}

	public void setMrdId(Long mrdId) {
		this.mrdId = mrdId;
	}

	public String getMrdUsername() {
		return this.mrdUsername;
	}

	public void setMrdUsername(String mrdUsername) {
		this.mrdUsername = mrdUsername;
	}

	public Integer getMrdProfittype() {
		return this.mrdProfittype;
	}

	public void setMrdProfittype(Integer mrdProfittype) {
		this.mrdProfittype = mrdProfittype;
	}

	public Date getMrdTime() {
		return this.mrdTime;
	}

	public void setMrdTime(Date mrdTime) {
		this.mrdTime = mrdTime;
	}

	public Float getMrdIncome() {
		return this.mrdIncome;
	}

	public void setMrdIncome(Float mrdIncome) {
		this.mrdIncome = mrdIncome;
	}

	public Float getMrdPay() {
		return this.mrdPay;
	}

	public void setMrdPay(Float mrdPay) {
		this.mrdPay = mrdPay;
	}

	public Float getMrdShare() {
		return this.mrdShare;
	}

	public void setMrdShare(Float mrdShare) {
		this.mrdShare = mrdShare;
	}

	public String getMrdRemark() {
		return this.mrdRemark;
	}

	public void setMrdRemark(String mrdRemark) {
		this.mrdRemark = mrdRemark;
	}

}

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
@TableName("gold_record")
public class GoldRecord implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/** 账户id */
	@TableId(value = "grd_id", type = IdType.AUTO)
	private Long grdId;

	/** 账户名称 */
	@TableField(value = "grd_username")
	private String grdUsername;

	/** 收益类型：0.邀请，1：充值 */
	@TableField(value = "grd_profittype")
	private Integer grdProfittype;

	/** 时间 */
	@TableField(value = "grd_time")
	private Date grdTime;

	/** 收入 */
	@TableField(value = "grd_income")
	private Float grdIncome;

	/** 支出 */
	@TableField(value = "grd_pay")
	private Float grdPay;

	/** 余钱 */
	@TableField(value = "grd_spare")
	private Float grdSpare;

	/** 备注 */
	@TableField(value = "grd_remark")
	private String grdRemark;


	public Long getGrdId() {
		return this.grdId;
	}

	public void setGrdId(Long grdId) {
		this.grdId = grdId;
	}

	public String getGrdUsername() {
		return this.grdUsername;
	}

	public void setGrdUsername(String grdUsername) {
		this.grdUsername = grdUsername;
	}

	public Integer getGrdProfittype() {
		return this.grdProfittype;
	}

	public void setGrdProfittype(Integer grdProfittype) {
		this.grdProfittype = grdProfittype;
	}

	public Date getGrdTime() {
		return this.grdTime;
	}

	public void setGrdTime(Date grdTime) {
		this.grdTime = grdTime;
	}

	public Float getGrdIncome() {
		return this.grdIncome;
	}

	public void setGrdIncome(Float grdIncome) {
		this.grdIncome = grdIncome;
	}

	public Float getGrdPay() {
		return this.grdPay;
	}

	public void setGrdPay(Float grdPay) {
		this.grdPay = grdPay;
	}

	public Float getGrdSpare() {
		return this.grdSpare;
	}

	public void setGrdSpare(Float grdSpare) {
		this.grdSpare = grdSpare;
	}

	public String getGrdRemark() {
		return this.grdRemark;
	}

	public void setGrdRemark(String grdRemark) {
		this.grdRemark = grdRemark;
	}

}

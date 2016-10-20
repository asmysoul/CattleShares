package com.qiton.model;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.IdType;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

/**
 *
 * 
 *
 */
public class Purchase implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/**  */
	@TableId(value = "pur_id", type = IdType.AUTO)
	private Long purId;

	/**  */
	@TableField(value = "pur_stockcode")
	private Integer purStockcode;

	/**  */
	@TableField(value = "pur_stockname")
	private String purStockname;

	/**  */
	@TableField(value = "pur_purchasetime")
	private Date purPurchasetime;

	/**  */
	@TableField(value = "pur_stockprice")
	private Float purStockprice;

	/**  */
	@TableField(value = "pur_technick")
	private String purTechnick;


	public Long getPurId() {
		return this.purId;
	}

	public void setPurId(Long purId) {
		this.purId = purId;
	}

	public Integer getPurStockcode() {
		return this.purStockcode;
	}

	public void setPurStockcode(Integer purStockcode) {
		this.purStockcode = purStockcode;
	}

	public String getPurStockname() {
		return this.purStockname;
	}

	public void setPurStockname(String purStockname) {
		this.purStockname = purStockname;
	}

	public Date getPurPurchasetime() {
		return this.purPurchasetime;
	}

	public void setPurPurchasetime(Date purPurchasetime) {
		this.purPurchasetime = purPurchasetime;
	}

	public Float getPurStockprice() {
		return this.purStockprice;
	}

	public void setPurStockprice(Float purStockprice) {
		this.purStockprice = purStockprice;
	}

	public String getPurTechnick() {
		return this.purTechnick;
	}

	public void setPurTechnick(String purTechnick) {
		this.purTechnick = purTechnick;
	}

}

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
public class Sellout implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/** 0:普通用户，1：会员 */
	@TableField(value = "sell_type")
	private Integer sellType;

	/**  */
	@TableId(value = "sell_id", type = IdType.AUTO)
	private Long sellId;

	/** 股票代码 */
	@TableField(value = "sell_stockcode")
	private Long sellStockcode;

	/** 卖出时间 */
	@TableField(value = "sell_selltime")
	private Date sellSelltime;

	/** 卖出价格 */
	@TableField(value = "sell_sellprice")
	private Double sellSellprice;

	/** 推荐老师 */
	@TableField(value = "sell_technick")
	private String sellTechnick;

	/** 买入时间 */
	@TableField(value = "pur_purtime")
	private Date purPurtime;

	/** 买入价格 */
	@TableField(value = "pur_purprice")
	private Double purPurprice;


	public Integer getSellType() {
		return this.sellType;
	}

	public void setSellType(Integer sellType) {
		this.sellType = sellType;
	}

	public Long getSellId() {
		return this.sellId;
	}

	public void setSellId(Long sellId) {
		this.sellId = sellId;
	}

	public Long getSellStockcode() {
		return this.sellStockcode;
	}

	public void setSellStockcode(Long sellStockcode) {
		this.sellStockcode = sellStockcode;
	}

	public Date getSellSelltime() {
		return this.sellSelltime;
	}

	public void setSellSelltime(Date sellSelltime) {
		this.sellSelltime = sellSelltime;
	}

	public Double getSellSellprice() {
		return this.sellSellprice;
	}

	public void setSellSellprice(Double sellSellprice) {
		this.sellSellprice = sellSellprice;
	}

	public String getSellTechnick() {
		return this.sellTechnick;
	}

	public void setSellTechnick(String sellTechnick) {
		this.sellTechnick = sellTechnick;
	}

	public Date getPurPurtime() {
		return this.purPurtime;
	}

	public void setPurPurtime(Date purPurtime) {
		this.purPurtime = purPurtime;
	}

	public Double getPurPurprice() {
		return this.purPurprice;
	}

	public void setPurPurprice(Double purPurprice) {
		this.purPurprice = purPurprice;
	}

}

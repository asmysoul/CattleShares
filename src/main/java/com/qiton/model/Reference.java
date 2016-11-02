package com.qiton.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.IdType;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

/**
 *
 * 
 *
 */
public class Reference implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/** 内参id */
	@TableId(value = "rer_id", type = IdType.AUTO)
	private Long rerId;

	/** 股票代码 */
	@TableField(value = "rer_shareCode")
	private Long rerSharecode;

	/** 内参消息 */
	@TableField(value = "rer_rerInfo")
	private String rerRerinfo;


	public Long getRerId() {
		return this.rerId;
	}

	public void setRerId(Long rerId) {
		this.rerId = rerId;
	}

	public Long getRerSharecode() {
		return this.rerSharecode;
	}

	public void setRerSharecode(Long rerSharecode) {
		this.rerSharecode = rerSharecode;
	}

	public String getRerRerinfo() {
		return this.rerRerinfo;
	}

	public void setRerRerinfo(String rerRerinfo) {
		this.rerRerinfo = rerRerinfo;
	}

	public Reference() {
		super();
	}

	public Reference(Long rerSharecode, String rerRerinfo) {
		super();
		this.rerSharecode = rerSharecode;
		this.rerRerinfo = rerRerinfo;
	}

	@Override
	public String toString() {
		return "Reference [rerId=" + rerId + ", rerSharecode=" + rerSharecode + ", rerRerinfo=" + rerRerinfo + "]";
	}

	
	
	
}

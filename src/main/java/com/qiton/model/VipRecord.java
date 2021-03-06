package com.qiton.model;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.IdType;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 *
 * 
 *
 */
@TableName("vip_record")
public class VipRecord implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/** 会员记录id */
	@TableId(value = "vrd_id", type = IdType.AUTO)
	private Long vrdId;

	/** 账户id */
	@TableField(value = "vrd_userid")
	private Long vrdUserid;

	/** 账户昵称 */
	@TableField(value = "vrd_username")
	private String vrdUsername;

	/** 充值时间 */
	@TableField(value = "vrd_rechargetime")
	private Date vrdRechargetime;

	/** 充值金额 */
	@TableField(value = "vrd_rechargeprice")
	private Integer vrdRechargeprice;

	/** 备注 */
	@TableField(value = "vrd_remark")
	private String vrdRemark;


	public Long getVrdUserid() {
		return this.vrdUserid;
	}

	public void setVrdUserid(Long vrdUserid) {
		this.vrdUserid = vrdUserid;
	}

	public String getVrdUsername() {
		return this.vrdUsername;
	}

	public void setVrdUsername(String vrdUsername) {
		this.vrdUsername = vrdUsername;
	}
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	public Date getVrdRechargetime() {
		return this.vrdRechargetime;
	}

	public void setVrdRechargetime(Date vrdRechargetime) {
		this.vrdRechargetime = vrdRechargetime;
	}

	public Integer getVrdRechargeprice() {
		return this.vrdRechargeprice;
	}

	public void setVrdRechargeprice(Integer vrdRechargeprice) {
		this.vrdRechargeprice = vrdRechargeprice;
	}

	public String getVrdRemark() {
		return this.vrdRemark;
	}

	public void setVrdRemark(String vrdRemark) {
		this.vrdRemark = vrdRemark;
	}

	@Override
	public String toString() {
		return "VipRecord [vrdUserid=" + vrdUserid + ", vrdUsername=" + vrdUsername + ", vrdRechargetime="
				+ vrdRechargetime + ", vrdRechargeprice=" + vrdRechargeprice + ", vrdRemark=" + vrdRemark + "]";
	}

	public VipRecord(Long vrdUserid, String vrdUsername, Date vrdRechargetime, Integer vrdRechargeprice,
			String vrdRemark) {
		super();
		this.vrdUserid = vrdUserid;
		this.vrdUsername = vrdUsername;
		this.vrdRechargetime = vrdRechargetime;
		this.vrdRechargeprice = vrdRechargeprice;
		this.vrdRemark = vrdRemark;
	}

	
	
	
}

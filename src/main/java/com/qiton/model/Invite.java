package com.qiton.model;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.IdType;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 *
 * 
 *
 */
public class Invite implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/**  */
	@TableId(value = "invi_id", type = IdType.AUTO)
	private Long inviId;

	/** 发起邀请用户 */
	@TableField(value = "invi_username")
	private String inviUsername;

	/**  */
	@TableField(value = "invi_acceptuserId")
	private Long inviAcceptuserid;

	/** 接受邀请用户 */
	@TableField(value = "invi_acceptuser")
	private String inviAcceptuser;

	/** 接受人电话 */
	@TableField(value = "invi_acceptmobile")
	private String inviAcceptmobile;

	/** 接受人注册时间 */
	@TableField(value = "invi_registtime")
	private Date inviRegisttime;

	/** 被邀请人用户状态：0:未开通，1:已开通，2:已过期 */
	@TableField(value = "invi_acceptuserstate")
	private Long inviAcceptuserstate;

	/** 邀请金币 */
	@TableField(value = "invi_gold")
	private Integer inviGold;

	/** 邀请积分 */
	@TableField(value = "invi_mark")
	private Integer inviMark;

	/** 充值时间 */
	@TableField(value = "invi_recharge")
	private Date inviRecharge;


	public Long getInviId() {
		return this.inviId;
	}

	public void setInviId(Long inviId) {
		this.inviId = inviId;
	}

	public String getInviUsername() {
		return this.inviUsername;
	}

	public void setInviUsername(String inviUsername) {
		this.inviUsername = inviUsername;
	}

	public Long getInviAcceptuserid() {
		return this.inviAcceptuserid;
	}

	public void setInviAcceptuserid(Long inviAcceptuserid) {
		this.inviAcceptuserid = inviAcceptuserid;
	}

	public String getInviAcceptuser() {
		return this.inviAcceptuser;
	}

	public void setInviAcceptuser(String inviAcceptuser) {
		this.inviAcceptuser = inviAcceptuser;
	}

	public String getInviAcceptmobile() {
		return this.inviAcceptmobile;
	}

	public void setInviAcceptmobile(String inviAcceptmobile) {
		this.inviAcceptmobile = inviAcceptmobile;
	}
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	public Date getInviRegisttime() {
		return this.inviRegisttime;
	}

	public void setInviRegisttime(Date inviRegisttime) {
		this.inviRegisttime = inviRegisttime;
	}

	

	public Long getInviAcceptuserstate() {
		return inviAcceptuserstate;
	}

	public void setInviAcceptuserstate(Long inviAcceptuserstate) {
		this.inviAcceptuserstate = inviAcceptuserstate;
	}

	public Integer getInviGold() {
		return this.inviGold;
	}

	public void setInviGold(Integer inviGold) {
		this.inviGold = inviGold;
	}

	public Integer getInviMark() {
		return this.inviMark;
	}

	public void setInviMark(Integer inviMark) {
		this.inviMark = inviMark;
	}
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	public Date getInviRecharge() {
		return this.inviRecharge;
	}

	public void setInviRecharge(Date inviRecharge) {
		this.inviRecharge = inviRecharge;
	}

	public Invite() {
		super();
	}

	@Override
	public String toString() {
		return "Invite [inviId=" + inviId + ", inviUsername=" + inviUsername + ", inviAcceptuserid=" + inviAcceptuserid
				+ ", inviAcceptuser=" + inviAcceptuser + ", inviAcceptmobile=" + inviAcceptmobile + ", inviRegisttime="
				+ inviRegisttime + ", inviAcceptuserstate=" + inviAcceptuserstate + ", inviGold=" + inviGold + ", inviMark="
				+ inviMark + ", inviRecharge=" + inviRecharge + "]";
	}

	
	
}

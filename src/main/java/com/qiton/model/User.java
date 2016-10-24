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
public class User implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/**  */
	@TableId(value = "user_id", type = IdType.AUTO)
	private Long userId;

	/**  */
	@TableField(value = "user_name")
	private String userName;

	/**  */
	private String password;

	/** 0:普通用户，1:会员用户，2:合作用户 */
	private Integer grade = 0;

	/**  */
	@TableField(value = "register_time")
	private Date registerTime;

	/**  */
	@TableField(value = "end_vip_time")
	private Date endVipTime;

	/** 0:未开通，1:已开通，2:已过期 */
	@TableField(value = "vip_status")
	private Integer vipStatus = 0;

	/**  */
	private Integer phone;

	/**  */
	private Integer gold;

	/**  */
	private Integer mark;

	/** 0:财付通，1：支付宝 2：银行 */
	@TableField(value = "account_type")
	private Integer accountType;

	/** 提现账户 */
	@TableField(value = "reflect_account")
	private String reflectAccount;
	
	@TableField(exist = false)
	private String validateCode;
	
	


	/**
	 * @return the validateCode
	 */
	public String getValidateCode() {
		return validateCode;
	}

	/**
	 * @param validateCode the validateCode to set
	 */
	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getGrade() {
		return this.grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public Date getRegisterTime() {
		return this.registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	public Date getEndVipTime() {
		return this.endVipTime;
	}

	public void setEndVipTime(Date endVipTime) {
		this.endVipTime = endVipTime;
	}

	public Integer getVipStatus() {
		return this.vipStatus;
	}

	public void setVipStatus(Integer vipStatus) {
		this.vipStatus = vipStatus;
	}

	public Integer getPhone() {
		return this.phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public Integer getGold() {
		return this.gold;
	}

	public void setGold(Integer gold) {
		this.gold = gold;
	}

	public Integer getMark() {
		return this.mark;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}

	public Integer getAccountType() {
		return this.accountType;
	}

	public void setAccountType(Integer accountType) {
		this.accountType = accountType;
	}

	public String getReflectAccount() {
		return this.reflectAccount;
	}

	public void setReflectAccount(String reflectAccount) {
		this.reflectAccount = reflectAccount;
	}

}

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
public class Problem implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/**  */
	@TableId(value = "pro_id", type = IdType.AUTO)
	private Long proId;

	/** 咨询问题内参 */
	@TableField(value = "pro_userquestion")
	private String proUserquestion;

	/** 老师昵称 */
	@TableField(value = "pro_technick")
	private String proTechnick;

	/** 回复内容 */
	@TableField(value = "pro_answer")
	private String proAnswer;

	/** 创建时间 */
	@TableField(value = "pro_createtime")
	private Date proCreatetime;

	/** 提问时间 */
	@TableField(value = "pro_questiontime")
	private Date proQuestiontime;

	/** 回答时间 */
	@TableField(value = "pro_answertime")
	private Date proAnswertime;

	/** 提问用户名字 */
	@TableField(value = "user_id")
	private Long userId;

	/** 老师id */
	@TableField(value = "tech_id")
	private Long techId;


	public Long getProId() {
		return this.proId;
	}

	public void setProId(Long proId) {
		this.proId = proId;
	}

	public String getProUserquestion() {
		return this.proUserquestion;
	}

	public void setProUserquestion(String proUserquestion) {
		this.proUserquestion = proUserquestion;
	}

	public String getProTechnick() {
		return this.proTechnick;
	}

	public void setProTechnick(String proTechnick) {
		this.proTechnick = proTechnick;
	}

	public String getProAnswer() {
		return this.proAnswer;
	}

	public void setProAnswer(String proAnswer) {
		this.proAnswer = proAnswer;
	}

	public Date getProCreatetime() {
		return this.proCreatetime;
	}

	public void setProCreatetime(Date proCreatetime) {
		this.proCreatetime = proCreatetime;
	}

	public Date getProQuestiontime() {
		return this.proQuestiontime;
	}

	public void setProQuestiontime(Date proQuestiontime) {
		this.proQuestiontime = proQuestiontime;
	}

	public Date getProAnswertime() {
		return this.proAnswertime;
	}

	public void setProAnswertime(Date proAnswertime) {
		this.proAnswertime = proAnswertime;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getTechId() {
		return this.techId;
	}

	public void setTechId(Long techId) {
		this.techId = techId;
	}

}

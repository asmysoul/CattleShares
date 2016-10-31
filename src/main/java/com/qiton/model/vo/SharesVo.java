/******************************************************************
 *
 *    
 *
 *    Copyright (c) 2016-forever 
 *    http://www.fzqblog.top
 *
 *    Package:     com.qiton.model.vo
 *
 *    Filename:    SharesVo.java
 *
 *    Description: TODO(用一句话描述该文件做什么)
 *
 *    Copyright:   Copyright (c) 2001-2014
 *
 *    Company:     fzqblog
 *
 *    @author:     抽离
 *
 *    @version:    1.0.0
 *
 *    Create at:   2016年10月31日 下午4:15:47
 *
 *    Revision:
 *
 *    2016年10月31日 下午4:15:47
 *        - first revision
 *
 *****************************************************************/
package com.qiton.model.vo;

import java.util.Date;

/**
 * @ClassName SharesVo
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 抽离
 * @Date 2016年10月31日 下午4:15:47
 * @version 1.0.0
 */
public class SharesVo {

	private String name;

	private String code;

	private String remark;

	private String monthurl;

	private String minurl;

	private String weekurl;

	private String dayurl;

	private double nowPrice;

	private Date curDate;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark
	 *            the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * @return the monthurl
	 */
	public String getMonthurl() {
		return monthurl;
	}

	/**
	 * @param monthurl
	 *            the monthurl to set
	 */
	public void setMonthurl(String monthurl) {
		this.monthurl = monthurl;
	}

	/**
	 * @return the minurl
	 */
	public String getMinurl() {
		return minurl;
	}

	/**
	 * @param minurl
	 *            the minurl to set
	 */
	public void setMinurl(String minurl) {
		this.minurl = minurl;
	}

	/**
	 * @return the weekurl
	 */
	public String getWeekurl() {
		return weekurl;
	}

	/**
	 * @param weekurl
	 *            the weekurl to set
	 */
	public void setWeekurl(String weekurl) {
		this.weekurl = weekurl;
	}

	/**
	 * @return the dayurl
	 */
	public String getDayurl() {
		return dayurl;
	}

	/**
	 * @param dayurl
	 *            the dayurl to set
	 */
	public void setDayurl(String dayurl) {
		this.dayurl = dayurl;
	}

	/**
	 * @return the nowPrice
	 */
	public double getNowPrice() {
		return nowPrice;
	}

	/**
	 * @param nowPrice
	 *            the nowPrice to set
	 */
	public void setNowPrice(double nowPrice) {
		this.nowPrice = nowPrice;
	}

	/**
	 * @return the curDate
	 */
	public Date getCurDate() {
		return curDate;
	}

	/**
	 * @param curDate
	 *            the curDate to set
	 */
	public void setCurDate(Date curDate) {
		this.curDate = curDate;
	}

	/* (非 Javadoc)
	 * Description:
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SharesVo [name=" + name + ", code=" + code + ", remark=" + remark + ", monthurl=" + monthurl
				+ ", minurl=" + minurl + ", weekurl=" + weekurl + ", dayurl=" + dayurl + ", nowPrice=" + nowPrice
				+ ", curDate=" + curDate + "]";
	}
	
}

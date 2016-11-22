package com.qiton.model;
/**
 * 
* @ClassName: FriendsInvite 
* @Description: 好友邀请 model
* @author 尤
* @date 2016年11月21日 上午9:20:37 
*
 */
public class FriendsInvite {
	private Integer inviteCount;//邀请数量
	private Integer sumGold;//总收益金币
	private Integer sumMark;//总收益积分
	
	
	
	
	public Integer getInviteCount() {
		return inviteCount;
	}

	public void setInviteCount(Integer inviteCount) {
		this.inviteCount = inviteCount;
	}

	public Integer getSumGold() {
		return sumGold;
	}

	public void setSumGold(Integer sumGold) {
		this.sumGold = sumGold;
	}

	public Integer getSumMark() {
		return sumMark;
	}

	public void setSumMark(Integer sumMark) {
		this.sumMark = sumMark;
	}

	public FriendsInvite() {
		super();
	}

	public FriendsInvite(Integer inviteCount, Integer sumGold, Integer sumMark) {
		super();
		this.inviteCount = inviteCount;
		this.sumGold = sumGold;
		this.sumMark = sumMark;
	}

	@Override
	public String toString() {
		return "FriendsInvite [inviteCount=" + inviteCount + ", sumGold=" + sumGold + ", sumMark=" + sumMark + "]";
	}
	
	
}

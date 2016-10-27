package com.qiton.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qiton.exception.BussinessException;
import com.qiton.mapper.GoldRecordMapper;
import com.qiton.mapper.MarkRecodeMapper;

import com.qiton.mapper.UserMapper;
import com.qiton.model.GoldRecord;
import com.qiton.model.MarkRecode;
import com.qiton.model.User;
import com.qiton.service.IUserService;
import com.qiton.utils.StringUtils;
import com.baomidou.framework.service.impl.SuperServiceImpl;

/**
 *
 * User 表数据服务层接口实现类
 *
 */
@Service
public class UserServiceImpl extends SuperServiceImpl<UserMapper, User> implements IUserService {

	@Resource
	private UserMapper userMapper;

	@Resource
	private GoldRecordMapper goldRecordMapper;
	
	@Resource
	private MarkRecodeMapper markRecordMapper;
	

	/*
	 * Description: 注册用户
	 * 
	 * @see com.qiton.service.IUserService#regist(com.qiton.model.User)
	 */
	@Override
	public void regist(User user, String rightValidateCode) throws BussinessException {
		if (user == null || StringUtils.isBlank(user.getUserName()) || StringUtils.isBlank(user.getPassword())
				|| StringUtils.isBlank(user.getValidateCode()) || user.getUserName().length() < 6
				|| user.getUserName().length() > 20 || user.getPassword().length() < 6
				|| user.getPassword().length() > 20 || StringUtils.isBlank(user.getPhone()) || user.getPhone().length() != 11) {
			throw new BussinessException("参数错误");
		}

		User userQuery = new User();
		userQuery.setUserName(user.getUserName());
		if (this.userMapper.selectOne(userQuery) != null) {
			throw new BussinessException("用户名已存在");
		}

		if (!user.getValidateCode().equals(rightValidateCode)) {
			throw new BussinessException("验证码错误，请重试");
		}

		user.setRegisterTime(new Date());
		this.userMapper.insert(user);
	}

	/**
	 * 用户登录验证
	 */
	@Override
	public User userlogin(User user) throws BussinessException {
		if (user == null || StringUtils.isBlank(user.getUserName()) || StringUtils.isBlank(user.getPassword())
				|| user.getUserName().length() < 6 || user.getUserName().length() > 20
				|| user.getPassword().length() < 6 || user.getPassword().length() > 20) {
			throw new BussinessException("参数错误");
		}

		User user2 = new User();
		user2.setUserName(user2.getUserName());
		User selectUser = userMapper.selectOne(user2);
		if (selectUser == null || !user.getPassword().trim().equals(selectUser.getPassword())) {
			throw new BussinessException("用户名或密码不正确");
		}
		return selectUser;
	}

	
	
	
	/**
	 * 根据id获得用户
	 * 尤
	 */
	@Override
	public User getCurrentUser(String id) throws BussinessException {
		if (id == null || StringUtils.isBlank(id)) {
			throw new BussinessException("参数错误");
		}
		User user = userMapper.selectById(Long.parseLong(id));
		if (user == null) {
			throw new BussinessException("用户不存在");
		}
		return user;
	}

	
	/**
	 * 资金操作
	 * 尤
	 */
	@Override
	public void updateUserCaptical(User user, String operId, String capiId, String money,
			String remark) throws BussinessException {
		if (user.getMark() == null || user.getGold() == null || operId == null || capiId == null || money == null
				|| remark == null || user.getUserId() == null || user.getUserName() == null || StringUtils.isBlank(user.getMark().toString())
				|| StringUtils.isBlank(user.getUserId().toString()) || StringUtils.isBlank(operId) || StringUtils.isBlank(capiId)
				|| StringUtils.isBlank(money) || StringUtils.isBlank(user.getUserId().toString())
				|| StringUtils.isBlank(user.getUserName().toString())) {
			throw new BussinessException("参数错误");
		}
		int result;
		User whereEntity = new User();
		whereEntity.setUserId(user.getUserId());

		// 扣款
		if (Long.parseLong(operId) == 1) { 
			//User entity = new User();// 用户
			// 金币
			if (Long.parseLong(capiId) == 0){
				if ((user.getGold() - Integer.parseInt(money)) < 0) {
					throw new BussinessException("账户金币不足");
				} else {
					// 扣除用户钱
					user.setGold(user.getGold() - Integer.parseInt(money));
					result=userMapper.update(user, whereEntity);
					if(result!=1){
						throw new BussinessException("扣除用户金币出错");
					}
					// 存入金币记录表
					GoldRecord goldRecord = new GoldRecord(user.getUserId(), user.getUserName(), 2, new Date(),
							(user.getGold() - Float.parseFloat(money)), remark);// 金币记录
					goldRecord.setGrdPay(Float.parseFloat(money));
					 result=goldRecordMapper.insert(goldRecord);
					 if(result!=1){
						 throw new BussinessException("存入金币记录表出错");
					 }
				}
			}
				
			// 积分
			if (Long.parseLong(capiId) == 1){
				if ((user.getMark() - Long.parseLong(money)) < 0) {
					throw new BussinessException("账户积分不足");
				} else {
					// 扣除用户积分
					user.setMark(user.getMark() - Integer.parseInt(money));
					result=userMapper.update(user, whereEntity);
					if(result!=1){
						throw new BussinessException("扣除用户积分失败");
					}
					// 存入积分记录表
					MarkRecode markRecode  = new MarkRecode(user.getUserId(), user.getUserName(), 2, new Date(),
							(user.getMark() - Float.parseFloat(money)), remark);// 金币记录
					markRecode.setMrdPay(Float.parseFloat(money));
					result=markRecordMapper.insert(markRecode);
					if(result!=1){
						throw new BussinessException("存入积分记录表出错");
					}
				}
			}
		}
		//充值
		else{
			//User entity = new User();// 用户
			// 金币
			if (Long.parseLong(capiId) == 0){
					// 充值用户钱
				user.setGold(user.getGold()+ Integer.parseInt(money));
					 result=userMapper.update(user, whereEntity);
					 if(result!=1){
						 throw new BussinessException("充值用户金币出错");
					 }
					// 存入金币记录表
					GoldRecord goldRecord = new GoldRecord(user.getUserId(), user.getUserName(), 2, new Date(),
							(user.getGold() + Float.parseFloat(money)), remark);// 金币记录
					goldRecord.setGrdIncome(Float.parseFloat(money));
					result=goldRecordMapper.insert(goldRecord);
					if(result!=1){
						 throw new BussinessException(" 存入金币记录出错");
					 }
			}
				
			// 积分
			if (Long.parseLong(capiId) == 1){
					// 充值用户积分
				user.setMark(user.getMark() + Integer.parseInt(money));
					result=userMapper.update(user, whereEntity);
					if(result!=1){
						 throw new BussinessException("充值用户积分出错");
					 }
					// 存入积分记录表
					MarkRecode markRecode  = new MarkRecode(user.getUserId(), user.getUserName(), 2, new Date(),
							(user.getMark() + Float.parseFloat(money)), remark);// 金币记录
					markRecode.setMrdIncome(Float.parseFloat(money));
					result=markRecordMapper.insert(markRecode);
					if(result!=1){
						 throw new BussinessException("存入积分记录出错");
					 }
			}
		}
	}

	
	/**
	 * 会员延期
	 * 尤
	 */
	@Override
	public void updateVIP_Del(User user,String delay_time) throws BussinessException{
		// TODO Auto-generated method stub
		if(user.getUserId()==null||delay_time==null||StringUtils.isBlank(user.getUserId().toString())||StringUtils.isBlank(delay_time)){
			throw new BussinessException("参数出错");
		}
		User whereEntity=new User();
		whereEntity.setUserId(user.getUserId());
		User user2=new User();
		int delayday=Integer.parseInt(delay_time);
	     Date date = user.getEndVipTime();
		Date endVipTime=new DateTime(date).plusDays(delayday).toDate();
		user.setEndVipTime(endVipTime);
		int result=userMapper.update(user, whereEntity);
		if(result!=1){
			throw new BussinessException("会员延期失败");
		}
	}

	/**
	 * 修改用户信息
	 * 尤
	 */
	@Override
	public void updateUser_Info(User user)
			throws BussinessException {
		// TODO Auto-generated method stub
		if(user.getUserId()==null||user.getPhone()==null||user.getGrade()==null||user.getVipStatus()==null
				||StringUtils.isBlank(""+user.getUserId())||StringUtils.isBlank(user.getPhone())||StringUtils.isBlank(""+user.getGrade())||StringUtils.isBlank(""+user.getVipStatus())
				||user.getPhone().length()!=11){
			throw new BussinessException("参数错误");
		}
		User whereEntity=new User();
		whereEntity.setUserId(user.getUserId());
		User user2=new User();
		user.setPhone(user.getPhone());user.setGrade(user.getGrade());user.setVipStatus(user.getVipStatus());
		int result= userMapper.update(user, whereEntity);
		if(result!=1){
			throw new BussinessException("修改用户信息失败");
		}
	}
	
	
	

}
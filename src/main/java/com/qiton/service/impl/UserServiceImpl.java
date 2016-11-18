package com.qiton.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qiton.exception.BussinessException;
import com.qiton.mapper.GoldRecordMapper;
import com.qiton.mapper.InviteMapper;
import com.qiton.mapper.MarkRecodeMapper;

import com.qiton.mapper.UserMapper;
import com.qiton.model.Admin;
import com.qiton.model.GoldRecord;
import com.qiton.model.Invite;
import com.qiton.model.MarkRecode;
import com.qiton.model.SelectOptionTime;
import com.qiton.model.User;
import com.qiton.model.VipManage;
import com.qiton.service.IUserService;
import com.qiton.utils.StringUtils;
import com.baomidou.framework.service.impl.SuperServiceImpl;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;

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
	
	@Resource
	private InviteMapper InviteMapper;
	
	
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
		user.setGrade(0);
		user.setGold(0);
		user.setMark(100);
		user.setRegisterTime(new Date());
		user.setEndVipTime(new Date());
		user.setVipStatus(0);
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
		user2.setUserName(user.getUserName());
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
		
		if (user==null|| operId == null || capiId == null || money == null
				|| remark == null || StringUtils.isBlank(user.getUserId().toString()) || StringUtils.isBlank(operId) || StringUtils.isBlank(capiId)
				|| StringUtils.isBlank(money)) {
			throw new BussinessException("参数错误");
		}
		
		user=userMapper.selectById(user.getUserId());
		if(user==null){
			throw new BussinessException("查询用户不存在");
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
							(user.getGold() - Double.parseDouble(money)), remark);// 金币记录
					goldRecord.setGrdPay(Double.parseDouble(money));
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
							(user.getMark() - Double.parseDouble(money)), remark);// 金币记录
					markRecode.setMrdPay(Double.parseDouble(money));
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
							(user.getGold() + Double.parseDouble(money)), remark);// 金币记录
					goldRecord.setGrdIncome(Double.parseDouble(money));
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
							(user.getMark() + Double.parseDouble(money)), remark);// 金币记录
					markRecode.setMrdIncome(Double.parseDouble(money));
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
		
		User selectuser=userMapper.selectById(user.getUserId());
		
		
		User whereEntity=new User();
		whereEntity.setUserId(user.getUserId());
		
		int delayday=Integer.parseInt(delay_time);
	     Date date = selectuser.getEndVipTime();
		Date endVipTime=new DateTime(date).plusDays(delayday).toDate();
		selectuser.setEndVipTime(endVipTime);
		int result=userMapper.update(selectuser, whereEntity);
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
		User selectuser=userMapper.selectById(user.getUserId());
		selectuser.setPhone(user.getPhone());
		selectuser.setGrade(user.getGrade());
		selectuser.setVipStatus(user.getVipStatus());
		//修改邀请表信息
		Invite entity=new Invite();entity.setInviAcceptuser(selectuser.getUserName());
		Invite invite=InviteMapper.selectOne(entity);
		invite.setInviAcceptmobile(user.getPhone());
		InviteMapper.update(invite, entity);
		
		User whereEntity=new User();
		whereEntity.setUserId(user.getUserId());
		User user2=new User();
		int result= userMapper.update(selectuser, whereEntity);
		if(result!=1){
			throw new BussinessException("修改用户信息失败");
		}
	}

	
	
	/**
	 * 条件查询
	 */
	@Override
	public void selectByCommand(VipManage vipManage,Page<VipManage> page) throws BussinessException {
		// TODO Auto-generated method stub
		if(vipManage==null){
			throw new BussinessException("参数错误");
		}
		if(vipManage.getInviAcceptmobile()=="") vipManage.setInviAcceptmobile(null);
		if(vipManage.getInviAcceptuserid()==0) vipManage.setInviAcceptuserid(null);
		if(vipManage.getInviAcceptuser()=="") vipManage.setInviAcceptuser(null);
		List<VipManage> users = userMapper.selectUserListByTime(page, vipManage);
		
		if(users==null){
			throw new BussinessException("查询用户不存在");
		}
		page.setRecords(users);
		
	}

	/**
	 * 
	 * 根据时间获取用户列表
	 */
	@Override
	public void getSelectTime(Page<VipManage> page, SelectOptionTime optionTime) throws BussinessException {
		// TODO Auto-generated method stub
		List<VipManage> users = userMapper.getSelectTime(page, optionTime);
		page.setRecords(users);
	}

	/**
	 * 
	 * @Title: getUserList 
	 * @Description: 获取用户列表
	 * @author 尤
	 * @date 2016年11月7日 上午11:23:22  
	 * @param @param page
	 * @param @throws BussinessException    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	@Override
	public void getUserList(Page<User> page) throws BussinessException {
		// TODO Auto-generated method stub
		List<User> admins = userMapper.selectPage(page, null);
		page.setRecords(admins);
	}

	/**
	 * 
	* @Title: getSelectUserSatate 
	* @Description: 根据用户状态获取用户列表
	* @author 尤
	* @date 2016年11月9日 上午10:06:17  
	* @param @param page
	* @param @param userState
	* @param @throws BussinessException    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@Override
	public void getSelectUserSatate(Page<VipManage> page, String userState) throws BussinessException {
		// TODO Auto-generated method stub
		List<VipManage> users = userMapper.getSelectUserSatate(page, userState);
		page.setRecords(users);
	}
	
	
	/**
	 * 
	* @Title: selectUserPage 
	* @Description: TODO
	* @author 尤
	* @date 2016年11月10日 上午9:27:55  
	* @param @param page
	* @param @return    设定文件 
	* @return Page<VipManage>    返回类型 
	* @throws
	 */
	public void selectUserPage(Page<VipManage> page) {
		List<VipManage> users =userMapper.selectUserList(page);
		Invite entity=new Invite();
		int count=InviteMapper.selectCount(entity);
		page.setTotal(count);
		page.setRecords(users);//page
	}

	@Override
	public void selectVipList(Page<User> page) throws BussinessException {
		// TODO Auto-generated method stub
		List<User> users = userMapper.selectPage(page, null);
		page.setRecords(users);
	}

	/**
	 * 根据条件获取会员用户
	 */
	@Override
	public void selectByCommandUser(User user, Page<User> page) throws BussinessException {
		// TODO Auto-generated method stub
		if(user==null){
			throw new BussinessException("参数错误");
		}
		
		List<User> users = userMapper.selectByCommandUser(page, user);
			System.out.println("---------"+users.get(0).toString());
		if(users==null){
			throw new BussinessException("查询用户不存在");
		}
		page.setRecords(users);
	}

	/**
	 * 根据账户类型获取会员用户
	 */
	@Override
	public void getSelectUserByType(Page<User> page, String accountType) throws BussinessException {
		// TODO Auto-generated method stub
		List<User> users = userMapper.getSelectUserByType(page, accountType);
		page.setRecords(users);
	}
	
	/**
	 * 
	 * 根据时间获取会员用户列表
	 */
	@Override
	public void getSelectVIPUserByTime(Page<User> page, SelectOptionTime optionTime) throws BussinessException {
		// TODO Auto-generated method stub
		List<User> users = userMapper.getSelectVIPUserByTime(page, optionTime);
		page.setRecords(users);
	}
	
	/**
	 * 修改会员信息
	 */
	@Override
	public void updateVIPUser_Info(User user) throws BussinessException {
		// TODO Auto-generated method stub
		if(user.getUserId()==null||user.getAccountType()==null||user.getReflectAccount()==null
				||StringUtils.isBlank(""+user.getUserId())||StringUtils.isBlank(user.getAccountType().toString())||StringUtils.isBlank(""+user.getReflectAccount())
				){
			throw new BussinessException("参数错误");
		}
		User selectuser=userMapper.selectById(user.getUserId());
		selectuser.setAccountType(user.getAccountType());
		selectuser.setReflectAccount(user.getReflectAccount());
		
		User whereEntity=new User();
		whereEntity.setUserId(user.getUserId());
		int result= userMapper.update(selectuser, whereEntity);
		if(result!=1){
			throw new BussinessException("修改体现账户信息失败");
		}
	}

	/**
	 * 绑定提现
	 */
	@Override
	public void Bind_withdrawal(String userId, String accountType, String reflectAccount, String realName) {
		// TODO Auto-generated method stub
		if(StringUtils.isBlank(userId)||StringUtils.isBlank(accountType)
				||StringUtils.isBlank(reflectAccount)||StringUtils.isBlank(realName)
				){
			throw new BussinessException("参数错误");
		}
		
		User user=userMapper.selectById(userId);
		if(user==null){
			throw new BussinessException("用户不存在");
		}
		user.setAccountType(Integer.parseInt(accountType)); //账户类型
		user.setReflectAccount(reflectAccount);
		user.setRealName(realName);
		User whereEntity=new User();whereEntity.setUserId(Long.parseLong(userId));
		int result=userMapper.update(user, whereEntity);
		if(result!=1){
			throw new BussinessException("绑定失败");
		}
	}
	
	/**
	 * 
	* @Title: VIP_renew 
	* @Description: 会员续费
	* @author 尤
	* @date 2016年11月18日 下午4:20:36  
	* @param @param gold
	* @param @param mark
	* @param @throws BussinessException    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@Override
	public void VIP_renew(String userId,String gold, String mark) throws BussinessException {
		// TODO Auto-generated method stub
		if(StringUtils.isBlank(gold)||StringUtils.isBlank(mark)){
			throw new BussinessException("参数出错");
		}
		
		User user=userMapper.selectById(userId);
		user.setGold(Integer.parseInt(gold)+user.getGold());
		user.setMark(Integer.parseInt(mark)+user.getMark());
		User whereEntity=new User();whereEntity.setUserId(Long.parseLong(userId));
		int result=userMapper.update(user, whereEntity);
		if(result!=1){
			throw new BussinessException("充值失败");
		}
	}
}
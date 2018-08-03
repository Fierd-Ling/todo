package com.hand.service.impl;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hand.mapper.UserMapper;
import com.hand.pojo.UserDTO;
import com.hand.pojo.UserVO;
import com.hand.service.UserService;
import com.hand.util.Constants;
import com.hand.util.MD5Utils;
import com.hand.util.NowTime;
import com.hand.util.Session;

/**
 * 
 * UserService实现类
 * 
 * @author zhongLingYun
 * 
 **/
@Repository
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public UserDTO findUserMassgeByUserId(Integer userId) {
		if (userId == null) {
			return null;
		}
		UserDTO userDTO = userMapper.findUserMassageByUserid(userId);
		userDTO.setLastUpdateDateString(NowTime.dateToString(userDTO.getLastUpdateDate()));
		userDTO.setCreationDateString(NowTime.dateToString(userDTO.getCreationDate()));
		String sex = userDTO.getSex();
		if ("m".equals(sex)) {
			userDTO.setSex("男");
		}
		if ("w".equals(sex)) {
			userDTO.setSex("女");
		}
		return userDTO;
	}
	
	@Override
	public int updateUserMassage(UserVO userVO,HttpServletRequest request) {
		if (userVO == null) {
			return 0;
		}
		userVO.setUserId(Session.getUserId(request));
		userVO.setLastUpdateDate(NowTime.getNowTime());
		Integer result = userMapper.updateUserMassage(userVO);
		if (result == 0) {
			return Constants.FAILURE;
		}
		return Constants.SUCCESS;
	}

	@Override
	public Integer countByUserNameAndPassword(String userName, String password) {
		if (userName == null || "".equals(userMapper)) {
			return 0;
		}
		if (password == null || "".equals(password)) {
			return 0;
		}
		password=MD5Utils.md5(password);
		return userMapper.countByUserNameAndPassword(userName, password);
	}

	@Override
	public UserDTO findUserDTOByUserNameAndPassword(String userName, String password) {
		if (userName == null || "".equals(userMapper)) {
			return null;
		}
		if (password == null || "".equals(password)) {
			return null;
		}
		password=MD5Utils.md5(password);
		return userMapper.findUserDTOByUserNameAndPassword(userName, password);
	}
}

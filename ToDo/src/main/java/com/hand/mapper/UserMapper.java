package com.hand.mapper;

import org.springframework.stereotype.Repository;

import com.hand.pojo.UserDTO;
import com.hand.pojo.UserVO;

/**
 * 
 * CUX_USERS表操作接口
 * 
 * @author zhongLingYun
 * 
 */
@Repository
public interface UserMapper {

	/**
	 * 
	 * 根据用户userId查找对用户的信息不包括时间
	 * 
	 * @param userId
	 * 
	 * @return UserDTO
	 */
	UserDTO findUserMassageByUserid(Integer userId);

	/**
	 * 
	 * 更新用户信息
	 * 
	 * @param userVO
	 * 
	 */
	Integer updateUserMassage(UserVO userVO);

	/**
	 * 
	 * 查找与与账号和密码相同的记录
	 * 
	 * @return Integer 记录数
	 * 
	 * @param 用户名和密码
	 * 
	 */
	Integer countByUserNameAndPassword(String userName, String password);

	/***
	 * 
	 * 查找同一個用戶名在數據庫中出現的次數
	 * 
	 * @return Integer
	 * 
	 * @param String
	 * 
	 */
	Integer countByUserName(String userName);

	/**
	 * 
	 * 通过查找与账号和密码匹配的用户对象（只有一条）
	 * 
	 * @return UserDTO
	 * 
	 * @param 用户名和密码
	 *            userName Passsword
	 * 
	 */
	UserDTO findUserDTOByUserNameAndPassword(String userName, String password);

}

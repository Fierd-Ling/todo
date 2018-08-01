package com.hand.service;



import javax.servlet.http.HttpServletRequest;

import com.hand.pojo.UserDTO;
import com.hand.pojo.UserVO;

/**
 * 
 * user表service层接口
 * 
 * @author zhongLingYun
 * 
 */
public interface UserService {

	/**
	 * 
	 * 通过userId查找对应的用户信息
	 * 
	 * @param userId
	 * 
	 * @return UserDTO
	 * 
	 */
	UserDTO findUserMassgeByUserId(Integer userId);

	/**
	 * 
	 * 更新用户信息
	 * 
	 * 返回200更新成功，500更新失败
	 * 
	 * @param userVO
	 * 
	 * @return int
	 * 
	 */
	int updateUserMassage(UserVO userVO,HttpServletRequest request);

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

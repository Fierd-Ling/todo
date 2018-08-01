package com.hand.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.hand.pojo.UserDTO;

/**
 * 
 * 登录管理session控制
 * 
 * @author zhongLingYun
 * 
 */
public abstract class Session {

	/**
	 * 
	 * 登录成功后生成一个session有效时间是5分钟每次跟新session
	 *
	 * @param session
	 *            userId
	 * 
	 **/
	public static void userDtoSession(HttpServletRequest request, UserDTO userDTO) {
		HttpSession session = request.getSession();
		session.setAttribute("userDTO", userDTO);
		session.setMaxInactiveInterval(5 * 60);
	}

	/**
	 * 
	 * 用于判断当前用户的session是否还在会话时间内
	 * 
	 * return boolean
	 * 
	 */
	public static boolean isLive(HttpServletRequest request) {
		HttpSession session = request.getSession();
		UserDTO userDTO = null;
		userDTO = (UserDTO) session.getAttribute("userDTO");
		if (userDTO == null) {
			return false;
		}
		return true;
	}

	/***
	 * 
	 * 获取用户的UserDTO
	 *
	 * @return UserDTO
	 *
	 * @param HttpServletRequest
	 * 
	 **/
	public static UserDTO getUserDTO(HttpServletRequest request) {
		HttpSession session = request.getSession();
		UserDTO userDTO = null;
		userDTO = (UserDTO) session.getAttribute("userDTO");
		return userDTO;
	}

	/****
	 * 
	 * 从session里面拿到userid
	 * 
	 * @param session
	 * 
	 * @return userid
	 * 
	 * 
	 */
	public static Integer getUserId(HttpServletRequest request) {
		HttpSession session = request.getSession();
		UserDTO userDTO = null;
		userDTO = (UserDTO) session.getAttribute("userDTO");
		if (userDTO == null) {
			return null;
		}
		return userDTO.getUserId();
	}
}

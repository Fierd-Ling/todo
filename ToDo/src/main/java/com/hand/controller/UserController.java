package com.hand.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hand.pojo.ItemsDTO;
import com.hand.pojo.UserDTO;
import com.hand.pojo.UserVO;
import com.hand.service.ItemsService;
import com.hand.service.UserService;
import com.hand.util.Constants;
import com.hand.util.Session;

/**
 * 
 * CUX_USERS表操作控制
 * 
 * @author zhongLingYun
 * 
 */
@Controller
@RequestMapping(value = "/userController")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private ItemsService itemsService;

	/**
	 * 
	 * 通过用户id查找用户信息
	 *
	 * @param userId
	 * 
	 **/
	@RequestMapping(value = "/findUserMassgeByUserId", method = RequestMethod.GET)
	public ModelAndView findUserMassgeByUserId(HttpServletRequest request) {
		UserDTO userDTO = userService.findUserMassgeByUserId(Session.getUserId(request));
		ModelAndView modelAndView = new ModelAndView("/UserMassage");
		modelAndView.addObject("userDTO", userDTO);
		return modelAndView;
	}

	/**
	 * 
	 * 更新用户信息
	 * 
	 * @param userVO
	 * 
	 **/
	// TODO 异步加载
	@RequestMapping(value = "/updateUserMassage")
	public @ResponseBody int updateUserMassage(UserVO userVO, HttpServletRequest request) {
		int result = userService.updateUserMassage(userVO, request);
		if (result == 200) {
			// 更新session 数据
			UserDTO userDTO = userService.findUserMassgeByUserId(Session.getUserId(request));
			Session.userDtoSession(request, userDTO);
		}
		return result;
	}

	/**
	 * 
	 * 登录成功后调用去到数据你展示页面 初始只展示最开始的0-10的数据
	 * 
	 **/
	@RequestMapping(value = "/goToListItemsPage", method = RequestMethod.GET)
	public ModelAndView goToListItemsPage(Integer userId, HttpServletRequest request) {
		userId = Session.getUserId(request);
		List<ItemsDTO> listItems = itemsService.listItemsByUserId(userId, Constants.STAR, Constants.END);
		ModelAndView modelAndView = new ModelAndView("/ListItemsPage");
		modelAndView.addObject("listItems", listItems);
		modelAndView.addObject("count", itemsService.countItemsByUserId(userId));
		// 获取session中的对象
		modelAndView.addObject("userDTO", Session.getUserDTO(request));
		return modelAndView;
	}

	/***
	 * 
	 * 登录验证
	 * 
	 * @return String
	 * 
	 *         异步
	 * 
	 */
	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public @ResponseBody String index(String userName, String password, HttpServletRequest request) {
		if (userName == null || "".equals(userName)) {
			return Constants.LONG_FAILED;
		}
		if (password == null || "".equals(password)) {
			return Constants.LONG_FAILED;
		}
		Integer integer = userService.countByUserNameAndPassword(userName, password);
		if (integer == 1) {
			UserDTO userDTO = userService.findUserDTOByUserNameAndPassword(userName, password);
			Session.userDtoSession(request, userDTO);
			return Constants.LONG_SUCCESS;
		}
		return Constants.LONG_FAILED;
	}
}

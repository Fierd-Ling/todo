package com.hand.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hand.pojo.ItemsVO;
import com.hand.service.ItemsService;
import com.hand.util.Constants;
import com.hand.util.Session;

/**
 * 
 * Items表操作控制
 * 
 * @author zhongLingYun
 * 
 */
@Controller
@RequestMapping(value = "/ItemsController")
public class ItemsController {

	@Autowired
	private ItemsService itemsService;

	/**
	 * 
	 * 新增待办事项
	 *
	 * @param ItemsVO
	 *
	 * @return Integer
	 * 
	 */
	@RequestMapping(value = "/addItem", method = RequestMethod.POST)
	public @ResponseBody String addItem(ItemsVO itemsVO, HttpServletRequest request) {
		// TODO 返回的状态码处理 對象數據校驗防止關鍵子字段爲空
		itemsVO.setUserId(Session.getUserId(request));
		itemsService.addItem(itemsVO);
		return Constants.LONG_SUCCESS;
	}

	/**
	 * 删除数据
	 * 
	 */
	@RequestMapping(value = "/deleteItem", method = RequestMethod.POST)
	public @ResponseBody String deleteItem(Integer toDoItemId) {
		if (toDoItemId == null) {
			return "";
		}
		itemsService.deleteItemById(toDoItemId);
		return "";
	}

}

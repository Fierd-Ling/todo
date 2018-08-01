package com.hand.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hand.pojo.ItemsDTO;
import com.hand.pojo.ItemsVO;

/**
 * 
 * CUX_TODO_ITEMS数据库表service接口
 * 
 * @author zhongLingYun
 * 
 */
@Service
public interface ItemsService {

	/**
	 * 新增待办事件
	 * 
	 * @param ItemVO
	 * 
	 * @return Integer 返回值用于判断是否插入成功 等于200就代表是成功
	 * 
	 */
	Integer addItem(ItemsVO itemsVO);

	/**
	 * 
	 * 查找当前用户所有的待办事项<分页查询>
	 * 
	 * @return List<ItemDTO>
	 * 
	 * @param userId
	 *            begin 起始条数 end 结束条数
	 * 
	 **/
	List<ItemsDTO> listItemsByUserId(Integer userId, Integer begin, Integer end);

	/**
	 * 查抄对应账号下的所有的待办事项的总数
	 * 
	 * @return Integer
	 * 
	 * @param userId
	 * 
	 */
	Integer countItemsByUserId(Integer userId);

	/**
	 * 
	 * 通过id删除一条待办事项
	 * 
	 * @return Integer 1表示删除成功
	 * 
	 * @param itemsId
	 */
	Integer deleteItemById(Integer itemsId);

}

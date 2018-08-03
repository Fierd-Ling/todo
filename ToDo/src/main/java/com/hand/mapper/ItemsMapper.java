package com.hand.mapper;

import java.util.List;

import com.hand.pojo.ItemsDTO;
import com.hand.pojo.ItemsVO;

/**
 * 
 * CUX_TODO_ITEMS数据库表操作接口
 * 
 * @author zhongLingYun
 * 
 */
public interface ItemsMapper {

	/**
	 * 新增待办事件
	 * 
	 * @param ItemVO
	 * 
	 * @return Integer 返回值用于判断是否插入成功 等于0就代表是没有插入成功
	 * 
	 */
	Integer addItem(ItemsVO itemVO);

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
	 * 通过id差看对应的待办事项
	 * 
	 * @return ItemsDTO
	 * 
	 * @param ItemID
	 * 
	 */
	ItemsDTO selectItemById(Integer itemId);

	/**
	 * 
	 * 更新一条待办事项
	 * 
	 * @return Integer 返回为1表示更新成功
	 * 
	 * @param itemsDTO
	 * 
	 */
	Integer updateItem(ItemsDTO itemsDTO);

	/**
	 * 
	 * 通过id删除一条待办事项
	 * 
	 * @return Integer 1表示删除成功
	 * 
	 * @param itemsId
	 */
	void deleteItemById(Integer itemsId);

}

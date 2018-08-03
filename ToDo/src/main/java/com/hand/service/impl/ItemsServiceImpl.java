package com.hand.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hand.mapper.ItemsMapper;
import com.hand.pojo.ItemsDTO;
import com.hand.pojo.ItemsVO;
import com.hand.service.ItemsService;
import com.hand.util.Constants;
import com.hand.util.NowTime;

/***
 * 
 * ItemService实现类
 * 
 * @author zhongLingYun
 * 
 **/
@Repository
public class ItemsServiceImpl implements ItemsService {

	@Autowired
	private ItemsMapper itemsMapper;

	@Override
	public Integer addItem(ItemsVO itemsVO) {
		if (itemsVO == null) {
			throw new RuntimeException("ItemsServiceImpl中addItem传入的参数为null");
		}
		Date date = NowTime.getNowTime();
		itemsVO.setLastUpdateDate(date);
		itemsVO.setCreationDate(date);
		Integer result = itemsMapper.addItem(itemsVO);
		if (result == 1) {
			return Constants.SUCCESS;
		}
		return Constants.FAILURE;
	}

	@Override
	public List<ItemsDTO> listItemsByUserId(Integer userId, Integer begin, Integer end) {
		if (userId == null || begin == null || end == null) {
			return null;
		}
		List<ItemsDTO> lisItems = itemsMapper.listItemsByUserId(userId, begin, end);
		for (int i = 0; i < lisItems.size(); i++) {
			lisItems.get(i).setLastUpdateDateString(NowTime.dateToString(lisItems.get(i).getLastUpdateDate()));
			lisItems.get(i).setCreationDateString((NowTime.dateToString(lisItems.get(i).getCreationDate())));
		}
		return lisItems;
	}

	@Override
	public Integer countItemsByUserId(Integer userId) {
		if (userId == null) {
			return null;
		}
		return itemsMapper.countItemsByUserId(userId);
	}

	@Override
	public Integer deleteItemById(Integer itemsId) {
		if (itemsId == null) {
			return null;

		}
		itemsMapper.deleteItemById(itemsId);
		return 1;
	}

}

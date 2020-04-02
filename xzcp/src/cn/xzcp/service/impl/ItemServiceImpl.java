package cn.xzcp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.xzcp.bean.ItemMes;
import cn.xzcp.mapper.ItemMapper;
import cn.xzcp.service.ItemService;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemMapper itemMapper;

	/**
	 * 通过考评项id查询，得到itemMes对象
	 */
	@Override
	public ItemMes getItem(int itemId) {
		// TODO Auto-generated method stub
		ItemMes item = itemMapper.getItem(itemId);
		return item;
	}

	/**
	 * 获得分页考评项的信息
	 */
	@Override
	public List<ItemMes> getPageItem(ItemMes itemMes) {
		List<ItemMes> list;
		list = itemMapper.getPageItem(itemMes);
		return list;
	}

	/**
	 * 获得所有考评项的信息
	 */
	@Override
	public List<ItemMes> getAllItem() {
		List<ItemMes> list;
		list = itemMapper.getAllItem();
		return list;
	}

	/**
	 * 获得某个班委管理的所有考评项的信息
	 */
	@Override
	public List<ItemMes> getCommitteeAllItem(int identityId) {
		List<ItemMes> list;
		list = itemMapper.getCommitteeAllItem(identityId);
		return list;
	}

	/**
	 * 批量删除考评项
	 */
	@Override
	public boolean deleteItem(String[] idsArray) {
		for (int i = 0; i < idsArray.length; i++) {
			int itemId = Integer.valueOf(idsArray[i]);
			try {
				itemMapper.deleteItem(itemId);
			} catch (Exception e) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 添加考评项
	 */
	@Override
	public boolean addItem(ItemMes itemMes) {
		try {
			itemMapper.addItem(itemMes);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 修改考评项信息
	 */
	@Override
	public boolean changeItem(ItemMes itemMes) {
		try {
			itemMapper.changeItem(itemMes);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}

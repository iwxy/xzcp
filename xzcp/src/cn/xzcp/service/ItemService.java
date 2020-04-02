package cn.xzcp.service;

import java.util.List;

import cn.xzcp.bean.ItemMes;

public interface ItemService {

	/**
	 * 通过考评项id查询，得到itemMes对象
	 */
	ItemMes getItem(int itemId);

	/**
	 * 获得分页考评项的信息
	 */
	List<ItemMes> getPageItem(ItemMes itemMes);

	/**
	 * 获得所有考评项的信息
	 */
	List<ItemMes> getAllItem();

	/**
	 * 获得某个班委管理的所有考评项的信息
	 */
	List<ItemMes> getCommitteeAllItem(int identityId);

	/**
	 * 批量删除考评项，也可单个
	 */
	boolean deleteItem(String[] idsArray);

	/**
	 * 添加考评项
	 */
	boolean addItem(ItemMes itemMes);

	/**
	 * 修改考评项信息
	 */
	public boolean changeItem(ItemMes itemMes);

}

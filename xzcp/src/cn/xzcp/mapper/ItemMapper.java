package cn.xzcp.mapper;

import java.util.List;

import cn.xzcp.bean.ItemMes;

public interface ItemMapper {

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
	 * 删除考评项
	 */
	void deleteItem(int itemId);

	/**
	 * 添加考评项
	 */
	void addItem(ItemMes itemMes);

	/**
	 * 通过考评项id查询，得到classMes对象
	 */
	ItemMes getItem(int itemId);

	/**
	 * 修改考评项信息
	 */
	void changeItem(ItemMes itemMes);

}

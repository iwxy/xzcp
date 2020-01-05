package cn.xzcp.mapper;

import java.util.List;
import java.util.Map;

import cn.xzcp.bean.IdentityMes;

public interface IdentityMapper {

	/**
	 * 获得分页班委的信息
	 */
	List<IdentityMes> getPageIdentity(Map<String, Integer> params);

	/**
	 * 获得所有班委的信息
	 */
	List<IdentityMes> getAllIdentity();

	/**
	 * 删除班委
	 */
	void deleteIdentity(int identityId);

	/**
	 * 添加班委
	 */
	void addIdentity(IdentityMes identityMes);

	/**
	 * 通过身份号查询，得到identityMes对象
	 */
	IdentityMes getIdentity(int identityId);

	/**
	 * 修改班委信息
	 */
	void changeIdentity(IdentityMes identityMes);

}

package cn.xzcp.service;

import java.util.List;

import cn.xzcp.bean.IdentityMes;

public interface IdentityService {

	/**
	 * 通过身份号查询，得到identityMes对象
	 */
	IdentityMes getIdentity(int identityId);

	/**
	 * 获得分页班委的信息
	 */
	List<IdentityMes> getPageIdentity(IdentityMes identityMes);

	/**
	 * 获得所有班委的信息
	 */
	List<IdentityMes> getAllIdentity();

	/**
	 * 获得除教师外所有角色的信息
	 */
	List<IdentityMes> getAllSIdentity();

	/**
	 * 批量删除班委，也可单个
	 */
	boolean deleteIdentity(String[] idsArray);

	/**
	 * 添加班委
	 */
	boolean addIdentity(IdentityMes identityMes);

	/**
	 * 修改班委信息
	 */
	public boolean changeIdentity(IdentityMes identityMes);

}

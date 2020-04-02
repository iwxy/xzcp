package cn.xzcp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.xzcp.bean.IdentityMes;
import cn.xzcp.mapper.IdentityMapper;
import cn.xzcp.service.IdentityService;

@Service
@Transactional
public class IdentityServiceImpl implements IdentityService {

	@Autowired
	private IdentityMapper identityMapper;

	/**
	 * 通过身份号查询，得到identityMes对象
	 */
	@Override
	public IdentityMes getIdentity(int identityId) {
		// TODO Auto-generated method stub
		IdentityMes identity = identityMapper.getIdentity(identityId);
		return identity;
	}

	/**
	 * 获得分页班委的信息
	 */
	@Override
	public List<IdentityMes> getPageIdentity(IdentityMes identityMes) {
		List<IdentityMes> list;
		list = identityMapper.getPageIdentity(identityMes);
		return list;
	}

	/**
	 * 获得所有班委的信息
	 */
	@Override
	public List<IdentityMes> getAllIdentity() {
		List<IdentityMes> list;
		list = identityMapper.getAllIdentity();
		return list;
	}

	/**
	 * 获得除教师外所有角色的信息
	 */
	@Override
	public List<IdentityMes> getAllSIdentity() {
		List<IdentityMes> list;
		list = identityMapper.getAllSIdentity();
		return list;
	}

	/**
	 * 批量删除班委
	 */
	@Override
	public boolean deleteIdentity(String[] idsArray) {
		for (int i = 0; i < idsArray.length; i++) {
			int identityId = Integer.valueOf(idsArray[i]);
			try {
				identityMapper.deleteIdentity(identityId);
			} catch (Exception e) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 添加班委
	 */
	@Override
	public boolean addIdentity(IdentityMes identityMes) {
		try {
			identityMapper.addIdentity(identityMes);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 修改班委信息
	 */
	@Override
	public boolean changeIdentity(IdentityMes identityMes) {
		try {
			identityMapper.changeIdentity(identityMes);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}

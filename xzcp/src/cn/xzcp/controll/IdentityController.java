package cn.xzcp.controll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.xzcp.bean.IdentityMes;
import cn.xzcp.bean.ResponseResult;
import cn.xzcp.service.IdentityService;

@Controller
@RequestMapping("/identity")
public class IdentityController {

	@Autowired
	private IdentityService identityService;

	/**
	 * 通过身份号查询，得到identityMes对象
	 */
	@RequestMapping("/getIdentity")
	@ResponseBody
	public ResponseResult getIdentity(IdentityMes identity) {
		IdentityMes data = identityService.getIdentity(identity.getIdentityId());
		if (data == null) {
			return ResponseResult.build(1, "该班委不存在");
		} else {
			return ResponseResult.build(0, "查询成功", data);
		}
	}

	/**
	 * 获得所有班委信息，分页
	 */
	@RequestMapping("/getAllIdentity")
	@ResponseBody
	public ResponseResult getAllIdentity(IdentityMes identityMes) {
		List<IdentityMes> data;
		data = identityService.getPageIdentity(identityMes);
		// 一共有多少条身份数据
		int count = identityService.getAllIdentity().size();
		if (data.size() == 0) {
			return ResponseResult.build(1, "无数据");
		} else {
			return ResponseResult.build(0, "查询成功", count, data);
		}

	}

	/**
	 * 批量删除班委，也可单个
	 */
	@RequestMapping("/deleteIdentity")
	@ResponseBody
	public ResponseResult deleteIdentity(String idsStr) {
		String idsArray[] = idsStr.split(",");
		boolean b = identityService.deleteIdentity(idsArray);
		if (b) {
			return ResponseResult.build(0, "删除成功！");
		} else {
			return ResponseResult.build(1, "删除失败！");
		}

	}

	/**
	 * 添加班委
	 */
	@RequestMapping("/addIdentity")
	@ResponseBody
	public ResponseResult addIdentity(IdentityMes identityMes) {
		// 这个方法不能通用，因为设定了身份是教师
		boolean b = identityService.addIdentity(identityMes);
		if (b) {
			return ResponseResult.build(0, "添加成功！");
		} else {
			return ResponseResult.build(1, "添加失败！");
		}

	}

	/**
	 * 修改班委信息
	 */
	@RequestMapping("/changeIdentity")
	@ResponseBody
	public ResponseResult changeIdentity(IdentityMes identityMes) {

		boolean b = identityService.changeIdentity(identityMes);
		if (b) {
			return ResponseResult.build(0, "修改成功！");
		} else {
			return ResponseResult.build(1, "修改失败！");
		}

	}

}

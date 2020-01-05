package cn.xzcp.controll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.xzcp.bean.IdentityMes;
import cn.xzcp.bean.ItemMes;
import cn.xzcp.bean.ResponseResult;
import cn.xzcp.service.IdentityService;
import cn.xzcp.service.ItemService;

@Controller
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemService itemService;

	@Autowired
	private IdentityService identityService;

	/**
	 * 通过考评项id查询，得到itemMes对象
	 */
	@RequestMapping("/getItem")
	@ResponseBody
	public ResponseResult getItem(ItemMes item) {
		ItemMes data = itemService.getItem(item.getItemId());
		if (data == null) {
			return ResponseResult.build(1, "该用户不存在");
		} else {
			return ResponseResult.build(0, "查询成功", data);
		}
	}

	/**
	 * 获得所有考评项信息，分页
	 */
	@RequestMapping("/getAllItem")
	@ResponseBody
	public ResponseResult getAllItem(int page, int limit) {
		List<ItemMes> data;
		data = itemService.getPageItem(page, limit);
		// 一共有多少条考评项数据
		int count = itemService.getAllItem().size();
		if (data.size() == 0) {
			return ResponseResult.build(1, "无数据");
		} else {
			return ResponseResult.build(0, "查询成功", count, data);
		}

	}

	/**
	 * 批量删除考评项，也可单个
	 */
	@RequestMapping("/deleteItem")
	@ResponseBody
	public ResponseResult deleteItem(String idsStr) {
		String idsArray[] = idsStr.split(",");
		boolean b = itemService.deleteItem(idsArray);
		if (b) {
			return ResponseResult.build(0, "删除成功！");
		} else {
			return ResponseResult.build(1, "删除失败！");
		}

	}

	/**
	 * 添加考评项
	 */
	@RequestMapping("/addItem")
	@ResponseBody
	public ResponseResult addClass(ItemMes itemMes) {
		// 这个方法不能通用，因为设定了身份是教师
		boolean b = itemService.addItem(itemMes);
		if (b) {
			return ResponseResult.build(0, "添加成功！");
		} else {
			return ResponseResult.build(1, "添加失败！");
		}

	}

	/**
	 * 得到所有班委的信息
	 */
	@RequestMapping("/getAllCommittee")
	@ResponseBody
	public ResponseResult getAllCommittee() {
		List<IdentityMes> data;
		data = identityService.getAllIdentity();
		if (data.size() == 0) {
			return ResponseResult.build(1, "无数据");
		} else {
			return ResponseResult.build(0, "查询成功", data);
		}

	}

	/**
	 * 修改考评项信息
	 */
	@RequestMapping("/changeItem")
	@ResponseBody
	public ResponseResult changeItem(ItemMes itemMes) {
		boolean b = itemService.changeItem(itemMes);
		if (b) {
			return ResponseResult.build(0, "修改成功！");
		} else {
			return ResponseResult.build(1, "修改失败！");
		}

	}

}

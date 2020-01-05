package cn.xzcp.controll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.xzcp.bean.ClassMes;
import cn.xzcp.bean.ResponseResult;
import cn.xzcp.bean.UserMes;
import cn.xzcp.service.ClassService;
import cn.xzcp.service.UserService;

@Controller
@RequestMapping("/class")
public class ClassController {

	@Autowired
	private ClassService classService;

	@Autowired
	private UserService userService;

	/**
	 * 通过班级号查询，得到classMes对象
	 */
	@RequestMapping("/getClass")
	@ResponseBody
	public ResponseResult getClass(ClassMes classes) {
		ClassMes data = classService.getClass(classes.getClassId());
		if (data == null) {
			return ResponseResult.build(1, "该班级不存在");
		} else {
			return ResponseResult.build(0, "查询成功", data);
		}
	}

	/**
	 * 获得所有班级信息，分页
	 */
	@RequestMapping("/getAllClass")
	@ResponseBody
	public ResponseResult getAllClass(int page, int limit) {
		List<ClassMes> data;
		data = classService.getPageClass(page, limit);
		// 一共有多少条班级数据
		int count = classService.getAllClass().size();
		if (data.size() == 0) {
			return ResponseResult.build(1, "无数据");
		} else {
			return ResponseResult.build(0, "查询成功", count, data);
		}

	}

	/**
	 * 批量删除班级，也可单个
	 */
	@RequestMapping("/deleteClass")
	@ResponseBody
	public ResponseResult deleteClass(String idsStr) {
		String idsArray[] = idsStr.split(",");
		boolean b = classService.deleteClass(idsArray);
		if (b) {
			return ResponseResult.build(0, "删除成功！");
		} else {
			return ResponseResult.build(1, "删除失败！");
		}

	}

	/**
	 * 添加班级
	 */
	@RequestMapping("/addClass")
	@ResponseBody
	public ResponseResult addClass(ClassMes classMes) {
		// 这个方法不能通用，因为设定了身份是教师
		boolean b = classService.addClass(classMes);
		if (b) {
			return ResponseResult.build(0, "添加成功！");
		} else {
			return ResponseResult.build(1, "添加失败！");
		}

	}

	/**
	 * 得到所有教师的信息
	 */
	@RequestMapping("/getAllTeacher")
	@ResponseBody
	public ResponseResult getAllTeacher() {
		List<UserMes> data;
		data = userService.getAllTeacher();
		if (data.size() == 0) {
			return ResponseResult.build(1, "无数据");
		} else {
			return ResponseResult.build(0, "查询成功", data);
		}

	}

	/**
	 * 修改班级信息
	 */
	@RequestMapping("/changeClass")
	@ResponseBody
	public ResponseResult changeClass(ClassMes classMes) {

		boolean b = classService.changeClass(classMes);
		if (b) {
			return ResponseResult.build(0, "修改成功！");
		} else {
			return ResponseResult.build(1, "修改失败！");
		}

	}

}

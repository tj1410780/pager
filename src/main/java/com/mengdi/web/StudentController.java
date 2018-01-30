package com.mengdi.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mengdi.dto.Pager;
import com.mengdi.entity.Student;
import com.mengdi.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Resource
	private StudentService studentService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(
			@RequestParam("currentPage") int currentPage,    //显示第几页数据
			@RequestParam("pageSize") int pageSize,         //每页显示多少记录
			Model model) {
		List<Student> list = studentService.getAll(currentPage, pageSize);
		int totalRecord = studentService.getCount();
		Pager<Student> result = new Pager<Student>(currentPage, pageSize, totalRecord, list);
		model.addAttribute("result", result);
		return "search";
	}
	
	@RequestMapping(value = "/search?currentPage={currentPage}", method = RequestMethod.POST)
	public String search(
		@RequestParam("name") String name,
		@RequestParam("gender") String gender,
		@PathVariable("currentPage") int currentPage,    //显示第几页数据
		@RequestParam("pageSize") int pageSize,         //每页显示多少记录
		Model model	) {
		List<Student> list = studentService.getByNameAndGender(name, gender, currentPage, pageSize);
		int totalRecord = studentService.getSearchCount(name, gender);
		Pager<Student> result = new Pager<Student>(currentPage, pageSize, totalRecord, list);
		model.addAttribute("result", result);
		return "search";
	}
	
	
}

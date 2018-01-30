package com.mengdi.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mengdi.entity.Student;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class StudentServiceTest {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource
	private StudentService studentService;
	
	@Test
	public void testGetByNameAndGender() {
		String name = "天";
		String gender = "男";
		int currentPage = 1;
		int pageSize = 5;
		List<Student> list = studentService.getByNameAndGender(name, gender, currentPage, pageSize);
		logger.info("list={}", list);
	}
	
	//list=[Student [id=1, name=张天, age=16, gender=男, address=上海], Student [id=11, name=谢天, age=17, gender=男, address=青岛]]

	@Test
	public void testGetSearchCount() {
		String name = "天";
		String gender = "男";
		int count = studentService.getSearchCount(name, gender);
		logger.info("count={}", count);
	}
	//count=2;
	
	@Test
	public void testGetAll() {
		int currentPage = 2;
		int pageSize = 3;
		List<Student> list = studentService.getAll(currentPage, pageSize);
		logger.info("list={}", list);
	}
	// list=[Student [id=4, name=田倩倩, age=16, gender=女, address=西安], Student [id=5, name=明小军, age=15, gender=男, address=上海], Student [id=6, name=王元, age=17, gender=男, address=南京]]
	@Test
	public void testGetCount() {
		int count = studentService.getCount();
		logger.info("count={}", count);
	}
	
	//count=11

}

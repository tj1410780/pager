package com.mengdi.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mengdi.entity.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class StudentDaoTest {

	@Resource
	private StudentDao studentDao;
	
	@Test
	public void testQueryByNameAndGender() {
		String name = "天";   //实现模糊查询
		String gender = "男";
		int offset = 0;
		int pageSize = 4;
		List<Student> students = studentDao.queryByNameAndGender(name, gender, offset, pageSize);
		for (Student student : students) {
			System.out.println(student);
		}
	}
	//Student [id=1, name=张天, age=16, gender=男, address=上海]
	//Student [id=11, name=谢天, age=17, gender=男, address=青岛]
	
	@Test
	public void testGetSearchCount() {
		String name = "天";
		String gender = "男";
		int count = studentDao.getSearchCount(name, gender);
		System.out.println("count = " + count);
	}
	
	// count = 2;
	@Test
	public void testQueryAll() {
		int offset = 2;
		int pageSize = 3;
		List<Student> students = studentDao.queryAll(offset, pageSize);
		for (Student student : students) {
			System.out.println(student);
		}
	}
//Student [id=3, name=何红, age=17, gender=男, address=合肥]
//Student [id=4, name=田倩倩, age=16, gender=女, address=西安]
//Student [id=5, name=明小军, age=15, gender=男, address=上海]

	@Test
	public void testGetCount() {
		int count = studentDao.getCount();
		System.out.println("count = " + count);
	}
//count = 10
}

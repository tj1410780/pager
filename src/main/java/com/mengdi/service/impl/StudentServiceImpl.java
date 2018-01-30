package com.mengdi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.mengdi.dao.StudentDao;
import com.mengdi.entity.Student;
import com.mengdi.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource
	private StudentDao studentDao;
	
	public List<Student> getByNameAndGender(String name, String gender, int currentPage, int pageSize) {
		int offset = (currentPage -1) * pageSize;
		System.out.println("offset=" + offset);
		List<Student> list = studentDao.queryByNameAndGender(name, gender, offset, pageSize);
		return list;
	}

	public int getSearchCount(String name, String gender) {
		int count = studentDao.getSearchCount(name, gender);
		return count;
	}

	public List<Student> getAll(int currentPage, int pageSize) {
		int offset = (currentPage - 1) * pageSize;
		List<Student> list = studentDao.queryAll(offset, pageSize);
		return list;
	}

	public int getCount() {
		int count = studentDao.getCount();
		return count;
	}


}

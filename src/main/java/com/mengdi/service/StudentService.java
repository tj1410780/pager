package com.mengdi.service;

import java.util.List;

import com.mengdi.entity.Student;

public interface StudentService {

	List<Student> getByNameAndGender(String name, String gender, int currentPage, int pageSize);
	
	int getSearchCount(String name, String gender);
	
	List<Student> getAll(int currentPage, int pageSize);
	
	int getCount();
	
}

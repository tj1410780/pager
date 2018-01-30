package com.mengdi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mengdi.entity.Student;

public interface StudentDao {	
	
	List<Student> queryByNameAndGender(@Param("name") String name, @Param("gender") String gender, @Param("offset") int offset, @Param("pageSize") int pageSize);
	
	int getSearchCount(@Param("name") String name, @Param("gender") String gender);
	
	List<Student> queryAll(@Param("offset") int offset, @Param("pageSize") int pageSize);
	
	int getCount();
}

package com.example.lesson04.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.lesson04.domain.Student;

@Mapper
public interface StudentMapper {
	
	// input: Student, output: rowCount
	public int insertStudent(Student student);
	
	// input: id, output: Student
	public Student selectStudentById(int id);
}

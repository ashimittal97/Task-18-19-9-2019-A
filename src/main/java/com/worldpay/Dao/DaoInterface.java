package com.worldpay.Dao;

import java.util.List;

import com.worldpay.Models.Student;

public interface DaoInterface {
	
	public void addStudent(Student student);
	public void removeStudent(int code);
	public void updateStudent(Student student);
	public Student getStudentById(int code);
	public List<Student> getAllStudents();

}

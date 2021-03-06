package com.worldpay.Services;

import java.util.List;

import com.worldpay.Models.Student;

public interface StudentServices {
	
	public void studentEntry(Student student);
	public void deleteStudent(int code); 
	public void changeStudentDetails(Student student);
	public Student searchStudent(int code);
	public List<Student> viewAllStudents();

}

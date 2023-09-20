package com.BikkadIT.CurdOperationUsingRest.service;

import java.util.List;

import com.BikkadIT.CurdOperationUsingRest.model.Student;

public interface StudentServiceI {

	public boolean saveStudent(Student stu);

	public String saveAllStudents(List<Student> stu);

	public List<Student> getAllStudent();

	public Student getStudentById(int id);
	
	public Student getStudentByIdreq(int id);

	public boolean updateStudent(Student stu);
	
	public String updateAllStudent(List<Student>stu);
	
	public boolean deleteRecordById(int id);
	
	public boolean deleteAllRecord();
}

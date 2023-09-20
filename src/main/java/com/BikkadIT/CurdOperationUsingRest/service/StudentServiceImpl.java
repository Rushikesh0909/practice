package com.BikkadIT.CurdOperationUsingRest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BikkadIT.CurdOperationUsingRest.model.Student;
import com.BikkadIT.CurdOperationUsingRest.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentServiceI {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public boolean saveStudent(Student stu) {
		Student save = studentRepository.save(stu);
		if (save != null) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public String saveAllStudents(List<Student> stu) {
		List<Student> saveAll = studentRepository.saveAll(stu);
		if (saveAll != null) {
			return "all student save successfully";
		}
		return "all student not save successfully";
	}

	@Override
	public List<Student> getAllStudent() {
		List<Student> findAll = studentRepository.findAll();
		return findAll;
	}

	@Override
	public Student getStudentById(int id) {
		Student findById = studentRepository.findById(id).get();
		return findById;
	}

	@Override
	public Student getStudentByIdreq(int id) {
		Student findById = studentRepository.findById(id).get();
		return findById;
	}

	@Override
	public boolean updateStudent(Student stu) {
		Student save = studentRepository.save(stu);

		if (save != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String updateAllStudent(List<Student> stu) {
		List<Student> updateAll = studentRepository.saveAll(stu);
		if (updateAll != null) {
			return "all student update successfully";
		}
		return "all student not update successfully";
	}

	@Override
	public boolean deleteRecordById(int id) {
		boolean exists = studentRepository.existsById(id);
		if(exists) {
			studentRepository.deleteById(id);
			return true;
		}else {
		return false;
	}}

	@Override
	public boolean deleteAllRecord() {
		List<Student> findAll = studentRepository.findAll();
		if(findAll.isEmpty()) {
			return false;
		}
		else {
			studentRepository.deleteAll();
			return true;
	}
	}
}

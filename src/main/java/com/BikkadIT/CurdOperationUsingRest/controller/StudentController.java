package com.BikkadIT.CurdOperationUsingRest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.BikkadIT.CurdOperationUsingRest.model.Student;
import com.BikkadIT.CurdOperationUsingRest.service.StudentServiceI;

@RestController
public class StudentController {

	@Autowired
	private StudentServiceI studentServiceI;

	@PostMapping(value = "/saveStudent", consumes = "application/json")
	public ResponseEntity<String> saveStudent(@RequestBody Student stu) {
		boolean saveStudent = studentServiceI.saveStudent(stu);
		if (saveStudent) {
			return new ResponseEntity<String>("Studnet save successfully", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Studnet not save successfully", HttpStatus.BAD_REQUEST);
	}

	@PostMapping(value = "/saveAllStudent", consumes = "application/json")
	public ResponseEntity<String> saveAllStudent(@RequestBody List<Student> stu) {
		String saveAllSTudents = studentServiceI.saveAllStudents(stu);
		return new ResponseEntity<String>(saveAllSTudents, HttpStatus.CREATED);

	}

	@GetMapping(value = "/getAllStudent", produces = "application/json")
	public ResponseEntity<List<Student>> getAllStudent() {
		List<Student> allStudent = studentServiceI.getAllStudent();
		return new ResponseEntity<List<Student>>(allStudent, HttpStatus.OK);

	}

	@GetMapping("/getStudentById/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable int id) {
		Student studentById = studentServiceI.getStudentById(id);
		return new ResponseEntity<Student>(studentById, HttpStatus.OK);

	}

	@GetMapping("/getStudentByIdreq")
	public ResponseEntity<Student> getStudentByIdreq(@RequestParam int id) {
		Student studentByIdreq = studentServiceI.getStudentByIdreq(id);
		return new ResponseEntity<Student>(studentByIdreq, HttpStatus.OK);

	}

	@PutMapping(value = "/updateStudent", consumes = "application/json")
	public ResponseEntity<String> updateStudent(@RequestBody Student stu) {
		boolean updateStudent = studentServiceI.updateStudent(stu);
		if (updateStudent) {
			return new ResponseEntity<String>("update successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("update not successfully", HttpStatus.BAD_REQUEST);
		}

	}

	@PutMapping(value = "/UpdateAllStudents", consumes = "application/json")
	public ResponseEntity<String> UpdateAllStudents(@RequestBody List<Student> stu) {
		String updateAllStudent = studentServiceI.updateAllStudent(stu);
		return new ResponseEntity<String>(updateAllStudent, HttpStatus.CREATED);

	}

	@DeleteMapping("/deletebyId/{id}")
	public ResponseEntity<String> deletebyId(@PathVariable int id) {
		boolean byId = studentServiceI.deleteRecordById(id);
		if (byId) {
			String msg = "Record deleted successfully";
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} else {
			String msg = "Record not deleted successfully";
			return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
		}

	}

	@DeleteMapping("/deleteAll")
	public ResponseEntity<String> deleteAll() {
		  boolean allRecord = studentServiceI.deleteAllRecord();
		if (allRecord) {
			String msg = "Record deleted successfully";
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} else {
			String msg = "Record not deleted successfully";
			return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
		}
	}
}

package com.BikkadIT.CurdOperationUsingRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BikkadIT.CurdOperationUsingRest.model.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}

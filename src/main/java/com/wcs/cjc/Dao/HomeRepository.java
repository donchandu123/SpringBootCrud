package com.wcs.cjc.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wcs.cjc.model.Student;

@Repository
public interface HomeRepository extends JpaRepository<Student, Integer> {

	List<Student> getSingleDataByStudentRollno(int rollno);

}

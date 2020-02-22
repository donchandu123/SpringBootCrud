package com.wcs.cjc.Service;

import java.util.List;

import com.wcs.cjc.model.Student;


public interface StudentServiceInterface {
	
	public int saveStudentData(Student stu);
	
	public List<Student> getAllStudentData();
	
	public  List<Student> getSingleStudentData(int rollno);
	
	public int deleteData(int rollno);
	
	public Student editStudentData(int rollno);
	
	public void updateStudentData(Student s);
	

}

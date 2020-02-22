package com.wcs.cjc.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wcs.cjc.Dao.HomeRepository;
import com.wcs.cjc.model.Student;
@Service
public class StudentServiceImpl implements StudentServiceInterface {
	
	@Autowired 
	HomeRepository studentRepositoryinter;

	@Override
	public int saveStudentData(Student stu) {
		studentRepositoryinter.save(stu);
		return 1;
	}

	@Override
	public List<Student> getAllStudentData(){
		 List<Student> list= studentRepositoryinter.findAll();
		 
		return list;
	}

	@Override
	public List<Student> getSingleStudentData(int rollno) {
		List<Student> list=studentRepositoryinter.getSingleDataByStudentRollno(rollno);
		return list;
	}

	@Override
	public int deleteData(int rollno) {
		studentRepositoryinter.deleteById(rollno);
		return 2;
	}

	@Override
	public Student editStudentData(int rollno) {
		Object stu=studentRepositoryinter.findById(rollno);
		return (Student) stu;
	}

	@Override
	public void updateStudentData(Student s) {
		studentRepositoryinter.save(s);
		
	}

}

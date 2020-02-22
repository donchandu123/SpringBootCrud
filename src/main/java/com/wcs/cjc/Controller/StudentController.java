package com.wcs.cjc.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wcs.cjc.Service.StudentServiceInterface;
import com.wcs.cjc.model.Student;


@CrossOrigin("*")
@RestController
@RequestMapping("/student")
public class StudentController {
	
	
	@Autowired 
	StudentServiceInterface studentserviceI;

	@Autowired
	ObjectMapper obj;
	
	@RequestMapping("/log/{username}/{password}/{rollno}")
	public String login(@PathVariable String un,@PathVariable String pw, @PathVariable int rollno) throws JsonProcessingException
	{
		if(un.equals("admin")&& pw.equals("admin123"))
		{
			List<Student>list=studentserviceI.getAllStudentData();
			String json=obj.writeValueAsString(list);
			return json;
		}
		else {
			List<Student>list=studentserviceI.getSingleStudentData(rollno);
			String json=obj.writeValueAsString(list);
			return json;
			
		}
	}
	
	@RequestMapping("/reg")
	public String savedata(@RequestBody Student stu)
	{
		int status =studentserviceI.saveStudentData(stu);
		
		if(status>0) {
		return "data register successfully";
		}
		else {
			return "registration fails";
		}
	}
	@RequestMapping("/getAllStudentData")
	public String showAllStudentsInformation() throws JsonProcessingException
	{
		List<Student>list=studentserviceI.getAllStudentData();
		String json=obj.writeValueAsString(list);
		return json;
	}
	
	@RequestMapping("/getSingleStudentData/{rollno}")
		public String showSingleStudentInformation(@PathVariable int rollno) throws JsonProcessingException
		{
		List<Student>list=studentserviceI.getSingleStudentData(rollno);
		String json=obj.writeValueAsString(list);
		return json;
	}
	@RequestMapping("/deletStudentData/{rollno}/{username}/{password}")
	public String deletStudentData(@PathVariable int rollno, @PathVariable String un,@PathVariable String pw) throws JsonProcessingException
	{
		int status=studentserviceI.deleteData(rollno);
		if(un.equals("admin")&& pw.equals("admin123"))
		{
			List<Student>list=studentserviceI.getAllStudentData();
			String json=obj.writeValueAsString(list);
			return json;
		}
		else {
		return "Data Deleted Successfully";
		}
	}
	@RequestMapping("/editStudentData/{rollno}")
	public String editStudentData(@PathVariable int rollno) throws JsonProcessingException
	{ 
		Student sss=studentserviceI.editStudentData(rollno);
		String json=obj.writeValueAsString(sss);
		return json;
	}
	@RequestMapping("/updateStudentData/{username}/{password}")
	public String updateStudentData(@RequestBody Student s, @PathVariable String un,@PathVariable String pw) throws JsonProcessingException
	{	
		studentserviceI.updateStudentData(s);
		if(un.equals("admin")&& pw.equals("admin123"))
		{
			List<Student>list=studentserviceI.getAllStudentData();
			String json=obj.writeValueAsString(list);
			return json;
		}
		else {
		return "data Updated Successfully";
		}
	}
}
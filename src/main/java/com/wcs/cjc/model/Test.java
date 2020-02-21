package com.wcs.cjc.model;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		Student stu=new Student();
				stu.setName("SHUBHAM");
		stu.setRollno(101);
		stu.setAreaname("WARJE");
		stu.setCityname("PUNE");
		Student stu1=new Student();
		stu1.setName("Sneha");
		stu1.setRollno(101);
		stu1.setAreaname("karve");
		stu1.setCityname("PUNE");
		
		List<Student> l=new ArrayList<Student>();
		l.add(stu);
		l.add(stu1);
	


	}
}

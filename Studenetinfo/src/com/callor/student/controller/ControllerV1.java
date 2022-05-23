package com.callor.student.controller;

import com.callor.student.StudentService;
import com.callor.student.service.impl.StudentServiceImpl;

public class ControllerV1 {
	public static void main(String[] args) {
		StudentService stService =new StudentServiceImpl(null);
		stService.inputStudent();
		stService.printstudent();
		
		
	}

}

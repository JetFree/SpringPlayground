package com.luv2code.springrest.demo.rest;

import com.luv2code.springrest.demo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	// add code for the "/hello" endpoint
	
	@GetMapping("/students")
	@ResponseBody
	public List<Student> getStudents() {
		List<Student> students = new ArrayList<>();
		students.add(new Student("Pavel", "Niedvecki"));
		students.add(new Student("Ivan", "Gurinovich"));
		students.add(new Student("Max", "Crazy"));
		return students;

	}
	
}

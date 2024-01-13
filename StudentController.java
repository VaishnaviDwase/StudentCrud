package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Student;
import com.example.demo.Service.StudentService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentservice;
	
	@PostMapping("/register")
	public void saveStudentData(@RequestBody Student student)
	{
		 studentservice.saveStudentData(student);
		 System.out.println("student data save sucessfully");
	}
	
	@GetMapping("/login")
	public List<Student> getStudentData()
	{
		return studentservice.getStudentData();
	}
	
	@PutMapping("login/{id}")
	public String updateStudentData(@PathVariable int id, @RequestBody Student student) 
	{
		Optional<Student> existingId=studentservice.findById(id);
		if(existingId!=null)
		{
			student.setId(id);
			 studentservice.updateStudentData(id, student);
		}
		else
		{
			return "searching student not present";
		}
        return "Student data updated successfully";
	}
	
	  @DeleteMapping("/{id}") 
	    public ResponseEntity<Object> deleteStudentData(@PathVariable Long id) 
	  {
	        studentservice.deleteStudentData(id);
	        return ResponseEntity.ok("Student data deleted successfully");
	  }
}
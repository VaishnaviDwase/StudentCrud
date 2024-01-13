package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import com.example.demo.Entity.Student;

public interface StudentService {

	public void saveStudentData(Student student);

	public List<Student> getStudentData();

	public String updateStudentData(int id, Student student);

	public Optional<Student> findById(int id);

	public void deleteStudentData(Long id);
		


}

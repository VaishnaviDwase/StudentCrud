package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Student;
import com.example.demo.Repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	public StudentRepository studentrepo;

	@Override
	public void saveStudentData(Student student) {
		// TODO Auto-generated method stub
	    studentrepo.save(student);
	}

	@Override
	public List<Student> getStudentData() {
		// TODO Auto-generated method stub
		return studentrepo.findAll();
	}

	@Override
	public String updateStudentData(int id, Student student) 
	{
		studentrepo.save(student);
		return " data updated";
	}

	@Override
	public Optional<Student> findById(int id) {
		// TODO Auto-generated method stub
		return studentrepo.findById(id);
	}

	@Override
	public void deleteStudentData(Long id) {
		// TODO Auto-generated method stub
		 studentrepo.deleteAll();
	}
	
	

}

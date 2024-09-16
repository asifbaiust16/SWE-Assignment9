package edu.mum.cs.cs425.eRegistrar.services.impl;

import java.util.List;
import java.util.Optional;

import edu.mum.cs.cs425.eRegistrar.services.IStudentService;
import edu.mum.cs.cs425.eRegistrar.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.eRegistrar.repositoies.IStudentRepository;

@Service
public class StudentService implements IStudentService {
	
	@Autowired
	private IStudentRepository studentRepository;
	public void save( Student student)
	{
		studentRepository.save(student);
	}

	public List<Student> findAll(){

		return studentRepository.findAll();
	}	

	public Optional<Student> findById(Long id)
	{

		return studentRepository.findById(id);
	}

	public void update(Student student, Long id){
		Student std = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
		std.setStudentNumber(student.getStudentNumber());
		std.setFirstName(student.getFirstName());
		std.setMiddleName(student.getMiddleName());
		std.setLastName(student.getLastName());
		std.setCgpa(student.getCgpa());
		std.setEnrollmentDate(student.getEnrollmentDate());
		std.setInternational(student.isInternational());
		studentRepository.save(student);
	}

	public void delete(Long id)
	{
		studentRepository.deleteById(id);
	}

}
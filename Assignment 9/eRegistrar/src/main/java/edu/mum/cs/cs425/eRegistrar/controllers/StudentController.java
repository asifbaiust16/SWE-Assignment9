package edu.mum.cs.cs425.eRegistrar.controllers;

import java.util.Optional;

import edu.mum.cs.cs425.eRegistrar.models.Student;
import edu.mum.cs.cs425.eRegistrar.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class StudentController {

   @Autowired
   private IStudentService studentService;

	@GetMapping(value = {"", "/eregistrar", "/eregistrar/home"})
	public String displayHomePage(Model model) {
		model.addAttribute("students", studentService.findAll());
		return "index";
	}
	
	@GetMapping("/students")
	public String findAll(Model model){		
		model.addAttribute("students", studentService.findAll());
		return "index";
	}	
	@GetMapping("/student/findById/{id}")
	public Optional<Student> findById(@PathVariable Long id, Model model){
		return studentService.findById(id);
	}

	@PostMapping(value="/student/addNew")
	public String addNew(Student student, Model model) {
		studentService.save(student);
		model.addAttribute("students", studentService.findAll());
		return "index";
	}	
	
	@RequestMapping(value="/student/update/{id}", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Student student, Long id, Model model) {
		studentService.update(student,id);
		model.addAttribute("students", studentService.findAll());
		return "index";
	}
	
	@GetMapping("/student/delete/{id}")
    public String deleteStudent(@PathVariable Long id, Model model ) {
		studentService.delete(id);
		model.addAttribute("students", studentService.findAll());
		return "index";
    }
}
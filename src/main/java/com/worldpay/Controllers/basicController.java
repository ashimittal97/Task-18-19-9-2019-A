package com.worldpay.Controllers;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.worldpay.Models.Student;
import com.worldpay.Services.StudentServices;

@Controller
public class basicController {

	@Autowired
	private StudentServices studentServices;

	@RequestMapping("showDetails")
	public ModelAndView showdetails(@ModelAttribute("save") Student student) {

		studentServices.studentEntry(student);

		ModelAndView modelAndView = new ModelAndView("show");
		modelAndView.addObject("student", student);
		modelAndView.addObject("message", "Successfully Inserted..!!!");

		return modelAndView;
	}

	@RequestMapping("removeDetails")
	public ModelAndView removeStudent(@RequestParam("rno") int rno) {
		Student student=studentServices.searchStudent(rno);
		ModelAndView modelAndView = new ModelAndView("show");
		modelAndView.addObject("student", student);
		studentServices.deleteStudent(rno);
		modelAndView.addObject("message", "Successfully Deleted..!!!");
		return modelAndView;
	}

	@RequestMapping("searchPage")
	public ModelAndView searchDeatils(@RequestParam("rno") int rno) {
		Student student = studentServices.searchStudent(rno);
		ModelAndView modelAndView = new ModelAndView("Fetch");
		modelAndView.addObject("student", student);
		return modelAndView;

	}

	@RequestMapping("allstudent")
	public ModelAndView getAllStudents() {
		List<Student> students = studentServices.viewAllStudents();
		ModelAndView modelAndView = new ModelAndView("viewall");
		modelAndView.addObject("students", students);
		return modelAndView;
	}

	@RequestMapping("inputpage")
	public String showInputForm() {
		return "dataEntry";
	}

	@RequestMapping("search")
	public String Search() {
		return "searchPage";
	}

	@RequestMapping("remove")
	public String Remove() {
		return "removeDetails";
	}

}

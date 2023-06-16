package com.takeo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.takeo.model.Student;
import com.takeo.service.StudentServiceImpl;

@Controller
public class StudentController {
	
@Autowired	
private StudentServiceImpl daoService;	
	
List<String> courses;

@ModelAttribute
public void preLoad()
{
	courses=new ArrayList<String>();
	courses.add("SpringBoot");
	courses.add("SpringRest");
	courses.add("MicroServices");
}

@RequestMapping(value = "/",method = RequestMethod.GET)
public String home(Model model,Student student)
{
	model.addAttribute("courses",courses);
	return "register";
}
	

@RequestMapping(value = "/insert",method = RequestMethod.POST)
public String register(@ModelAttribute     Student student,Model model)
{
	
	int count = daoService.saveStudent(student);
	
	String msg="";
	if(count!=0)
	msg="Registration Success";
	else
		msg="Try Later!";
	
	
	model.addAttribute("msg", msg);
	return "welcome";
}








	

}

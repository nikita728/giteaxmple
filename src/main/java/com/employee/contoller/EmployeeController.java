package com.employee.contoller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.employee.config.AppCon;
import com.employee.config.AppConfig;
import com.employee.entity.Employee;
import com.employee.service.EmployeeService;

@Controller
@RequestMapping(value="/")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeservice;
	@RequestMapping(value="/employee",method=RequestMethod.GET)
	public ModelAndView Employee()
	{
		Employee employee= new Employee();
		ModelAndView mv= new ModelAndView("employee");
		mv.addObject("employee",employee);
		return mv;	
	}
	@RequestMapping(value="/employee")
	public void save(@ModelAttribute("employee")Employee emp)
	{
		employeeservice.addEmployee(emp);
		
	}
	@RequestMapping(value="/employeeupdate",method=RequestMethod.GET)
	public ModelAndView update()
	{
		Employee employee= new Employee();
		ModelAndView mv= new ModelAndView("employeeupdate");
		mv.addObject("employeeupdate",employee);
		
		return mv;
		
		
	}
	@RequestMapping(value="/employeeupdate")
	public void saveupdate(@ModelAttribute("employeeupdate")Employee emp)
	{
		employeeservice.editEmployee(emp,emp.getFirstName());
		
	}
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public ModelAndView delete(@ModelAttribute("delete")Employee emp)
	{
		Employee employee= new Employee();
		ModelAndView mv= new ModelAndView("delete");
		mv.addObject("delete",employee);
		
		return mv;
	}
	@RequestMapping(value="/delete")
	public void savedelete(@ModelAttribute("delete")Employee emp)
	{
		employeeservice.deleteEmployee(emp,emp.getFirstName());
		
	}
	@RequestMapping(value="/find",method=RequestMethod.GET)
	public ModelAndView find(@ModelAttribute("find")Employee emp)
	{
		Employee employee= new Employee();
		ModelAndView mv= new ModelAndView("find");
		mv.addObject("find",employee);
		
		return mv;
		
		
	}
	@RequestMapping(value="/find")
	public String FindData(@ModelAttribute("find")Employee emp,Model model, BindingResult result) 
	{
	
		com.employee.entity.Employee l1= employeeservice.Find(emp.getFirstName());
	
		model.addAttribute("employee",l1);		
		
		return "see";
}

	@RequestMapping(value="seeAll",method=RequestMethod.GET)
	public String SeeData(Model model, Employee employee, BindingResult result) 
	{
	
		List<Employee> l1= employeeservice.findAll();
	
		
		model.addAttribute("list",l1);
		return "seeAll";

}
}

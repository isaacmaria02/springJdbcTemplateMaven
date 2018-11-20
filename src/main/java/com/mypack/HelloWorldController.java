package com.mypack;
import java.io.IOException;
import java.rmi.ServerException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController 
{
	@Autowired
	TestDAO edao;
	
	/*@RequestMapping("/hello1")
	public ModelAndView helloWorld1()
	{
		System.out.println("test....");
		return new ModelAndView("display");
	}*/
	@RequestMapping("/hello2")
	public ModelAndView Save(HttpServletRequest request,HttpServletResponse response) throws ServerException,IOException
	{
		System.out.println("test2....");
		Employee e=new Employee();
		e.setFname(request.getParameter("fname"));
		e.setLname(request.getParameter("lname"));
		int i=edao.saveData(e);
		if(i>0)
		{
			System.out.println("save");
		}
		else
		{
			System.out.println("not save..");
		}
		return new ModelAndView("display");
	}
	
	@RequestMapping("/hello")
	public ModelAndView DisplayAll(HttpServletRequest request, HttpServletResponse response) throws ServerException,IOException, ServletException
	{
		System.out.println("test in display");
		List<Employee> lst = new ArrayList<Employee>();
		lst = edao.getAllEmployees();
		request.setAttribute("usrList",lst);
		for(Employee e:lst)  
	        System.out.println(e.getFname() + " " + e.getLname());  
		return new ModelAndView("displayAll");
	}
		@RequestMapping("/viewemp")  
	    public ModelAndView viewemp(){  
	        List<Employee> list=edao.getAllEmployees();  
	        return new ModelAndView("viewemp","list",list);  
	    }  
		
		@RequestMapping(value="/editemp/{fname}")  
	    public ModelAndView edit(@PathVariable String fname){  
	        Employee emp=edao.getEmpByFname(fname);  
	        return new ModelAndView("empeditform","command",emp);  
	    }  
	
	  @RequestMapping(value="/editsave",method = RequestMethod.POST)  
	    public ModelAndView editsave(@ModelAttribute("emp") Employee emp){  
	        edao.update(emp);  
	        return new ModelAndView("redirect:/viewemp");  
	    }  
	  
	  @RequestMapping(value="/deleteemp/{fname}",method = RequestMethod.GET)  
	    public ModelAndView delete(@PathVariable String fname){  
	        edao.delete(fname);  
	        return new ModelAndView("redirect:/viewemp");  
	    }  
}

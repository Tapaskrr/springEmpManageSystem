package com.te.employeemanagesystem.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.te.employeemanagesystem.entity.Employee;
import com.te.employeemanagesystem.services.MyService;

@Controller
public class MyController {

	@Autowired
	private MyService myService;

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/register")
	public String register() {
		return "register";
	}

	@GetMapping("/click")
	public String register1() {
		return "click";
	}

	@PostMapping("/login")
	public String myLogin(Employee employee, Model map, HttpServletRequest request) {
		if (employee != null && !employee.getEmpId().isEmpty() || employee.getEmpPwd().isEmpty()) {
			Employee authenticate = myService.authenticate(employee);
			if (authenticate != null) {
				HttpSession session = request.getSession();
				session.setAttribute("loggedIn", authenticate);

				map.addAttribute("msg", "login successfull");
				return "welcome";
			} else {
				map.addAttribute("errmsg", "something went wrong");
				return "login";
			}

		} else {
			map.addAttribute("errmsg", "plz type something");
			return "login";
		}

	}

	@PostMapping("/register")
	public String myRegister(Employee employee, Model map) {

		if (employee != null && !employee.getEmpId().isEmpty() || !employee.getEmpMail().isEmpty()
				|| !employee.getEmpName().isEmpty() && !employee.getEmpPwd().isEmpty()) {
			if (myService.create(employee)) {
				map.addAttribute("msg", "registration successfull");
			} else {
				map.addAttribute("errmsg", "something went wrong");
			}

		} else {
			map.addAttribute("errmsg", "plz type something");
		}

		return "register";
	}

	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
	}

	@GetMapping("/myalldetails")
	public String myalldetails(Model map, @SessionAttribute(name = "loggedIn", required = false) Employee employee) {
		map.addAttribute("empId", employee.getEmpId());
		map.addAttribute("empName", employee.getEmpName());
		map.addAttribute("empEmail", employee.getEmpMail());
		map.addAttribute("empPwd", employee.getEmpPwd());

		return "myalldetails";
	}

	@GetMapping("/update")
	public String update(Model map, @SessionAttribute(name = "loggedIn", required = false) Employee employee) {
		map.addAttribute("empId", employee.getEmpId());
		map.addAttribute("empName", employee.getEmpName());
		map.addAttribute("empEmail", employee.getEmpMail());
		map.addAttribute("empPwd", employee.getEmpPwd());
		return "update";
	}

	@PostMapping("/updatedata")
	public String updataData(Model map, @SessionAttribute(name = "loggedIn", required = false) Employee emp,
			Employee employee) {
		
		System.out.println(employee);
		System.out.println("hello");
		if (employee != null && !employee.getEmpMail().isEmpty()
				|| !employee.getEmpName().isEmpty() && !employee.getEmpPwd().isEmpty()) {
			if (myService.update(employee,emp.getEmpId())) {
				map.addAttribute("msg", "updation successfull");
			} else {
				map.addAttribute("errmsg", "something went wrong");
			}

		} else {
			map.addAttribute("errmsg", "plz type something");
		}
		return "welcome";
	}

}

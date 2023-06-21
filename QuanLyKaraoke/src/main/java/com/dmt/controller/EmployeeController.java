package com.dmt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dmt.model.Employee;
import com.dmt.service.EmployeeService;

@Controller
public class EmployeeController {

	@RequestMapping(value = "/LoginEmployee", method = RequestMethod.GET)
	public String loginCustomer() {
		return "LoginEmployee";
	}

	@RequestMapping(value = "/LoginEmployee", method = RequestMethod.POST)
	public String loginCustomer(@RequestParam("userName") String userName, HttpServletRequest request,
			@RequestParam("pswd") String password) {
		EmployeeService service = new EmployeeService();
		try {
			Employee employee = service.LoginEmployee(userName, password);
			if (employee == null) {
				request.setAttribute("LoginFail", 1);
				return "LoginEmployee";
			}
			HttpSession session = request.getSession();
			session.setAttribute("loginPersonE", employee);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/manager-customer";
	}

	@RequestMapping(value = "/register-employee", method = RequestMethod.GET)
	public String addNewCustomer() {
		return "RegisterEmployee";
	}

	@RequestMapping(value = "/register-employee", method = RequestMethod.POST)
	public String addNewCustomer(@RequestParam("userName") String userName, @RequestParam("password") String password,
			@RequestParam("fullName") String fullName, @RequestParam("email") String email,
			@RequestParam("phoneNumber") String phoneNumber, @RequestParam("address") String address,
			HttpServletRequest request) {

		EmployeeService service = new EmployeeService();
		try {
			service.addNewEmployee(userName, password, fullName, email, phoneNumber, address);
			request.setAttribute("checkFlag", 1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "redirect:/Home";
	}

}

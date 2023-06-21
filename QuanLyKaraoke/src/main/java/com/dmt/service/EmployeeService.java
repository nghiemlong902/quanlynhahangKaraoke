package com.dmt.service;

import com.dmt.dao.EmployeeDao;
import com.dmt.model.Employee;

public class EmployeeService {

	public void addNewEmployee(String username, String password, String fullName, String email, String phoneNumber,
			String address) throws Exception {
		EmployeeDao dao = new EmployeeDao();
		dao.addNewEmployee(username, password, fullName, email, phoneNumber, address);
	}

	public Employee LoginEmployee(String username, String password) throws Exception {
		EmployeeDao dao = new EmployeeDao();
		return dao.login(username, password);
	}
}

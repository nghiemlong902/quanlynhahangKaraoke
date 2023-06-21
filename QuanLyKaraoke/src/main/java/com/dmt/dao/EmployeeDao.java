package com.dmt.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dmt.model.Employee;

public class EmployeeDao {
	public void addNewEmployee(String username, String password, String fullName, String email, String phoneNumber,
			String address) throws Exception {
		ConnectDB connect = new ConnectDB();
		connect.KetNoi();
		String sql = "INSERT INTO employee (userName, password, fullName, email, phoneNumber, address) VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement cmd = connect.cn.prepareStatement(sql);
		cmd.setString(1, username);
		cmd.setString(2, password);
		cmd.setString(3, fullName);
		cmd.setString(4, email);
		cmd.setString(5, phoneNumber);
		cmd.setString(6, address);
		cmd.executeUpdate();
		connect.cn.close();
	}

	public Employee login(String username, String password) throws Exception {
		ConnectDB connect = new ConnectDB();
		connect.KetNoi();
		String sql = "SELECT * FROM Employee WHERE userName=? AND password=?";
		PreparedStatement stmt = connect.cn.prepareStatement(sql);
		stmt.setString(1, username);
		stmt.setString(2, password);
		ResultSet rs = stmt.executeQuery();

		if (rs.next()) {
			Employee employee = new Employee();
			employee.setId(rs.getInt("id"));
			employee.setuserName(rs.getString("userName"));
			employee.setFullName(rs.getString("fullName"));
			employee.setEmail(rs.getString("email"));
			employee.setPhoneNumber(rs.getString("phoneNumber"));
			employee.setAddress(rs.getString("address"));
			return employee;
		} else {
			return null;
		}
	}
}

package com.dmt.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dmt.model.Customer;

public class CustomerDao {

	public void addNewCustomer(String username, String password, String fullName, String email, String phoneNumber,
			String address) throws Exception {
		ConnectDB connect = new ConnectDB();
		connect.KetNoi();
		String sql = "INSERT INTO Customer (userName, password, fullName, email, phoneNumber, address) VALUES (?, ?, ?, ?, ?, ?)";
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

	public void updateCustomer(int id, String username, String password, String fullName, String email,
			String phoneNumber, String address) throws Exception {
		ConnectDB connect = new ConnectDB();
		connect.KetNoi();
		String sql = "UPDATE Customer SET userName=?, password=?, fullName=?, email=?, phoneNumber=?, address=? WHERE id=?";
		PreparedStatement cmd = connect.cn.prepareStatement(sql);
		cmd.setString(1, username);
		cmd.setString(2, password);
		cmd.setString(3, fullName);
		cmd.setString(4, email);
		cmd.setString(5, phoneNumber);
		cmd.setString(6, address);
		cmd.setInt(7, id);
		cmd.executeUpdate();
		connect.cn.close();
	}

	public void deleteCustomer(int id) throws Exception {
		ConnectDB connect = new ConnectDB();
		connect.KetNoi();
		String sql = "DELETE FROM Customer WHERE id=?";
		PreparedStatement cmd = connect.cn.prepareStatement(sql);
		cmd.setInt(1, id);
		cmd.executeUpdate();
		connect.cn.close();
	}

	public List<Customer> getAllCustomer() throws Exception {
		List<Customer> customers = new ArrayList<>();
		ConnectDB connect = new ConnectDB();
		connect.KetNoi();
		String sql = "SELECT * FROM Customer";
		PreparedStatement cmd = connect.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			int id = rs.getInt("id");
			String userName = rs.getString("userName");
			String password = rs.getString("password");
			String fullName = rs.getString("fullName");
			String email = rs.getString("email");
			String phoneNumber = rs.getString("phoneNumber");
			String address = rs.getString("address");
			customers.add(new Customer(id, userName, password, fullName, email, phoneNumber, address));
		}
		connect.cn.close();
		return customers;
	}

	public List<Customer> searchCustomer(String key) throws Exception {
		List<Customer> customers = new ArrayList<Customer>();
		ConnectDB connect = new ConnectDB();
		connect.KetNoi();
		String sql = "SELECT * FROM Customer WHERE id LIKE ? OR userName LIKE ? OR fullName LIKE ? OR email LIKE ? OR phoneNumber LIKE ? OR address LIKE ?";
		PreparedStatement cmd = connect.cn.prepareStatement(sql);
		for (int i = 1; i <= 6; i++) {
			cmd.setString(i, "%" + key + "%");
		}
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			int id = rs.getInt("id");
			String username = rs.getString("userName");
			String password = rs.getString("password");
			String fullName = rs.getString("fullName");
			String email = rs.getString("email");
			String phoneNumber = rs.getString("phoneNumber");
			String address = rs.getString("address");
			Customer customer = new Customer(id, username, password, fullName, email, phoneNumber, address);
			customers.add(customer);
		}
		connect.cn.close();
		return customers;
	}

	public Customer login(String username, String password) throws Exception {
		ConnectDB connect = new ConnectDB();
		connect.KetNoi();
		String sql = "SELECT * FROM Customer WHERE userName=? AND password=?";
		PreparedStatement stmt = connect.cn.prepareStatement(sql);
		stmt.setString(1, username);
		stmt.setString(2, password);
		ResultSet rs = stmt.executeQuery();

		if (rs.next()) {
			Customer customer = new Customer();
			customer.setId(rs.getInt("id"));
			customer.setuserName(rs.getString("userName"));
			customer.setPassword(rs.getString("password"));
			customer.setFullName(rs.getString("fullName"));
			customer.setEmail(rs.getString("email"));
			customer.setPhoneNumber(rs.getString("phoneNumber"));
			customer.setAddress(rs.getString("address"));
			return customer;
		} else {
			return null;
		}
	}

}

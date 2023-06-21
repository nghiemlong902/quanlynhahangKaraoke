package com.dmt.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dmt.model.Manager;
import com.dmt.model.Product;
import com.dmt.model.Supplier;

public class ManagerDao {
	public void addNewManager(String username, String password, String fullName, String email, String phoneNumber,
			String address) throws Exception {
		ConnectDB connect = new ConnectDB();
		connect.KetNoi();
		String sql = "INSERT INTO Manager (userName, password, fullName, email, phoneNumber, address) VALUES (?, ?, ?, ?, ?, ?)";
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

	public Manager login(String username, String password) throws Exception {
		ConnectDB connect = new ConnectDB();
		connect.KetNoi();
		String sql = "SELECT * FROM Manager WHERE userName=? AND password=?";
		PreparedStatement stmt = connect.cn.prepareStatement(sql);
		stmt.setString(1, username);
		stmt.setString(2, password);
		ResultSet rs = stmt.executeQuery();

		if (rs.next()) {
			Manager manager = new Manager();
			manager.setId(rs.getInt("id"));
			manager.setUsername(rs.getString("username"));
			manager.setFullName(rs.getString("fullName"));
			manager.setEmail(rs.getString("email"));
			manager.setPhoneNumber(rs.getString("phoneNumber"));
			manager.setAddress(rs.getString("address"));
			return manager;
		} else {
			return null;
		}
	}

	public List<Supplier> getAllSuplier() throws Exception {
		ConnectDB connect = new ConnectDB();
		connect.KetNoi();
		String sql = "SELECT * FROM supplier";
		PreparedStatement stmt = connect.cn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		List<Supplier> list = new ArrayList<>();
		while (rs.next()) {
			Supplier supplier = new Supplier();
			supplier.setId(rs.getInt("id"));
			supplier.setName(rs.getString("name"));
			supplier.setEmail(rs.getString("email"));
			supplier.setAddress(rs.getString("address"));
			supplier.setPhoneNumber(rs.getString("phoneNumber"));
			list.add(supplier);
		}
		return list;
	}

	public List<Product> getProductbyId(int supplierId) throws Exception {
		ConnectDB connect = new ConnectDB();
		connect.KetNoi();
		String sql = "SELECT * FROM product p inner join supplier s on p.supplierId = s.id where  p.supplierId = ?  ";
		PreparedStatement stmt = connect.cn.prepareStatement(sql);
		stmt.setInt(1, supplierId);
		ResultSet rs = stmt.executeQuery();
		List<Product> list = new ArrayList<>();
		while (rs.next()) {
			Product product = new Product();
			product.setId(rs.getInt("id"));
			product.setName(rs.getString("name"));
			product.setPrice(rs.getBigDecimal("price"));
			product.setSupplierId(rs.getInt("supplierId"));
			list.add(product);
		}
		return list;

	}

	public void addNewProduct(int productId, int quantity) throws Exception {
		ConnectDB connect = new ConnectDB();
		connect.KetNoi();
		String sql = "Insert into WareHouse(productId, quantity) values (?,?)";
		PreparedStatement stmt = connect.cn.prepareStatement(sql);
		stmt.setInt(1, productId);
		stmt.setInt(2, quantity);
		stmt.executeUpdate();
	}

}

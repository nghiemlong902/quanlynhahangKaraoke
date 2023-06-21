package com.dmt.service;

import java.util.List;

import com.dmt.dao.ManagerDao;
import com.dmt.model.Manager;
import com.dmt.model.Product;
import com.dmt.model.Supplier;

public class ManagerService {

	public void addNewManager(String username, String password, String fullName, String email, String phoneNumber,
			String address) throws Exception {
		ManagerDao dao = new ManagerDao();
		dao.addNewManager(username, password, fullName, email, phoneNumber, address);
	}

	public Manager login(String username, String password) throws Exception {
		ManagerDao dao = new ManagerDao();
		return dao.login(username, password);
	}

	public List<Supplier> getAllSuplier() throws Exception {
		ManagerDao dao = new ManagerDao();
		return dao.getAllSuplier();
	}

	public List<Product> getProductbyId(int supplierId) throws Exception {
		ManagerDao dao = new ManagerDao();
		return dao.getProductbyId(supplierId);
	}

	public void addNewProduct(int productId, int quantity) throws Exception {
		ManagerDao dao = new ManagerDao();
		dao.addNewProduct(productId, quantity);
	}

}

package com.dmt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dmt.model.Manager;
import com.dmt.model.Supplier;
import com.dmt.service.ManagerService;

@Controller
public class ManagerController {

	@RequestMapping(value = "/LoginManager", method = RequestMethod.GET)
	public String loginCustomer() {
		return "LoginManager";
	}

	@RequestMapping(value = "/LoginManager", method = RequestMethod.POST)
	public String loginCustomer(@RequestParam("userName") String userName, HttpServletRequest request,
			@RequestParam("pswd") String password) {
		ManagerService service = new ManagerService();
		try {
			Manager manager = service.login(userName, password);
			if (manager == null) {
				request.setAttribute("LoginFail", 1);
				return "LoginManager";
			}
			HttpSession session = request.getSession();
			session.setAttribute("loginPersonM", manager);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/Product";
	}

	@RequestMapping(value = "/Product", method = RequestMethod.GET)
	public String Product() {
		return "Product";
	}

	@RequestMapping(value = "/register-manager", method = RequestMethod.GET)
	public String addNewCustomer() {
		return "RegisterManager";
	}

	@RequestMapping(value = "/register-manager", method = RequestMethod.POST)
	public String addNewCustomer(@RequestParam("userName") String userName, @RequestParam("password") String password,
			@RequestParam("fullName") String fullName, @RequestParam("email") String email,
			@RequestParam("phoneNumber") String phoneNumber, @RequestParam("address") String address,
			HttpServletRequest request) {

		ManagerService service = new ManagerService();
		try {
			service.addNewManager(userName, password, fullName, email, phoneNumber, address);
			request.setAttribute("checkFlag", 1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "redirect:/Home";
	}

	@RequestMapping(value = "/Supplier", method = RequestMethod.GET)
	public String getAllSupplier(HttpServletRequest request) {
		ManagerService service = new ManagerService();
		try {
			List<Supplier> list = service.getAllSuplier();
			request.setAttribute("list", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Supplier";
	}

	@RequestMapping(value = "/SelectProduct", method = RequestMethod.GET)
	public String getProductbyId(HttpServletRequest request, @RequestParam("id") int id) {
		ManagerService service = new ManagerService();
		try {
			List<com.dmt.model.Product> list = service.getProductbyId(id);
			request.setAttribute("list", list);
			request.setAttribute("supplierId", id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "SelectProduct";
	}

	@RequestMapping(value = "/AddProductBySupplier", method = RequestMethod.GET)
	public String AddProductBySupplier(HttpServletRequest request, @RequestParam("productId") int productId) {
		request.setAttribute("productId", productId);
		return "AddProductBySupplier";
	}

	@RequestMapping(value = "/AddProductBySupplier", method = RequestMethod.POST)
	public String AddProductBySupplier(HttpServletRequest request, @RequestParam("productId") int productId,
			@RequestParam("quantity") int quantity) {
		ManagerService service = new ManagerService();
		try {
			service.addNewProduct(productId, quantity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "SuccessAdd";
	}

}

package com.dmt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dmt.model.Customer;
import com.dmt.model.Room;
import com.dmt.service.RoomService;

@Controller
public class CustomerReserve {

	@Autowired
	RoomService roomS;

	@RequestMapping("/CustomerReverse")
	public String voidCustomerReverse(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("loginPerson");
		if (customer != null) {
			try {
				List<Room> list = roomS.getRoombyIdUser(customer.getId());
				System.out.println(list.size());
				request.setAttribute("listCustomerReserve", list);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "CustomerReverse";
		}
		return "CustomerReverse";
	}
}

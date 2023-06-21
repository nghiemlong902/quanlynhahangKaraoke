package com.dmt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dmt.model.Customer;
import com.dmt.model.InvoiceDetail;
import com.dmt.service.InvoiceService;
import com.dmt.service.RoomService;

@Controller
public class InvoiceController {

	@Autowired
	RoomService roomS;

	@RequestMapping("/Reserve")
	public String voidReserve(HttpServletRequest request, @RequestParam("roomId") int roomId) {

		InvoiceService InvoiceS = new InvoiceService();
		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("loginPerson");

		try {
			InvoiceS.addNewInvoice(customer.getId(), roomId);
			roomS.updateStatusRoom(roomId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "redirect:/CustomerReverse";
	}

	@RequestMapping("/ViewInvoice")
	public String viewInvoice(HttpServletRequest request, @RequestParam("userId") int userId) {
		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("loginPerson");
		if (customer != null) {
			InvoiceService InvoiceS = new InvoiceService();

			try {
				List<InvoiceDetail> list = InvoiceS.getInvoicebyId(customer.getId());
				request.setAttribute("listInvoiceDetail", list);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return "ViewInvoice";
		}
		return "ViewInvoice";
	}

}

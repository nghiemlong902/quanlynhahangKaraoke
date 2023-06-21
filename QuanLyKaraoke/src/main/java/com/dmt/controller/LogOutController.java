package com.dmt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogOutController {
	@RequestMapping("/LogOut")
	public String logOut(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("loginPerson") != null) {
			session.removeAttribute("loginPerson");
		}
		if (session.getAttribute("loginPersonE") != null) {
			session.removeAttribute("loginPersonE");
		}
		if (session.getAttribute("loginPersonM") != null) {
			session.removeAttribute("loginPersonM");
		}
		return "Home";
	}

}

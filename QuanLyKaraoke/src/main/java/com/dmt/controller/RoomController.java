package com.dmt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dmt.model.Room;
import com.dmt.service.RoomService;

@Controller
public class RoomController {

	@Autowired
	RoomService roomS;

	@RequestMapping(value = "/show-room", method = RequestMethod.POST)
	public String voidShowRoom(HttpServletRequest request, @RequestParam("dateStart") String startDateString,
			@RequestParam("dateEnd") String endDateString) {
		try {
			List<Room> list = roomS.findAvailableRooms(startDateString, endDateString);
			request.setAttribute("room", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Room";
	}

}

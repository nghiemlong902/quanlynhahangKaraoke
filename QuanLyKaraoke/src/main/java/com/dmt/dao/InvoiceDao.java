package com.dmt.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.dmt.model.InvoiceDetail;

public class InvoiceDao {

	public void addNewInvoice(int customerId, int roomID) throws Exception {
		ConnectDB connect = new ConnectDB();
		connect.KetNoi();
		String sql = "INSERT INTO invoice (customerID, roomId, startDate) VALUES (?, ?, ?)";
		LocalDate localDate = LocalDate.now();
		Date sqlDate = Date.valueOf(localDate);

		PreparedStatement cmd = connect.cn.prepareStatement(sql);
		cmd.setInt(1, customerId);
		cmd.setInt(2, roomID);
		cmd.setDate(3, sqlDate);
		cmd.executeUpdate();
		connect.cn.close();
	}

	public List<InvoiceDetail> getInvoicebyId(int customerId) throws Exception {
		ConnectDB connect = new ConnectDB();
		connect.KetNoi();
		String sql = "select distinct roomNumber, roomType, price, fullName , i.startDate  FROM room r inner join invoice i on r.id = i.roomId inner join customer c on i.customerId = c.id where c.id = ? and available = 0 ";
		PreparedStatement cmd = connect.cn.prepareStatement(sql);
		cmd.setInt(1, customerId);
		ResultSet rs = cmd.executeQuery();
		List<InvoiceDetail> details = new ArrayList<>();
		while (rs.next()) {
			InvoiceDetail detail = new InvoiceDetail();
			detail.setRoomNumber(rs.getString("roomNumber"));
			detail.setRoomType(rs.getString("roomType"));
			detail.setPrice(rs.getBigDecimal("price"));
			detail.setStartDate(rs.getDate("startDate"));
			detail.setFullName(rs.getString("fullName"));
			details.add(detail);
		}
		connect.cn.close();
		return details;
	}

}

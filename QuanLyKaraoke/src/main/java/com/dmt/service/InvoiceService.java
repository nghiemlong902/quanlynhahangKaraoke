package com.dmt.service;

import java.util.List;

import com.dmt.dao.InvoiceDao;
import com.dmt.model.InvoiceDetail;

public class InvoiceService {
	public void addNewInvoice(int customerId, int roomID) throws Exception {
		InvoiceDao dao = new InvoiceDao();
		dao.addNewInvoice(customerId, roomID);
	}

	public List<InvoiceDetail> getInvoicebyId(int customerId) throws Exception {
		InvoiceDao dao = new InvoiceDao();
		return dao.getInvoicebyId(customerId);
	}

}

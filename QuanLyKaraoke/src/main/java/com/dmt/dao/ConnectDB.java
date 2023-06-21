package com.dmt.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {
	private static String DB_URL = "jdbc:mysql://localhost:3307/QuanLyKaraoke";
    private static String USER_NAME = "root";
    private static String PASSWORD = "123456";
	public Connection cn;
	public void KetNoi() throws Exception
	{
		// xac dinh he quan tri co so du lieu
		Class.forName("com.mysql.jdbc.Driver");
    	System.out.println("Da xac dinh");
    	cn= DriverManager.getConnection(DB_URL,USER_NAME, PASSWORD);
    	System.out.println("Da ket noi");
	}
}

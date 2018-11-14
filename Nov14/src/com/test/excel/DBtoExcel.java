package com.test.excel;

import java.sql.Connection;


public class DBtoExcel {

	public static void main(String[] args) {
		
		DBConnection dbcon = new DBConnection();
		Connection conn = dbcon.getConnection();
		
		UserController uc = new UserController(conn);
		ExcelController ec = new ExcelController();
		
		ec.makeExcel(uc.getAllFromUserdata());
		

	}

}

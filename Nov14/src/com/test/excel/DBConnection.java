package com.test.excel;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	public Connection getConnection() {

		Connection conn = null;

		try {
			Class.forName("org.mariadb.jdbc.Driver");

			String url = "jdbc:mariadb://localhost:3306/my_newdb";

			conn = DriverManager.getConnection(url, "test", "test");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;
	}

}

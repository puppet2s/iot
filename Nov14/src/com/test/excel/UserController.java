package com.test.excel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class UserController {
	
	Connection conn = null;

	public UserController(Connection conn) {
		this.conn = conn;
	}
	
	
	ArrayList<HashMap<String, String>> getAllFromUserdata() {
		
		ArrayList<HashMap<String, String>> al = new ArrayList<>();
		
		String sql = "select uidx, id, name, pw, grantaa, tel from userdata ";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				HashMap<String, String> hashMap = new HashMap<>();

				hashMap.put("uidx", rs.getString(1));
				hashMap.put("id", rs.getString(2));
				hashMap.put("name", rs.getString(3));
				hashMap.put("pw", rs.getString(4));
				hashMap.put("grantaa", rs.getString(5));
				hashMap.put("tel", rs.getString(6));
				
				al.add(hashMap);
			}

			pstmt.close();
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return al;
	}
	
	

}

package coding.mentor.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import coding.mentor.db.util.DBUtil;
import coding.mentor.entity.Account;


public class LoginService {
	public Account login(String user, String pass) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String query = "SELECT * FROM be_k4.account where username = ? and password = ?";
			conn = DBUtil.makeConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, user);
			ps.setString(2, pass);
			rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt(1);
				String usernname = rs.getString(2);
				String password = rs.getString(3);
				String email = rs.getString(4);
				
				Account account = new Account(id, usernname, password, email);
				
				return account;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}                     
			if (conn != null) {
				conn.close();
			}
		}
		return null;
	}

}

package coding.mentor.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import coding.mentor.db.util.DBUtil;
import coding.mentor.entity.Account;

public class RegisterService {
	public Account checkAccountExist(String user) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String query = "SELECT * FROM be_k4.account where username = ?";
			conn = DBUtil.makeConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, user);
			rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt(1);
				String user_name = rs.getString(2);
				String password = rs.getString(3);
				String email = rs.getString(4);
				
				Account account = new Account(id, user_name, password, email);
				
				return account;
				
			}
			System.out.println("account");
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
	public void signup(String user, String password, String email) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			String query = "insert into account(username, password, email) values (?,?,?)";
			conn = DBUtil.makeConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, user);
			ps.setString(2, password);
			ps.setString(4, email);
			ps.executeUpdate();
			
		} catch (Exception e) {
			
		}
	}

}

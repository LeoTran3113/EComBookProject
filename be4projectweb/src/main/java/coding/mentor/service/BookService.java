package coding.mentor.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import coding.mentor.db.util.DBUtil;
import coding.mentor.entity.Book;

public class BookService {

	public List<Book> getBooksByCategoryId(int categoryId) throws SQLException {
		// connect to DB
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Book book = null;

		List<Book> list = new ArrayList<Book>();
		try {
			// make connection to mysql
			conn = DBUtil.makeConnection();

			// -> table Category ->
			// Run query "select * from category"
			ps = conn.prepareStatement("SELECT * FROM be_k4.book where category_id =?");
			ps.setInt(1, categoryId);

			// execute and get result SET
			rs = ps.executeQuery();

			// mapping data in result set(IF RESULT SET HAS DATA) into ENTITY CLASS
			// (Category)
			while (rs.next()) {
				// rs.next();
				int id = rs.getInt("id");
				String name = rs.getString("name");

				book = new Book(id, name, categoryId, name, name, id, id);
				list.add(book);
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
		return list;

	}

	public List<Book> getBooksByName(String bookName) throws SQLException {
		// connect to DB
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Book book = null;

		List<Book> list = new ArrayList<Book>();
		try {
			// make connection to mysql
			conn = DBUtil.makeConnection();

			// -> table Category ->
			// Run query "select * from category"
			ps = conn.prepareStatement("SELECT * FROM be_k4.book where name like?");
			ps.setString(1, "%" + bookName + "%");

			// execute and get result SET
			rs = ps.executeQuery();

			// mapping data in result set(IF RESULT SET HAS DATA) into ENTITY CLASS
			// (Category)
			while (rs.next()) {
				// rs.next();
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int categoryId = rs.getInt("category_id");

				book = new Book(id, name, categoryId, name, name, categoryId, categoryId);
				list.add(book);
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
		return list;
	}

	public List<Book> getAllBooks() throws SQLException {
		// connect to DB
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Book book = null;

		List<Book> list = new ArrayList<Book>();
		try {
			// make connection to mysql
			conn = DBUtil.makeConnection();

			// -> table Category ->
			// Run query "select * from category"
			ps = conn.prepareStatement("SELECT * FROM be_k4.book");

			// execute and get result SET
			rs = ps.executeQuery();

			// mapping data in result set(IF RESULT SET HAS DATA) into ENTITY CLASS
			// (Category)
			while (rs.next()) {
				// rs.next();
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int categoryId = rs.getInt("category_id");

				book = new Book(id, name, categoryId, name, name, categoryId, categoryId);
				list.add(book);
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
		return list;
	}

	public List<Book> searchBookByName(String bookSearch) throws SQLException {
		// connect to DB
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Book book = null;

		List<Book> list = new ArrayList<Book>();
		try {
			
			conn = DBUtil.makeConnection();
			ps = conn.prepareStatement("SELECT * FROM be_k4.book where `name` like ?");
			ps.setString(1,"%" + bookSearch + "%");
			rs = ps.executeQuery();

			
			while (rs.next()) {
				// rs.next();
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int categoryId = rs.getInt("category_id");

				book = new Book(id, name, categoryId, name, name, categoryId, categoryId);
				list.add(book);
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
		return list;

	}

	public Book getBookDetails(int bookId) throws SQLException {
		// connect to DB
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Book book = null;

		try {
			// make connection to mysql
			conn = DBUtil.makeConnection();

			// -> table Category ->
			// Run query "select * from category"
			ps = conn.prepareStatement("SELECT * FROM be_k4.book where id = ?");
			ps.setInt(1,bookId);

			// execute and get result SET
			rs = ps.executeQuery();

			// mapping data in result set(IF RESULT SET HAS DATA) into ENTITY CLASS
			// (Category)
			if (rs.next()) {
				// rs.next();
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int categoryId = rs.getInt("category_id");
				String title = rs.getString("title");
				String author = rs.getString("author");
				int stock = rs.getInt("stock");
				int price = rs.getInt("price");
				book = new Book(id, name, categoryId, title, author, stock, price);
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
		return book;
	}
}

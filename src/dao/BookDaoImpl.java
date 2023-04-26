package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import entity.Book;
import exception.BookDaoException;
import exception.NoBookException;
import utility.JDBCConnection;

public class BookDaoImpl implements BookDao {
	static Scanner sc = new Scanner(System.in);

	@Override
	public void insertBooks(Book b) throws BookDaoException {
		// TODO Auto-generated method stub
		Connection connection = null;

		PreparedStatement stmt = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = JDBCConnection.getConnection();
			String s = "insert into books values(?,?,?,?,?,?,?)";
			stmt = connection.prepareStatement(s);
			stmt.setInt(1, b.getId());
			stmt.setString(2, b.getName());
			stmt.setInt(3, b.getRating());
			stmt.setString(4, b.getLanguage());
			stmt.setString(5, b.getCategory());
			stmt.setString(6, b.getAuthor());
			stmt.setInt(7, b.getNoOfCopies());

			int r = stmt.executeUpdate();
			if (r != 0) {
				System.out.println("Values inserted :)");
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new BookDaoException("Sql Exception");

		} finally {

			try {

				connection.close();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	@Override
	public Map<Integer, Book> displayBookByLanguage() {
		// TODO Auto-generated method stub
		Connection connection = null;
		Statement stmt = null;
		Map<Integer, Book> books = new LinkedHashMap<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			connection = JDBCConnection.getConnection();
			Statement s = connection.createStatement();
			ResultSet rs1 = s.executeQuery("select * from books order by language");
			int i = 0;
			while (rs1.next()) {
				books.put(i, new Book(rs1.getInt(1), rs1.getString(2), rs1.getInt(3), rs1.getString(4),
						rs1.getString(5), rs1.getString(6), rs1.getInt(7)));
//				System.out.println("Book Id: " + rs1.getInt(1));
//				System.out.println("Book Name: " + rs1.getString(2));
//				System.out.println("rating: " + rs1.getInt(3));
//				System.out.println("language:  " + rs1.getString(4));
//				System.out.println("category: " + rs1.getString(5));
//				System.out.println("author: " + rs1.getString(6));
//				System.out.println("noofcopies: " + rs1.getInt(7));
				i++;
			}
			// System.out.println(ar);
			rs1.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (connection != null && stmt != null) {
					JDBCConnection.closeDB(connection);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return books;
	}

	@Override
	public void searchBookByAuthorName(String authorName) {
		Connection connection = null;
		Statement stmt = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = JDBCConnection.getConnection();
			Statement s = connection.createStatement();
			ResultSet rs1 = s.executeQuery("select * from books");

			while (rs1.next()) {
				if (rs1.getString(6).equalsIgnoreCase(authorName)) {
					System.out.println("Book Id: " + rs1.getInt(1));
					System.out.println("Book Name: " + rs1.getString(2));
					System.out.println("rating: " + rs1.getInt(3));
					System.out.println("language:  " + rs1.getString(4));
					System.out.println("category: " + rs1.getString(5));
					System.out.println("author: " + rs1.getString(6));
					System.out.println("noofcopies: " + rs1.getInt(7));

				} else {
					try {
						throw new NoBookException();
					} catch (NoBookException e) {
						System.out.println(e.getMessage());
					}
				}
			}
			rs1.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (connection != null && stmt != null) {
					JDBCConnection.closeDB(connection);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void updatCopies() {
		// TODO Auto-generated method stub
		Connection connection = null;
		Statement stmt = null;

		System.out.println("Enter the Book Id:");
		int id = sc.nextInt();
		System.out.println("Enter new no of copies: ");
		int copies = sc.nextInt();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = JDBCConnection.getConnection();
			Statement s = connection.createStatement();
			ResultSet rs1 = s.executeQuery("select * from books");
			String sql = "update books set noofcopies='" + copies + "' where id ='" + id + "'";
			while (rs1.next()) {
				if (rs1.getInt(1) == (id)) {
					Statement s1 = connection.createStatement();

					s1.executeUpdate(sql);
				} else {
					try {
						throw new NoBookException();
					} catch (NoBookException e) {
						System.out.println(e.getMessage());
					}
				}
			}
			rs1.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (connection != null && stmt != null) {
					JDBCConnection.closeDB(connection);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void displayAllBooksDetails() {
		Connection connection = null;
	
		//Map<Integer, Book> books = new LinkedHashMap<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			connection = JDBCConnection.getConnection();
			String query="{CALL GetAllProducts()}";
			CallableStatement s = connection.prepareCall(query);
			ResultSet rs1 = s.executeQuery();
			//int i = 0;
			while (rs1.next()) {
			//	books.put(i, new Book(rs1.getInt(1), rs1.getString(2), rs1.getInt(3), rs1.getString(4),
				//		rs1.getString(5), rs1.getString(6), rs1.getInt(7)));
				System.out.println("Book Id: " + rs1.getInt(1));
				System.out.println("Book Name: " + rs1.getString(2));
				System.out.println("rating: " + rs1.getInt(3));
				System.out.println("language:  " + rs1.getString(4));
				System.out.println("category: " + rs1.getString(5));
				System.out.println("author: " + rs1.getString(6));
				System.out.println("noofcopies: " + rs1.getInt(7));
		//		i++;
			}
			// System.out.println(ar);
			rs1.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (connection != null) {
					JDBCConnection.closeDB(connection);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}

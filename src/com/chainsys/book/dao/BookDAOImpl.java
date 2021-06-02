package com.chainsys.book.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.chainsys.book.exception.BookNotFoundException;
import com.chainsys.book.model.Book;

public class BookDAOImpl implements BookDAO {
	private static Connection con;
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	private static Set<Book> bookset;
	
	public BookDAOImpl() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.20:1521:DBEBS12", "apps", "apps");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	public Set<Book> findAll(){
	try {
	pstmt=con.prepareStatement("select * from book_2596");
	rs=pstmt.executeQuery();
	bookset=new HashSet<>();
	while(rs.next()) {
		Book book = new Book(rs.getInt("BId"),rs.getString("BName"),rs.getDate("publisherdate").toLocalDate());
		bookset.add(book);
	}
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return bookset;
	}
	
	public Book findById(int BId) {
		Book book = null;
		try {
			pstmt=con.prepareStatement("select * from book_2596 where BId=?");
			pstmt.setInt(1, BId);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				book = new Book(rs.getInt("BId"),rs.getString("BName"),rs.getDate("publisherdate").toLocalDate());
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return book;
	}
	
	public void save(Book book) {
		try {
			pstmt=con.prepareStatement("insert into book_2596 values (?,?,?)");
			pstmt.setInt(1,book.getBId());
			pstmt.setString(2,book.getBName());
			pstmt.setDate(3,Date.valueOf(book.getpublisherdate()));
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void update(Book book) {
		try {
			pstmt=con.prepareStatement("update book_2596 set BId=?,BName=?");
			pstmt.setInt(1, book.getBId());
			pstmt.setString(2, book.getBName());
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void delete(int BId) {
		try {
			pstmt=con.prepareStatement("delete book_2596 where BId=?");
			pstmt.setInt(1, BId);
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}

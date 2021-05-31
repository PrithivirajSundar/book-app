package com.chainsys.book.service;

import java.util.Set;

import com.chainsys.book.dao.BookDAO;
import com.chainsys.book.dao.BookDAOImpl;
import com.chainsys.book.exception.BookNotFoundException;
import com.chainsys.book.model.Book;

public class BookServiceImpl implements BookService{
	private static BookDAO dao;
	public BookServiceImpl() {
		dao=new BookDAOImpl();
	}
	public Set<Book> findAll(){
		return dao.findAll();
	}
	
	public Book findById(int BId) throws BookNotFoundException{
		Book book = dao.findById(BId);		
		if(book == null) {
			throw new BookNotFoundException("Book id not found");
		}
		else {
			return book;
		}
	}
	public void save(Book book) {
		dao.save(book);
	}
	
	public void update(Book book) throws BookNotFoundException {
		Book book1 = dao.findById(book.getBId());
		if(book1==null) {
			throw new BookNotFoundException("book id not found");
		}else {
			dao.update(book);
		}
		
	}
	public void delete(int BId) throws BookNotFoundException{
		Book book = dao.findById(BId);
		if(book == null) {
			throw new BookNotFoundException("book id not found");
		}else {
			dao.delete(BId);
		}
		
	}

}

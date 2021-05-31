package com.chainsys.book.service;

import java.util.Set;

import com.chainsys.book.exception.BookNotFoundException;
import com.chainsys.book.model.Book;

public interface BookService {
	Set<Book> findAll();
	Book findById(int BId) throws BookNotFoundException;
	void save(Book book);
	void update(Book book) throws BookNotFoundException;
	void delete(int BId) throws BookNotFoundException;

	

	

}

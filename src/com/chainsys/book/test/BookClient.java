package com.chainsys.book.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Set;

import com.chainsys.book.exception.BookNotFoundException;
import com.chainsys.book.model.Book;
import com.chainsys.book.service.BookService;
import com.chainsys.book.service.BookServiceImpl;

public class BookClient {
	public static void main(String[] args) {
		Set<Book> bookset;
		int BId;
		String date;
		DateTimeFormatter dateFormat;
		BookService service = new BookServiceImpl();
		System.out.println("Enter your choice");
		Scanner scanner = new Scanner(System.in);
		int choice=scanner.nextInt();
		switch(choice) {
		case 1:
			System.out.println("Find All book");
			bookset = service.findAll();
			System.out.println(bookset);
			break;
			
		case 2:
			System.out.println("Find book by id");
			System.out.println("Enter the book id");
			BId=scanner.nextInt();
			try {
			Book book =service.findById(BId);
			System.out.println(book);
			}catch(BookNotFoundException e) {
				System.out.println(e);
			}
			break;
			
		case 3:
			System.out.println("Adding new book");
			date="06/25/1999";
			dateFormat=DateTimeFormatter.ofPattern("MM/dd/yyyy");
			Book book = new Book(1003,"success",LocalDate.parse(date,dateFormat));
			service.save(book);
			bookset=service.findAll();
			System.out.println(bookset);
			break;
////			
		case 4:
			System.out.println("Update book name based on book id");
			date="06/25/1999";
			dateFormat=DateTimeFormatter.ofPattern("MM/dd/yyyy");
			Book book1 = new Book(1000,"THE LION KING",LocalDate.parse(date,dateFormat));
		try {
			service.update(book1);
			bookset=service.findAll();
			System.out.println(bookset);
		    }catch(BookNotFoundException e) {
			System.out.println(e);		
			}
		break;
		case 5:
			System.out.println("delete book based on book id");
			System.out.println("enter book id:");
			BId=scanner.nextInt();
			try {
				service.delete(BId);
				bookset=service.findAll();
				System.out.println(bookset);
			}catch(BookNotFoundException e) {
				System.out.println(e);
			}
		break;
	}

}
}

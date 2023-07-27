package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Book;
import com.example.demo.models.CreateBook;
import com.example.demo.repositories.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	public Book saveBook(CreateBook createBook) {
		Book book=new Book();
		book.setBookName(createBook.getBookName());
		book.setBookAuthor(createBook.getBookAuthor());
		book.setBookPrice(createBook.getBookPrice());
		
		return this.bookRepository.save(book);
	}
	
	public void deleteBook(Long id) {
		this.bookRepository.deleteById(id);
	}
	
	public Book getBookById(Long id) {
		return this.getBookById(id);
	}

}

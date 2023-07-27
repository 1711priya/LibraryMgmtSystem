package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Book;
import com.example.demo.models.CreateBook;
import com.example.demo.services.BookService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@PostMapping("/addBook")
	public ResponseEntity<?> addBook(@RequestBody @Valid CreateBook createBook){
		Book book=bookService.saveBook(createBook);
		return new ResponseEntity<>(book,HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public Book getBookById(@PathVariable Long id) {
		return this.bookService.getBookById(id);
	}
	
	@DeleteMapping("{/id}")
	public void deleteBookById(@PathVariable Long id) {
		this.bookService.deleteBook(id);
	}

}

package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.example.demo.models.Book;

public interface BookRepository extends CrudRepository<Book, Long>{
	
	@RestResource(exported = false)
	public Optional<Book> findByBookName(String bookName);

}

package com.example.demo.models;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateBook {

	@Size(min=3)
	private String bookName;
	@NotNull
	@Size(min=3)
	private String bookAuthor;
	@NotNull
	private double bookPrice;
	
	public CreateBook() {
		super();
	}

	public CreateBook(@Size(min = 3) String bookName, @NotNull @Size(min = 3) String bookAuthor,
			@NotNull double bookPrice) {
		super();
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookPrice = bookPrice;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}
}

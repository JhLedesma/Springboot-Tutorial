package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Book {
	private String isbn;
	private String title;
	private String author;
	private String publisher;
	private String publishedDate;
	private String category;
}

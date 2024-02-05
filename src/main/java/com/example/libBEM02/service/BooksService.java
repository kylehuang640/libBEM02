package com.example.libBEM02.service;

import java.util.List;

import com.example.libBEM02.dto.BooksDto;
import com.example.libBEM02.entity.Books;

public interface BooksService {
	
	public BooksDto findByBookName(String BookName);
	
	public List<Books> findAll();
	
	public BooksDto insertBook(Integer id,BooksDto bd);
	
	public void deleteBook(Integer ID);

    public BooksDto updateBook(Integer id, BooksDto bookDto);
}

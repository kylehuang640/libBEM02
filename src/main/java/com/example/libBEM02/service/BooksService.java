package com.example.libBEM02.service;

import com.example.libBEM02.dto.BooksDto;

public interface BooksService {
	
	public BooksDto findByBookName(String BookName);
	
	public BooksDto insertBook(BooksDto bd);
	
	public void deleteBook(Integer ID);

    public BooksDto updateBook(Integer id, BooksDto bookDto);
}

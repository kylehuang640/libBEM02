package com.example.libBEM02.service;

import java.util.List;

import com.example.libBEM02.dto.BooksDto;
import com.example.libBEM02.entity.Books;

public interface BooksService {
	
	public BooksDto findByBookName(String BookName);
	
	public List<BooksDto> findAll();
	
	public BooksDto insertBook(BooksDto bd);
	
	public void deleteBook(Integer ID);

    public BooksDto updateBook(Integer id, BooksDto bookDto);
    
}

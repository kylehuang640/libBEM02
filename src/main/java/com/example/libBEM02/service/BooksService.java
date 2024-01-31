package com.example.libBEM02.service;

import java.util.List; 
import java.util.Optional;
import com.example.libBEM02.dto.BooksDto;
import com.example.libBEM02.entity.Books;

public interface BooksService {
	
	public BooksDto findByBookName(String BookName);
	
	public BooksDto insertBook(BooksDto bd);
	
	public void deleteBook(Integer ID);

    public Books updateBook(Books book);
    
//    //convert
//    private BooksDto convertToDto(Books books);
//    private Books convertToEntity(BooksDto booksDto);
}

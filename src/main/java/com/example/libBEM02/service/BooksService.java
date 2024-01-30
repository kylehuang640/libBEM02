package com.example.libBEM02.service;

import java.util.List;
import java.util.Optional;

import com.example.libBEM02.entity.Books;

public interface BooksService {
	
	public List<Books> findByBookName(String BookName);
	
	public Books insertBook(Books book);
	
	public void deleteBook(Integer ID);

    public Books updateBook(Books book);

}

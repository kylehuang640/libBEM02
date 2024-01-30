package com.example.libBEM02.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.libBEM02.entity.Books;
import com.example.libBEM02.repositories.BooksRepository;
import com.example.libBEM02.service.BooksService;

@Service
public class BooksServiceImpl implements BooksService{

	@Autowired
	BooksRepository booksRepository;
	
	@Override
	public Optional<Books> findByID(Integer ID){
		return booksRepository.findById(ID);
	}
	@Override
	public Books insertBook(Books book) {
		return booksRepository.save(book);
	}
	@Override
	public void deleteBook(Integer ID) {
        booksRepository.deleteById(ID);
    }
	@Override
    public Books updateBook(Books book) {
        return booksRepository.save(book);
    }
    
}

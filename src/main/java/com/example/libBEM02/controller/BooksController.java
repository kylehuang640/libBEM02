package com.example.libBEM02.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.libBEM02.entity.Books;
import com.example.libBEM02.service.BooksService;

@RestController
@RequestMapping
public class BooksController {
	
	@Autowired
	BooksService booksService;
	
	@RequestMapping("/getBook")
	public List<Books> getBook() {
		return booksService.findByBookName("In The Sea");
	}
	@DeleteMapping("/deleteBook")
	public void deleteBooks(Integer id){
		booksService.deleteBook(id);
	}
	
	
}

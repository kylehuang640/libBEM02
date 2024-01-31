package com.example.libBEM02.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.libBEM02.dto.BooksDto;
import com.example.libBEM02.entity.Books;
import com.example.libBEM02.service.BooksService;

@RestController
@RequestMapping
public class BooksController {
	
	@Autowired
	BooksService booksService;
	
	//request
	@RequestMapping("/getBook")
	public BooksDto getBook() {
		return booksService.findByBookName("In The Sea");
	}
	//Delete
	@DeleteMapping("/deleteBook")
	public void deleteBooks(Integer id){
		booksService.deleteBook(id);
	}
	//Create
	@PostMapping("/create")
	public ResponseEntity<BooksDto> insertBook(@RequestBody BooksDto bd) {
		BooksDto saveBd = booksService.insertBook(bd);
		return new ResponseEntity<>(saveBd, HttpStatus.CREATED);
	}
}

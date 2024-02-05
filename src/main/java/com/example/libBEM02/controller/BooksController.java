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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.libBEM02.dto.BooksDto;
import com.example.libBEM02.entity.Books;
import com.example.libBEM02.exception.ResourceNotFoundException;
import com.example.libBEM02.repositories.BooksRepository;
import com.example.libBEM02.service.BooksService;

@RestController
@RequestMapping("/Book")
public class BooksController {
	
	@Autowired
	BooksService booksService;
	
//	//request
//	@RequestMapping("/getBook")
//	public BooksDto getBook() {
//		return booksService.findByBookName("In The Sea");
//	}
	
	//Request Test 
    @RequestMapping("/getBook/{bookname}")
    public ResponseEntity<BooksDto> get(@PathVariable String bookname){
    	BooksDto books = booksService.findByBookName(bookname);
    	return new ResponseEntity<>(books, HttpStatus.OK);
    }
    
	//Delete
	@DeleteMapping("/deleteBook")
	public ResponseEntity<String> deleteBooks(Integer id){
		booksService.deleteBook(id);
		return ResponseEntity.ok("Delete Success!");
	}
	//Create
	@PostMapping("/createBook")
    public ResponseEntity<BooksDto> createBook(@RequestBody BooksDto bookDto) {
        BooksDto createdBook = booksService.insertBook(bookDto);
        return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
    }
	//update
    @PutMapping("/update/{id}")
    public ResponseEntity<BooksDto> updateBook(@PathVariable Integer id, @RequestBody BooksDto bookDto) {
    	BooksDto updateB = booksService.updateBook(id, bookDto);
        booksService.updateBook(id, bookDto);
        return ResponseEntity.ok(updateB);
    }
    
}

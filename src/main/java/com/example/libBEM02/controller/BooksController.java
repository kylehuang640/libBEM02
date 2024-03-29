package com.example.libBEM02.controller;

import java.util.List;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.libBEM02.dto.BooksDto;
import com.example.libBEM02.exception.ResourceNotFoundException;
import com.example.libBEM02.service.BooksService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@CrossOrigin
@RestController
@RequestMapping("/book")
public class BooksController {
	
	@Autowired
	BooksService booksService;
	
	//Request Test 
    @GetMapping("/get/{bookname}")
    public ResponseEntity<BooksDto> get(@PathVariable String bookname){
    	BooksDto books = booksService.findByBookName(bookname);
    	return new ResponseEntity<>(books, HttpStatus.OK);
    }
	
	//Request all data
    @GetMapping("/get/All")
    public ResponseEntity<List<BooksDto>> findAll(){
    	List<BooksDto> books = booksService.findAll();
    	return new ResponseEntity<>(books, HttpStatus.OK);
    }
    
	//Delete
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteBooks(Integer id){
		booksService.deleteBook(id);
		return new ResponseEntity<>("Book was successfully deleted!", HttpStatus.OK);
	}
	//Create
	@PostMapping("/create")
    public ResponseEntity<BooksDto> createBook(@RequestBody BooksDto bookDto) {
        BooksDto bk = booksService.insertBook(bookDto);
        return new ResponseEntity<>(bk, HttpStatus.CREATED);
    }
	//update
    @PutMapping("/update/{id}")
    public ResponseEntity<BooksDto> updateBook(@PathVariable Integer id, @RequestBody BooksDto bookDto) {
    	BooksDto updateB = booksService.updateBook(id, bookDto);
        booksService.updateBook(id, bookDto);
        return new ResponseEntity<>(updateB, HttpStatus.OK);
    }
    
}

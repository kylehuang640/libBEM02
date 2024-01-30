package com.example.libBEM02.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.libBEM02.entity.Books;
import com.example.libBEM02.service.BooksService;

@Controller
@RequestMapping
public class BooksController {
	
	@Autowired
	BooksService booksService;
	
	@RequestMapping("/getBook")
	public Optional getBook() {
		return booksService.findByID(1);
	}
	
	
}

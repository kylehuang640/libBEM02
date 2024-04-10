package com.example.libBEM02.service.impl;

import java.util.ArrayList;
import java.util.List;  
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.libBEM02.exception.ResourceNotFoundException;
import com.example.libBEM02.dto.BooksDto;
import com.example.libBEM02.entity.Books;
import com.example.libBEM02.repositories.BooksRepository;
import com.example.libBEM02.service.BooksService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class BooksServiceImpl implements BooksService{

	@Autowired
	BooksRepository booksRepository;
	
	@Override
	public BooksDto findByBookName(String BookName){
		Books books = booksRepository.findByBookName(BookName);
		return convertToDto(books);
	}
	
	@Override
	public List<BooksDto> findAll(){
		List<BooksDto> bk = convertListToDto(booksRepository.findAll());
		return bk;
	}
	
	@Override
	public BooksDto insertBook(BooksDto bd) {
		
		Books books = new Books();
		books.setID(bd.getID());
		books.setBookName(bd.getBookName());
		books.setAuthor(bd.getAuthor());
		books.setDescription(bd.getDescription());
		books.setListPrice(bd.getListPrice());
		books.setSellPrice(bd.getSellPrice());
		
		Books saveBk = booksRepository.save(books);
		return convertToDto(saveBk);
	}
	@Override
	public void deleteBook(Integer ID) {
        booksRepository.deleteById(ID);
    }
	@Override
    public BooksDto updateBook(Integer id, BooksDto bookDto) {
		Books existingBook = booksRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("cannot find the book which ID: " + id ));
        // update according to the needs
		existingBook.setID(bookDto.getID());
        existingBook.setBookName(bookDto.getBookName());
        existingBook.setAuthor(bookDto.getAuthor());
        existingBook.setDescription(bookDto.getDescription());
        existingBook.setListPrice(bookDto.getListPrice());
        existingBook.setSellPrice(bookDto.getSellPrice());
        booksRepository.save(existingBook);
        
        BooksDto b = convertToDto(existingBook);
        return b;
    }
	
	//convert-------------------------------------------
	//turn entity into dto
	private BooksDto convertToDto(Books books) {
		BooksDto bd = new BooksDto();
		bd.setID(books.getID());
		bd.setBookName(books.getBookName());
		bd.setAuthor(books.getAuthor());
		bd.setDescription(books.getDescription());
		bd.setListPrice(books.getListPrice());
		bd.setSellPrice(books.getSellPrice());
		return bd;
	};
	//turn dto into entity
    private Books convertToEntity(BooksDto booksDto) {
    	Books bk = new Books();
    	bk.setID(booksDto.getID());
    	bk.setBookName(booksDto.getBookName());
    	bk.setAuthor(booksDto.getAuthor());
    	bk.setDescription(booksDto.getDescription());
    	bk.setListPrice(booksDto.getListPrice());
    	bk.setSellPrice(booksDto.getSellPrice());
    	return bk;
    };
    //turn entity list into dto list
    private List<BooksDto> convertListToDto(List<Books> bk){
    	List<BooksDto> ret = new ArrayList(); 
    	for( Books b : bk) {
    		ret.add(convertToDto(b));
    	}
    	return ret;
    }
}

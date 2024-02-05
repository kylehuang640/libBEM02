package com.example.libBEM02.repositories;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.libBEM02.dto.BooksDto;
import com.example.libBEM02.entity.Books;

@Repository
public interface BooksRepository extends JpaRepository<Books, Integer>{
	@Query(value = "SELECT * FROM Books b WHERE b.BookName = :BookName" ,nativeQuery = true)
	Books findByBookName(@Param("BookName") String BookName);
	
//	@Query(value = "SELECT ID FROM Books WHERE ID = (SELECT MAX(ID) FROM Books)", nativeQuery = true)
//	Integer findMaxId();
	
}

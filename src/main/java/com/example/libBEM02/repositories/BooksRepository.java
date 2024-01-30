package com.example.libBEM02.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.libBEM02.entity.Books;

@Repository
public interface BooksRepository extends JpaRepository<Books, Integer>{

}

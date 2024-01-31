package com.example.libBEM02.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class BooksDto {
	private Integer ID;
	private String BookName;
	private String Author;
	private String Description;
	private Double ListPrice;
	private Double SellPrice;
}

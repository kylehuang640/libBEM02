package com.example.libBEM02.dto;

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

package com.example.libBEM02.entity;

import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter
@Table(name = "Books")
@ToString
public class Books extends Base{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer ID;
	@Column(name = "BookName")
	private String BookName;
	@Column(name = "Author")
	private String Author;
	@Column(name = "Description")
	private String Description;
	@Column(name = "ListPrice" , precision = 10, scale = 2)
	private BigDecimal ListPrice;
	@Column(name = "SellPrice" , precision = 10, scale = 2)
	private BigDecimal SellPrice;
	
}

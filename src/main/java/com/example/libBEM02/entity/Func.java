package com.example.libBEM02.entity;

import jakarta.persistence.Column; 

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@Entity
@Getter @Setter
@Table(name = "Func")
@ToString
public class Func {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer ID;
	@Column(name = "Name")
	private String Name;
	@Column(name = "Description")
	private String Description;
	@Column(name = "Type")
	private String Type;
	
}

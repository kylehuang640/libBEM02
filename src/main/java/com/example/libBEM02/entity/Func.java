package com.example.libBEM02.entity;

import javax.persistence.Column;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@Entity
@Getter @Setter
@Table(name = "Func")
@ToString
public class Func extends Base{
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
	
	
//	public int getID() {
//		return ID;
//	}
//	public void setID(int ID) {
//		this.ID = ID;
//	}
//	public String getName() {
//		return Name;
//	}
//	public void setName(String Name) {
//		this.Name = Name;
//	}
//	public String getDescription() {
//		return Description;
//	}
//	public void  setDesciption(String Description) {
//		this.Description = Description;
//	}
//	public String getType() {
//		return Type;
//	}
//	public void setType(String Type) {
//		this.Type = Type;
//	}
}

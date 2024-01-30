package com.example.libBEM02.entity;

import jakarta.persistence.*; 

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Entity
@Getter @Setter
@Table(name = "Role")
@ToString
public class Role extends Base{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer ID;
	@Column(name = "Title")
	private String Title;
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
//	public String getTitle() {
//		return Title;
//	}
//	public void setTitle(String Title) {
//		this.Title = Title;
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

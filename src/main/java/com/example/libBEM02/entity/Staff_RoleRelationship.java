//package com.example.libBEM02.entity;
//
//import jakarta.persistence.*; 
//
//import jakarta.persistence.Transient;
//
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.JoinColumn;
//
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;
//
//@Entity
//@Getter @Setter
//@Table(name = "Staff_RoleRelationship")
//@ToString
//public class Staff_RoleRelationship {
//	
//	@Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer ID;
//	
//    @ManyToOne
//    @JoinColumn(name = "staffID")
//    private Staff staff;
//
//    @ManyToOne
//    @JoinColumn(name = "roleID")
//    private Role role;
//}

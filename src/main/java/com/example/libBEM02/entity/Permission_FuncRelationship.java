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
//@Table(name = "Permission_FuncRelationship")
//@ToString
//public class Permission_FuncRelationship {
//	
//	@Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer ID;
//
//	
//    @ManyToOne
//    @JoinColumn(name = "funcID", nullable = false)
//    private Role role;
//
//    @ManyToOne
//    @JoinColumn(name = "permissionID", nullable = false)
//    private Permission permission;
//
//}

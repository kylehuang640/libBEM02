package com.example.libBEM02.entity;

import java.util.Date; 

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Base {
	
	@CreatedBy
	@Column(name = "CREATE_BY")
	private String create_by;

	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_TIME")
	private Date create_time;

	@LastModifiedBy
	@Column(name = "UPDATE_BY")
	private String update_by;

	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATE_TIME")
	private Date update_time;
	
}

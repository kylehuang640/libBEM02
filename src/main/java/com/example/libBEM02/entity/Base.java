package com.example.libBEM02.entity;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.ToString;

@ToString
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Base{
	//originally i set this as CREATED_BY or sth else, but I did not use this in my program, so I canceled this.
	//Then, I tried to turn this into sth like UserDetailsService, and implement UserDetails, but it turns out to be useless and may have some issue in it.
	//So it became nothing in this page.
}

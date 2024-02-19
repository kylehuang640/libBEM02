package com.example.libBEM02.security.Token;

import com.example.libBEM02.entity.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Token {
	@Id
    @GeneratedValue
    @Column(name = "tokenId")
    public Integer id;

    @Column(name = "Token")
    public String token;

    @Enumerated(EnumType.STRING)
    @Column(name = "TokenType")
    public TokenType tokenType = TokenType.BEARER;
    
    @Column(name = "Revoked")
    public boolean revoked;
    @Column(name = "Expired")
    public boolean expired;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id")
    public User user;
}

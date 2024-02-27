package com.example.libBEM02.security.Token;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<Token, Integer>{
	@Query(value = "select t from Token t inner join User u on t.userId = u.ID where u.ID = :ID and (t.Expired = false or t.Revoked false)",nativeQuery = true)
    List<Token> findAllValidTokenByUser(@Param("ID") Integer id);

    Optional<Token> findByToken(String token);
}

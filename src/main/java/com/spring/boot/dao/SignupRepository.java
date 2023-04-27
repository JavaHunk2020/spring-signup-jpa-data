package com.spring.boot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignupRepository extends JpaRepository<SignupEntity, String>{
	
	public SignupEntity findByUsername(String username);

}

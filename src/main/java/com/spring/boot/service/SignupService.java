package com.spring.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.dao.SignupEntity;
import com.spring.boot.dao.SignupRepository;

//new SignupService()
@Service
public class SignupService {
	
	@Autowired
	private SignupRepository signupRepository; 
	
	//From where it is coming ?????
	//Step-1 pom.xml  - >>	<artifactId>spring-boot-starter-jdbc</artifactId>
	//step-2 application.properties -
	//spring.datasource.url=jdbc:mysql://localhost:3306/batch100_db
	//@Autowired
	//private DataSource dataSource;
	
	
	public void deleteByUsername(String username) {
	    	signupRepository.deleteById(username);
	}
	
	
	public SignupEntity findByUsername(String username) {
		///JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		//String fecthData = "select username, password , email,gender from signups_tbl where username = ?";
		SignupEntity signupEntity=signupRepository.findByUsername(username);
		return signupEntity;
	}
	
	public List<SignupEntity> findAll() {
	//	JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	//	String fecthData = "select username, password , email,gender from signups_tbl";
		List<SignupEntity> signupEntities=signupRepository.findAll();
		return signupEntities;
	}

	
	public void update(SignupEntity signupEntity) {
		// jdbcTemplate says I will make your jdbc programming super duper easy
		//JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		//String sql = "update signups_tbl set password =?, email=? ,gender= ? where username = ?";
		//Object[] data = { signupDTO.getPassword(), signupDTO.getEmail(),
			//	signupDTO.getGender(),signupDTO.getUsername() };
		signupRepository.save(signupEntity);
	}
	public void save(SignupEntity signupEntity) {
		// jdbcTemplate says I will make your jdbc programming super duper easy
		signupRepository.save(signupEntity);
	}

}

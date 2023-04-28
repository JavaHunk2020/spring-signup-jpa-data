package com.spring.boot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.dao.SignupEntity;
import com.spring.boot.dao.SignupRepository;
import com.spring.boot.dto.SignupDTO;

//new SignupService()
@Service
public class SignupService {
	
	@Autowired
	private SignupRepository signupRepository; 
	
	public void deleteByUsername(String username) {
	    	signupRepository.deleteById(username);
	}
	
	
	public SignupDTO findByUsername(String username) {
		SignupEntity entity=signupRepository.findByUsername(username);
		SignupDTO signupDTO=new SignupDTO();
		BeanUtils.copyProperties(entity, signupDTO);
		return signupDTO;
	}
	
	public List<SignupDTO> findAll() {
		List<SignupEntity> signupEntities=signupRepository.findAll();
		
		List<SignupDTO> signupDTOs=new ArrayList<SignupDTO>();
		for(SignupEntity entity : signupEntities) {
			SignupDTO signupDTO=new SignupDTO();
			BeanUtils.copyProperties(entity, signupDTO);
			signupDTOs.add(signupDTO);
		}
		return signupDTOs;
	}

	public void saveOrUpdate(SignupDTO signupDTO) {
		// jdbcTemplate says I will make your jdbc programming super duper easy
		SignupEntity signupEntity=new SignupEntity();
		BeanUtils.copyProperties(signupDTO, signupEntity);
		signupRepository.save(signupEntity);
	}

}

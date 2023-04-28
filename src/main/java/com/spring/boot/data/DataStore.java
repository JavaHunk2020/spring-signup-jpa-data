package com.spring.boot.data;

import java.util.ArrayList;
import java.util.List;

import com.spring.boot.dto.SignupDTO;

public class DataStore {

	static private List<SignupDTO> signupDTOs=new ArrayList<SignupDTO>();

	public static List<SignupDTO> getSignupDTOs() {
		return signupDTOs;
	}

}

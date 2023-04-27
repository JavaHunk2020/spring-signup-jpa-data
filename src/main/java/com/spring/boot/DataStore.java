package com.spring.boot;

import java.util.ArrayList;
import java.util.List;

import com.spring.boot.dao.SignupEntity;

public class DataStore {

	static private List<SignupEntity> signupDTOs=new ArrayList<SignupEntity>();

	public static List<SignupEntity> getSignupDTOs() {
		return signupDTOs;
	}

}

package com.api.base;

import java.util.HashMap;

import io.restassured.response.Response;

public class AuthenticationBase extends baseService {
	
	private static final String BASE_PATH="/api/auth/";
	
	public Response login(Object payload) {
		return postRequest(payload, BASE_PATH+"login");
	}
	
	public Response SignUP(Object payload) {
		return postRequest(payload, BASE_PATH+"signup");
	}

	public Response forgotPassword(String emailaddress) {
		// create payload with key value using hashmap
		HashMap<String, String> payload= new HashMap<String, String>();
		payload.put("email", emailaddress);
		return postRequest(payload, BASE_PATH+"forgot-password");
	}

}

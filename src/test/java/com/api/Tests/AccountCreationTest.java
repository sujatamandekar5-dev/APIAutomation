package com.api.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthenticationBase;
import com.api.models.Request.SignUpRequest;

import  io.restassured.response.Response;

public class AccountCreationTest {
	@Test (description = "Verify user account creation api is  working...")
	public void CreateAccountTest()
	{
	
	AuthenticationBase authBase= new AuthenticationBase();
	

	SignUpRequest signuprequest=new SignUpRequest.Builder().username("ishita1234")
			.password("iujata1234")
			.email("ishita123@gmail.com")
			.firstName("Ishitha")
			.lastName("Mandekar")
			.mobileNumber("8797654467").build();
	  Response responce= authBase.SignUP(signuprequest);
	  Assert.assertEquals(responce.statusCode(), 200);
	  System.out.println("resp= "+responce.asPrettyString());
	 Assert.assertEquals(responce.asPrettyString(),"User registered successfully!");
	  
	}
	
}

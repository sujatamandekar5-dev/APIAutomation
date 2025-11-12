package com.api.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthenticationBase;
import com.api.models.Request.LoginRequest;
import com.api.models.Responce.LoginResponce;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class LoginTest {
	
	@Test (description = "verify if login api is working...")
	public void testLogin() {
		LoginRequest loginrequest= new LoginRequest("uday123", "uday123");
	 AuthenticationBase authService= new AuthenticationBase();
		
		Response responce= authService.login(loginrequest);
		LoginResponce loginresponce= responce.as(LoginResponce.class); // convert json responce to java object 
				
		System.out.println("Responce: "+ responce.asPrettyString());
		
		System.out.println("Token: "+ loginresponce.getToken());
		System.out.println("Email: "+ loginresponce.getEmail());	 
		System.out.println("ID: "+ loginresponce.getId());
		System.out.println("Role: "+ loginresponce.getRoles());
		Assert.assertEquals(responce.getStatusCode(), 200);
		Assert.assertTrue(loginresponce.getToken()!=null);
		Assert.assertEquals(loginresponce.getEmail(),"dontNo@yahoo.com");
		Assert.assertEquals(loginresponce.getId(),305);
		
	}

}

package com.api.Tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthenticationBase;
import com.api.base.userProfileManagementService;
import com.api.models.Request.LoginRequest;
import com.api.models.Responce.LoginResponce;
import com.api.models.Responce.UserProfileResponce;

import io.restassured.response.Response;

@Listeners (src.com.listerners.testListeners.class)
public class GetProfileRequestTest {
	@Test (description = "Verify user profile details api is working..")
	public void getProfileInfo() {
		AuthenticationBase authBase= new AuthenticationBase();
		// first need to ;ogin and get token
		Response responce= authBase.login(new LoginRequest("uday123", "uday123"));
		
		LoginResponce loginresponce=responce.as(LoginResponce.class);		
		System.out.println("Token: "+loginresponce.getToken()); // we get token from here 
		
		userProfileManagementService userprofilemanagementservice= new userProfileManagementService();
		responce=userprofilemanagementservice.profile(loginresponce.getToken());
		
		System.out.println(responce.asPrettyString());
		
		UserProfileResponce userprofileresponce=responce.as(UserProfileResponce.class);
		System.out.println(userprofileresponce.getUsername());
		System.out.println(userprofileresponce.getEmail());
		System.out.println(userprofileresponce.getId());
		System.out.println(userprofileresponce.getFirstName());
		System.out.println(userprofileresponce.getLastName());
		System.out.println(userprofileresponce.getMobileNumber());
		
		Assert.assertEquals(userprofileresponce.getUsername(), "uday123");
		Assert.assertEquals(userprofileresponce.getEmail(), "dontNo@yahoo.com");
		Assert.assertEquals(userprofileresponce.getId(), 305);
		Assert.assertEquals(userprofileresponce.getFirstName(), "Sharma");
		Assert.assertEquals(userprofileresponce.getLastName(), "Disha");
		Assert.assertEquals(userprofileresponce.getMobileNumber(), "7777777778");
		
	}
	
}

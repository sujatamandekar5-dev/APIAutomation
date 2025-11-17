package com.api.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthenticationBase;
import com.api.base.userProfileManagementService;
import com.api.models.Request.LoginRequest;
import com.api.models.Request.ProfileRequest;
import com.api.models.Responce.LoginResponce;
import com.api.models.Responce.UserProfileResponce;

import io.restassured.response.Response;

public class UpdateProfileTest {

	@Test(description = "Verify update profile api is working....")
	public void UpdateProfileInfo() {
		AuthenticationBase authBase= new AuthenticationBase();
		// first need to ;ogin and get token
		Response responce= authBase.login(new LoginRequest("uday123", "uday123"));
		
		LoginResponce loginresponce=responce.as(LoginResponce.class);	// deserialize login responce 	
		System.out.println("Token: "+loginresponce.getToken()); // we get token from her
		
		System.out.println("_________________________________++++++________________________________________________________");
		userProfileManagementService userprofilemanagementservice= new userProfileManagementService();
		responce=userprofilemanagementservice.profile(loginresponce.getToken());
		System.out.println("User profile  Responce: "+responce.asPrettyString());
		
		System.out.println("--------------------------------------------------------");
		UserProfileResponce userprofileresponce= responce.as(UserProfileResponce.class);
		Assert.assertEquals(userprofileresponce.getUsername(), "uday123");
		System.out.println("User Name: "+userprofileresponce.getUsername());
		
		System.out.println("--------------------------------------------------------");
		ProfileRequest profilerequest= new ProfileRequest.Builder().firstName("Hinaya")
				.lastName("Singh").email("hinaya@gmail.com").mobileNumber("8765007896").build();
		responce=userprofilemanagementservice.updateProfile(loginresponce.getToken(), profilerequest);
		System.out.println(responce.asPrettyString());
				
			
	}

}


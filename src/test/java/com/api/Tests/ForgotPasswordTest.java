package com.api.Tests;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthenticationBase;

import io.restassured.response.Response;

public class ForgotPasswordTest {
	@Test (description = "Verify Forgot password api is working properly...")
	public void forgotPassword() {
		AuthenticationBase auth=new AuthenticationBase();
		Response response=auth.forgotPassword("sujata.mandekar193@gmail.com");
		System.out.println("Resp= "+response.asPrettyString());
		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertEquals(response.asPrettyString(), "If your email exists in our system, you will receive reset instructions.");
	}

}

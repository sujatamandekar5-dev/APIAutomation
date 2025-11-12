package com.api.base;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class baseService { // Wrapper fot Rewst Assured 
	// Handling Base URL
	// Creasting the request
	// responsible for creatingh the responce 
	
    private static final String BASE_URL="http://64.227.160.186:8080/"; // here we creare constant variable . which is written in capital letter & come up with final static keyword
    
    // Create instance variable
    private RequestSpecification requestspacification; // its an interface so, not able to create its object 
    
    // Create constructor: to initialize the instance variable 
    public baseService() {
    	requestspacification=RestAssured.given().baseUri(BASE_URL);
    }
    
    protected Response postRequest(Object payload, String endpopint)
    {
    	return requestspacification.contentType(ContentType.JSON).body(payload).post(endpopint);
    	
    }
}

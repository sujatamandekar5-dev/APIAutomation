package com.api.filters;

import java.util.logging.Filter;
import java.util.logging.LogRecord;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class LoggingFilter implements io.restassured.filter.Filter { //Interception: so log details in logs 

	private static final Logger logger=LogManager.getLogger(LoggingFilter.class);
	@Override
	public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec,
			FilterContext ctx) {
		logRequest(requestSpec);
		Response responce=ctx.next(requestSpec, responseSpec); // Request is going to execute
		logResponce(responce);
		
		return responce; // Test for assertion
	}
	
	public void logRequest(FilterableRequestSpecification requestSpec) {
		logger.info("Request BASE URI: "+ requestSpec.getBaseUri());
		logger.info("Request Header: "+requestSpec.getHeaders());
		logger.info("Request Payload: "+requestSpec.getBody());
		

	}
	
	public void logResponce(Response responce) {
		logger.info("Status Code: "+ responce.statusCode());
		logger.info("Responce Header: "+responce.headers());
		logger.info("Request Header: "+responce.getBody().prettyPrint());
		
	}
	
}

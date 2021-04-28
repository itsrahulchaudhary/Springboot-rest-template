package com.rest.template.api.controller;




import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestClient {
	
	public static String GET_ALL_USERS_API = "http://localhost:8080/api/users";
	public static String GET_USER_BY_ID = "http://localhost:8080/api/users/{id}";
	public static String CREATE_USER_API = "http://localhost:8080/api/users";
	public static String UPDATE_USER_API = "http://localhost:8080/api/users/{id}";
	public static String DELETE_USER_API = "http://localhost:8080/api/users/{id}";

	static RestTemplate restTemplate = new RestTemplate();
	
	public static void main(String[] args) {
		callGetAllUsersAPI();
	}
	
	private static void callGetAllUsersAPI() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
		ResponseEntity<String> result = restTemplate.exchange(GET_ALL_USERS_API, HttpMethod.GET, entity, String.class);
		System.out.println(result);
	}
	
	

}

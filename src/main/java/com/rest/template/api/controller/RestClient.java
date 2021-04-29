package com.rest.template.api.controller;




import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.rest.template.api.entity.User;

public class RestClient {
	
	public static String GET_ALL_USERS_API = "http://localhost:8080/api/users";
	public static String GET_USER_BY_ID = "http://localhost:8080/api/users/{id}";
	public static String CREATE_USER_API = "http://localhost:8080/api/users";
	public static String UPDATE_USER_API = "http://localhost:8080/api/users/{id}";
	public static String DELETE_USER_API = "http://localhost:8080/api/users/{id}";

	static RestTemplate restTemplate = new RestTemplate();
	
	public static void main(String[] args) {
		// callGetAllUsersAPI();
		// callGetUserById();
		// callCreateUserAPI();
		// callDeleteAPI();
		callUpdateAPI();
	}
	
	private static void callGetAllUsersAPI() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
		ResponseEntity<String> result = restTemplate.exchange(GET_ALL_USERS_API, HttpMethod.GET, entity, String.class);
		System.out.println(result);
	}
	
	private static void callGetUserById() {
		Map<String, Integer> param = new HashMap<>();
		param.put("id", 1);
		User user = restTemplate.getForObject(GET_USER_BY_ID, User.class, param);
		System.out.println(user.getFirstName());
		System.out.println(user.getLastName());
		System.out.println(user.getEmail());
	}
	
	public static void callCreateUserAPI() {
		User user = new User("Ramu", "Ramu R", "ramu@gmail.com");
		ResponseEntity<User> userData =  restTemplate.postForEntity(CREATE_USER_API, user, User.class);
		System.out.println(userData.getBody());
	}
	
	public static void callUpdateAPI() {
		Map<String, Integer> param = new HashMap<>();
		param.put("id", 4);
		User userUpdate = new User("RamRam", "Ramu R R", "ramu101@gmail.com");
		restTemplate.put(UPDATE_USER_API, userUpdate, param);
		System.out.println("User Updated successfully " +param.get("id"));

	}
	
	public static void callDeleteAPI() {
		Map<String, Integer> param = new HashMap<>();
		param.put("id", 3);
		restTemplate.delete(DELETE_USER_API, param);
		System.out.println("User deleted successfully " +param.get("id"));
	}

}

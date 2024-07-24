package com.training.rest.client;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.bean.Person;

public class Main1 {
	
	public static void method1() {
		Client client = ClientBuilder.newClient();
		String baseUri = "http://localhost:8080/04-PersonREST/rest/personapi";
		WebTarget target = client.target(baseUri);
		target = target.path("getPerson").path("101");
		//System.out.println(service.path("rest").path("todos").request().accept(MediaType.TEXT_XML).get(String.class))
		String response=target.request().accept(MediaType.APPLICATION_JSON).get(String.class);
		System.out.println(response);
	}
	
	public static void method2() {
		Client client = ClientBuilder.newClient();
		String baseUri = "http://localhost:8080/04-PersonREST/rest/personapi";
		WebTarget target = client.target(baseUri);
		target = target.path("getAll");
		//System.out.println(service.path("rest").path("todos").request().accept(MediaType.TEXT_XML).get(String.class))
		String response=target.request().accept(MediaType.APPLICATION_JSON).get(String.class);
		System.out.println(response);
	}
	
	public static void method3() {
		Person person=new Person(107, "XXX", 10.00);
		Client client = ClientBuilder.newClient();
		String baseUri = "http://localhost:8080/04-PersonREST/rest/personapi";
		WebTarget target = client.target(baseUri);
		target = target.path("add");
		
		Response response = target.request(MediaType.APPLICATION_JSON).post(Entity.entity(person,MediaType.APPLICATION_JSON),Response.class);
		//System.out.println(service.path("rest").path("todos").request().accept(MediaType.TEXT_XML).get(String.class))
	//	String response=target.request().accept(MediaType.APPLICATION_JSON).get(String.class);
		System.out.println(response.getStatus());
		
		System.out.println(response.getEntity());
		
		// Response response = service.path("rest").path("todos").path(todo.getId()).request(MediaType.APPLICATION_XML).put(Entity.entity(todo,MediaType.APPLICATION_XML),Response.class);
	}
	
	public static void method4() {
		Person person=new Person(107, "XXX", 10.00);
		Client client = ClientBuilder.newClient();
		String baseUri = "http://localhost:8080/04-PersonREST/rest/personapi";
		WebTarget target = client.target(baseUri);
		target = target.path("add1");
		
		
		Form form =new Form();
	      form.param("pid", "4");
	      form.param("pname","Dinesh");
	      form.param("psal", "2000.00");
	      
	      Response  response = target.request().post(Entity.entity(form,MediaType.APPLICATION_FORM_URLENCODED),Response.class);
	      System.out.println("Form response " + response.getStatus());
		
		
		System.out.println(response.getStatus());
		
		// Response response = service.path("rest").path("todos").path(todo.getId()).request(MediaType.APPLICATION_XML).put(Entity.entity(todo,MediaType.APPLICATION_XML),Response.class);
	}
	
	public static void method5() {
		Person person=new Person(107, "XXX", 10.00);
		Client client = ClientBuilder.newClient();
		String baseUri = "http://localhost:8080/04-PersonREST/rest/personapi/add";
		WebTarget target = client.target(baseUri);
		//target = target.path("add1");
		
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			String requestBody = objectMapper.writeValueAsString(person);
			
			HttpRequest request = HttpRequest.newBuilder()
	                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
	                .uri(URI.create(baseUri))
	                .header("Content-Type", "application/json")
	                .build();

	        HttpResponse<String> response=null;
			try {
				response = HttpClient.newHttpClient()
				        .send(request, HttpResponse.BodyHandlers.ofString());
			} catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        System.out.println(response.statusCode());
	        System.out.println(response.body());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	 
	}
	
	  

	
	
	
	public static void main(String[] args) {
		method5();
	}
}

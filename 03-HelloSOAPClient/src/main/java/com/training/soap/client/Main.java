package com.training.soap.client;

public class Main {

	public static void main(String[] args) {
		 HelloService service = new HelloService();
	        Hello hello = service.getHelloPort();
	         
	        String response = hello.f1("Guru");
	         
	        System.out.println(response);
	}

}

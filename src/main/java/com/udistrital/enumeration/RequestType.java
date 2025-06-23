package com.udistrital.enumeration;

public enum RequestType {

	GET("GET"),
	POST("POST");
	
	private String value;
	
	RequestType(String value){
		this.value = value;
	}	
	
	public String getValue(){
		return value;
	}
	
}

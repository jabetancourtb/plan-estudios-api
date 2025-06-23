package com.udistrital.enumeration;

public enum Roles {

	ADMIN("ADMIN"),
	MANAGER("MANAGER"),
	SELLER("SELLER"),
	CUSTOMER("CUSTOMER");
	
	private String value;
	
	Roles(String value){
		this.value = value;
	}	
	
	public String getValue(){
		return value;
	}
	
}

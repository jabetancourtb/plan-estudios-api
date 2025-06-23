package com.udistrital.enumeration;

public enum ResponseType {

	RESOURCE_TO_UPDATE_NOT_FOUND("Resource to update not found"),
	RESOURCE_TO_DELETE_NOT_FOUND("Resource to delete not found"),
	RESOURCE_DELETED("Resource deleted");
	
	private String value;
	
	ResponseType(String value){
		this.value = value;
	}
	
	public String getValue(){
		return value;
	}
}

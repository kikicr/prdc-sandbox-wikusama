package com.anabatic.sandbox.enumeration;

public enum RoleEnum {
	ADMIN(0,"ROLE_ADMIN"),
	USER(1,"ROLE_USER");
	private int key;
	private String value;
	
	private RoleEnum(int key, String value) {
		this.key = key;
		this.value = value;
	}

	public int getKey() {
		return key;
	}
	public String getValue() {
		return value;
	}
}

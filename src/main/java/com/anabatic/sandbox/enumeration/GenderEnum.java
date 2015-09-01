package com.anabatic.sandbox.enumeration;

public enum GenderEnum {
	MALE(0,"male"),
	FEMALE(1,"female");
	private int key;
	private String value;
	
	private GenderEnum(int key, String value) {
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

package com.teamroster.models;

public class Player {
	
	private String firstName;
	private String lastName;
	private int age;

	
	public Player() {
		firstName = "";
		lastName = "";
		age = 0;
		
	}
	
	public Player(String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		
	}
	
	public int getAge() {
		return age;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}

}

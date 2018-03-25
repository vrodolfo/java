package com.pets.web.models;

public class Cat extends Animal {
	
	public Cat() {
		super();
	}
	public Cat(String n, String b, int w) {
		super(n, b, w);
	}
	
	
	public String showAffection() {

		return ("Your " + super.getBreed() + " cat " + super.getName() + ", looked at you with some affection.");
	}
	

}

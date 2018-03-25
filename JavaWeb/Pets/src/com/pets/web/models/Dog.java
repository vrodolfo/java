package com.pets.web.models;

public class Dog extends Animal{
	public Dog() {
		super();
	}
	
	public Dog(String n, String b, int w) {
		super(n, b, w);
	}
	
	public String showAffection() {
		if(super.getWeight()>30) {
			return (super.getName()+" Hope into your Lap and Cuddle you");
		}
		else {
			return (super.getName()+" Curl up next to you you");
		}
		
	}

}

package com.pets.web.models;

public abstract class Animal implements Pet{
	private String name;
	private String breed;
	private int weight;
	
	public Animal() {
		name ="";
		breed = "";
		weight=0;
	}
	public Animal(String n, String b, int w) {
		name =n;
		breed = b;
		weight=w;
	}
	
	public String getName() {
		return name;
	}
	public String getBreed() {
		return breed;
	}
	public int getWeight() {
		return weight;
	}
	public void setName(String n) {
		name = n;
	}
	public void setBreed(String b) {
		breed = b;
	}
	public void setWeight(int w) {
		weight = w;
	}

}

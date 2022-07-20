package com.skillstorm.models;

public class Crate {
	private int id;
	private String name;
	private int Size;

	public Crate() {
		
	}
	
	public Crate(String name) {
		
	}
	
	public Crate(int id, String name, int Size) {
		}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return Size;
	}

	public void setSize(int size) {
		Size = size;
	}

	@Override
	public String toString() {
		return "Crate [id=" + id + ", name=" + name + ", Size=" + Size + "]";
	}
	
	}
	

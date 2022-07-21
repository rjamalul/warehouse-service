package com.skillstorm.models;

public class Crate {
	private int id;
	private int size;
	private String name;
	private int idWarehouses;
		
	public Crate(int id, int size, String name, int idWarehouses) {
		this.id = id;
		this.name = name;
		this.size = size;
		this.idWarehouses = idWarehouses;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public int getIdWarehouses() {
		return idWarehouses;
	}

	public void setIdWarehouses(int idWarehouses) {
		this.idWarehouses = idWarehouses;
	}
	
	@Override
	public String toString() {
		return "Crate [id=" + id + ", size=" + size + ", name=" + name + ", idWarehouses=" + idWarehouses + "]";
	}	
}
	

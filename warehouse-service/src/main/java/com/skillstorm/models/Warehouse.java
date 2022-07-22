package com.skillstorm.models;

public class Warehouse {
	private int id;
	private int CurrentCapacity;
	
	public Warehouse() {}
	
	public Warehouse(int id, int CurrentCapacity) {
		this.id=id;
		this.CurrentCapacity=CurrentCapacity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCurrentCapacity() {
		return CurrentCapacity;
	}

	public void setCurrentCapacity(int currentCapacity) {
		CurrentCapacity = currentCapacity;
	}

	@Override
	public String toString() {
		return "warehouse [id=" + id + ", CurrentCapacity=" + CurrentCapacity + "]";
	}
	
	
}

package com.skillstorm.models;

public class Warehouse {
	private int warehouseId;
	private String warehouseName;
	private int currentCapacity;
	private int maxCapacity;	

	public int getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(int warehouseId) {
		this.warehouseId = warehouseId;
	}
	
	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	public int getCurrentCapacity() {
		return currentCapacity;
	}

	public void setCurrentCapacity(int currentCapacity) {
		this.currentCapacity = currentCapacity;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}	
	
	public Warehouse() {}
	
	public Warehouse(int warehouseId, String warehouseName,int currentCapacity, int maxCapacity) {
		this.warehouseId=warehouseId;
		this.warehouseName=warehouseName;
		this.currentCapacity=currentCapacity;
		this.maxCapacity=maxCapacity;
	}
	
	@Override
	public String toString() {
		return "Warehouse [warehouseId=" + warehouseId + ", warehouseName=" + warehouseName + ", currentCapacity="
				+ currentCapacity + ", maxCapacity=" + maxCapacity + "]";
	}
}

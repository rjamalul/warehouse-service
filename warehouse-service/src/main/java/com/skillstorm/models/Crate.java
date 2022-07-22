package com.skillstorm.models;

public class Crate {
	
	private int crateId;
	private String crateName;
	private int crateSize;
	private int warehouseId;	

	public int getCrateId() {
		return crateId;
	}

	public void setCrateId(int crateId) {
		this.crateId = crateId;
	}

	public String getCrateName() {
		return crateName;
	}

	public void setCrateName(String crateName) {
		this.crateName = crateName;
	}
	
	public int getCrateSize() {
		return crateSize;
	}

	public void setCrateSize(int crateSize) {
		this.crateSize = crateSize;
	}

	public int getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(int warehouseId) {
		this.warehouseId = warehouseId;
	}
	
	public Crate() {}
	
	public Crate(int crateId, String crateName, int crateSize,  int warehouseId) {
		this.crateId = crateId;
		this.crateName = crateName;
		this.crateSize = crateSize;
		this.warehouseId = warehouseId;
	}
	
	@Override
	public String toString() {
		return "Crate [crateId=" + crateId + ", crateSize=" + crateSize + ", crateName=" + crateName + ", warehouseId="
				+ warehouseId + "]";
	}
	
}
	

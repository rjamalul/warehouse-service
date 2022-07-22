package com.skillstorm.daos.interfaces;

import java.util.List;

import com.skillstorm.models.Warehouse;

public interface WarehouseDAO {
		
	public List<Warehouse> getWarehouses();
	
	public Warehouse getWarehouseById(int warehouseId);
	
	public void updateWarehouseCurrentCapacity(int warehouseId, int currentCapacity);
}

package com.skillstorm.daos.interfaces;

import java.util.List;

import com.skillstorm.models.Warehouse;

public interface WarehouseDAO {
	
	public Warehouse getWarehouseById();
	
	public List<Warehouse> getWarehouses();

	public Warehouse updateWarehouse(Warehouse warehouse);
	
}

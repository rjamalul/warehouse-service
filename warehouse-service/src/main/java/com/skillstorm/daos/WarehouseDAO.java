package com.skillstorm.daos;

import java.util.List;

import com.skillstorm.models.Warehouse;

public interface WarehouseDAO {
	
	public List<Warehouse> findAll();

	public Warehouse updateWarehouse(Warehouse warehouse);
	
}

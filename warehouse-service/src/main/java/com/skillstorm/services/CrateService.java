package com.skillstorm.services;

import com.skillstorm.daos.CrateDAOImpl;
import com.skillstorm.daos.WarehouseDAOImpl;
import com.skillstorm.daos.interfaces.CrateDAO;
import com.skillstorm.daos.interfaces.WarehouseDAO;
import com.skillstorm.models.Crate;
import com.skillstorm.models.Warehouse;

public class CrateService {
	CrateDAO crateDao = new CrateDAOImpl();	
	WarehouseDAO warehouseDao = new WarehouseDAOImpl();
	
	public Crate checkIfMaxCapacityIsHit(String type, Crate newCrate) {
		Warehouse warehouse = warehouseDao.getWarehouseById(newCrate.getWarehouseId());
		Crate oldCrate = crateDao.getCratesById(newCrate.getCrateId());
		if (warehouse.getCurrentCapacity() + newCrate.getCrateSize() < warehouse.getMaxCapacity() || (type != null && type.equalsIgnoreCase("update") && ((warehouse.getCurrentCapacity() - oldCrate.getCrateSize() + newCrate.getCrateSize()) < warehouse.getMaxCapacity()))) {
			if (type != null && type.equalsIgnoreCase("update")) {
				System.out.println("UPDATING THIS NOW");
				newCrate = crateDao.updateCrate(newCrate);
			} else {
				newCrate = crateDao.addCrate(newCrate);
			}
			
			if (newCrate != null) {
				warehouseDao.updateWarehouseCurrentCapacity(newCrate.getWarehouseId(), newCrate.getCrateSize());
			}
		} else {
			return null;
		} 
		return newCrate;
	}
}

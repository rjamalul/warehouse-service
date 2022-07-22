package com.skillstorm.daos.interfaces;

import java.util.List;
import com.skillstorm.models.Crate;

//Queries specific to Crates
public interface CrateDAO {

	public List<Crate> findAll();
	public Crate getCratesById(int crateId);
	public Crate addCrate(Crate crate);
	public Crate updateCrate(Crate crate); 
	public void deleteCrate(int id);
	public List<Crate> getCratesByWarehouseId(int warehouseId);
	
}

package com.skillstorm.daos;

import java.util.List;

import com.skillstorm.models.Crate;

//Queries specific to Crates
public interface CrateDAO {

	public List<Crate> findAll();
	public Crate addCrate(Crate crate);
	public Crate updateCrate(Crate crate); //might not match for artist ex
	public void deleteCrate(int id);
	
}

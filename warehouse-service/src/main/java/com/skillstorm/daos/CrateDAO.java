package com.skillstorm.daos;

import java.util.List;

import com.skillstorm.models.Crate;

//Queries specific to Crates
public interface CrateDAO {

	public List<Crate> findAll();
	public Crate findById(int id);
	public Crate findByName(String name);
	public void save(Crate crate);
	public void updateName(Crate crate); //might not match for artist ex
	public void delete(Crate crate);
	public void delete(int id);
	
}

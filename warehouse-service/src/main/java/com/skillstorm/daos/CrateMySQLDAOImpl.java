package com.skillstorm.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.skillstorm.conf.WarehousesDbCreds;
import com.skillstorm.models.Crate;

public class CrateMySQLDAOImpl implements CrateDAO {

	/**
	 * @return the list of artists from the DB is successful, print null if failed.
	 */
	
	@Override
	public List<Crate> findAll() {
		String sql = "SELECT * FROM crate";
		
		//Connection will auto close in event of failure due to auto-closeable
		try (Connection conn = WarehousesDbCreds.getInstance().getConnection()) {
			//Create a Statement using the Connection object
			Statement stmt = conn.createStatement();
			
			//Executing the query returns a ResultSet which contains all of the values returned
			ResultSet rs = stmt.executeQuery(sql);
			
			LinkedList<Crate> crates = new LinkedList<>();
			
			//next() returns a boolean on whether the iterator is done yet
			//Need to advance cursor with it so that you can parse all results
			while(rs.next()) {
				//Looping over individual rows of the result set
				Crate crate = new Crate(rs.getInt("idcrate"), rs.getString("crateName"), rs.getInt("crateSize"));
				crates.add(crate);
			} 
			
			return crates;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null; //Failure, if I receive null back from this function something went wrong.
	}

	@Override
	public Crate findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Crate findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Crate crate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateName(Crate crate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Crate crate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}

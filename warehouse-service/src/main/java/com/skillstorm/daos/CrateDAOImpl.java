package com.skillstorm.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.LinkedList;
import java.util.List;



import com.skillstorm.conf.WarehousesDbCreds;
import com.skillstorm.daos.interfaces.CrateDAO;
import com.skillstorm.models.Crate;

public class CrateDAOImpl implements CrateDAO {

	/**
	 * @return the list of artists from the DB is successful, print null if failed.
	 */
	
	@Override
	public List<Crate> findAll() {
		String sql = "SELECT * FROM crates";
		
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
				Crate crate = new Crate(rs.getInt("crateId"), rs.getString("crateName"),  rs.getInt("crateSize"), rs.getInt("warehouseId"));
				crates.add(crate);
			} 
			
			return crates;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null; //Failure, if I receive null back from this function something went wrong.
	}
	
	@Override
	public List<Crate> getCratesByWarehouseId(int warehouseId) {
		String sql = "SELECT * FROM crates WHERE warehouseId = ";
		
		//Connection will auto close in event of failure due to auto-closeable
		try (Connection conn = WarehousesDbCreds.getInstance().getConnection()) {
			//Create a Statement using the Connection object
			Statement stmt = conn.createStatement();

			//Executing the query returns a ResultSet which contains all of the values returned			
			ResultSet rs = stmt.executeQuery(sql + String.valueOf(warehouseId));
			
			//Executing the query returns a ResultSet which contains all of the values returned						
			LinkedList<Crate> crates = new LinkedList<>();
			
			//next() returns a boolean on whether the iterator is done yet
			//Need to advance cursor with it so that you can parse all results
			while(rs.next()) {
				//Looping over individual rows of the result set
				Crate crate = new Crate(rs.getInt("crateId"), rs.getString("crateName"),  rs.getInt("crateSize"), rs.getInt("warehouseId"));
				crates.add(crate);
			} 
			
			return crates;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null; //Failure, if I receive null back from this function something went wrong.
		
	}
	
	@Override
	public Crate getCratesById(int crateId) {
		String sql = "SELECT * FROM crates WHERE crateId = ";
		
		//Connection will auto close in event of failure due to auto-closeable
		try (Connection conn = WarehousesDbCreds.getInstance().getConnection()) {
			//Create a Statement using the Connection object
			Statement stmt = conn.createStatement();

			//Executing the query returns a ResultSet which contains all of the values returned			
			ResultSet rs = stmt.executeQuery(sql + String.valueOf(crateId));
			
			//Executing the query returns a ResultSet which contains all of the values returned						
			LinkedList<Crate> crates = new LinkedList<>();
			
			Crate crate = null;
			
			//next() returns a boolean on whether the iterator is done yet
			//Need to advance cursor with it so that you can parse all results
			if(rs.next()) {
				//Looping over individual rows of the result set
				crate = new Crate(rs.getInt("crateId"), rs.getString("crateName"),  rs.getInt("crateSize"), rs.getInt("warehouseId"));
			} 
			
			return crate ;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null; //Failure, if I receive null back from this function something went wrong.
		
	}

	
	@Override
	public Crate addCrate(Crate crate) {
		
		//Don't include crateId due to auto-increment
		String sql = "INSERT INTO crates (crateName, crateSize, warehouseId) VALUES (?, ?, ?)";
		try (Connection conn = WarehousesDbCreds.getInstance().getConnection()) {
			
			//Start a transaction
			conn.setAutoCommit(false); //prevents each query from immediately altering DB
			
			//Obtain auto incremented values like so
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, crate.getCrateName());
			ps.setInt(2, crate.getCrateSize());
			ps.setInt(3, crate.getWarehouseId());
			
			int rowsAffected = ps.executeUpdate(); //If 0 is returned, my data didn't save
			if (rowsAffected != 0) {				
				ResultSet keys = ps.getGeneratedKeys();				
				conn.commit(); //execute all queries in a given transaction 
				return crate;
			} else {
				conn.rollback();
			}
			System.out.println("addCrate Ended");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null; //this was return crate but I changed it to null to match his code
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCrate(int id) {
		String sql = "DELETE FROM crates WHERE crateId = ?";
		try (Connection conn = WarehousesDbCreds.getInstance().getConnection()) {

			// Start a transaction
			conn.setAutoCommit(false); // prevents each query from immediately altering DB

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, id);

			int rowsAffected = ps.executeUpdate(); // If 0 is returned, my data didn't save
			if (rowsAffected != 0) {
				conn.commit(); // execute all queries in a given transaction
				return;
			} else {
				conn.rollback();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return;
		// TODO Auto-generated method stub

	}
	
	//CHECK THIS updateName()
	@Override
	public Crate updateCrate(Crate crate) {
		String sql = "UPDATE crates SET crateName=?, crateSize=?, warehouseId=? WHERE crateId=?";
		try (Connection conn = WarehousesDbCreds.getInstance().getConnection()) {
			
			//Start a transaction
			conn.setAutoCommit(false); //prevents each query from immediately altering DB
			
			//Obtain auto incremented values like so
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, crate.getCrateName());
			ps.setInt(2, crate.getCrateSize());
			ps.setInt(3, crate.getWarehouseId());
			ps.setInt(4, crate.getCrateId());
			
			int rowsAffected = ps.executeUpdate(); //If 0 is returned, my data didn't save
			if (rowsAffected != 0) {				
				ResultSet keys = ps.getGeneratedKeys();				
				conn.commit(); //execute all queries in a given transaction 
				return crate;
			} else {
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		// TODO Auto-generated method stub		
	}



	


}

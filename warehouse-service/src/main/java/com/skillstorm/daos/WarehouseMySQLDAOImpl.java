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
import com.skillstorm.models.Warehouse;

public class WarehouseMySQLDAOImpl implements WarehouseDAO {

	
	@Override
	public List<Warehouse> findAll() {
//		String sql = "SELECT * FROM crate";
//		
//		//Connection will auto close in event of failure due to auto-closeable
//		try (Connection conn = WarehousesDbCreds.getInstance().getConnection()) {
//			//Create a Statement using the Connection object
//			Statement stmt = conn.createStatement();
//			
//			//Executing the query returns a ResultSet which contains all of the values returned
//			ResultSet rs = stmt.executeQuery(sql);
//			
//			LinkedList<Warehouse> crates = new LinkedList<>();
//			
//			//next() returns a boolean on whether the iterator is done yet
//			//Need to advance cursor with it so that you can parse all results
//			while(rs.next()) {
//				//Looping over individual rows of the result set
//				Warehouse crate = new Warehouse(rs.getInt("idWarehouses"), rs.getInt("currentCapacity"), rs.getString("maxCapacity"), rs.getInt("idWarehouses"));
//				crates.add(crate);
//			} 
//			
//			return crates;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
		return null; //Failure, if I receive null back from this function something went wrong.
	}
//	
	@Override
	public Warehouse updateWarehouse(Warehouse warehouse) {
//		
//		//Don't include crateId due to auto-increment
//		String sql = "INSERT INTO crate (crateSize, crateName, idWarehouses) VALUES (?, ?, ?)";
//		try (Connection conn = WarehousesDbCreds.getInstance().getConnection()) {
//			
//			//Start a transaction
//			conn.setAutoCommit(false); //prevents each query from immediately altering DB
//			
//			//Obtain auto incremented values like so
//			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//			ps.setInt(1, warehouse.getCurrentCapacity());
//			
//			int rowsAffected = ps.executeUpdate(); //If 0 is returned, my data didn't save
//			if (rowsAffected != 0) {				
//				ResultSet keys = ps.getGeneratedKeys();				
//				conn.commit(); //execute all queries in a given transaction 
//				return warehouse;
//			} else {
//				conn.rollback();
//			}
//			System.out.println("addCrate Ended");
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
		return null; //this was return crate but I changed it to null to match his code
//		// TODO Auto-generated method stub
//		
	}

}

//package com.skillstorm.daos;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.sql.PreparedStatement;
//import java.util.LinkedList;
//import java.util.List;
//
//
//
//import com.skillstorm.conf.WarehousesDbCreds;
//import com.skillstorm.models.Crate;
//
//public class CrateMySQLDAOImpl implements CrateDAO {
//
//	/**
//	 * @return the list of artists from the DB is successful, print null if failed.
//	 */
//	

//
//	@Override
//	public void deleteCrate(int id) {
//		String sql = "DELETE FROM crate WHERE idCrate = ?";
//		try (Connection conn = WarehousesDbCreds.getInstance().getConnection()) {
//
//			// Start a transaction
//			conn.setAutoCommit(false); // prevents each query from immediately altering DB
//
//			PreparedStatement ps = conn.prepareStatement(sql);
//
//			ps.setInt(1, id);
//
//			int rowsAffected = ps.executeUpdate(); // If 0 is returned, my data didn't save
//			if (rowsAffected != 0) {
//
//				conn.commit(); // execute all queries in a given transaction
//				return;
//			} else {
//				conn.rollback();
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return;
//		// TODO Auto-generated method stub
//
//	}
//	//CHECK THIS updateName()
//	@Override
//	public Crate updateCrate(Crate crate) {
//		String sql = "UPDATE crate SET crateSize=?, crateName=?, idWarehouses=? WHERE idcrate=?";
//		try (Connection conn = WarehousesDbCreds.getInstance().getConnection()) {
//			
//			//Start a transaction
//			conn.setAutoCommit(false); //prevents each query from immediately altering DB
//			
//			//Obtain auto incremented values like so
//			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//			ps.setInt(1, crate.getSize());
//			ps.setString(2, crate.getName());
//			ps.setInt(3, crate.getIdWarehouses());
//			ps.setInt(4, crate.getId());
//			
//			int rowsAffected = ps.executeUpdate(); //If 0 is returned, my data didn't save
//			if (rowsAffected != 0) {				
//				ResultSet keys = ps.getGeneratedKeys();				
//				conn.commit(); //execute all queries in a given transaction 
//				return crate;
//			} else {
//				conn.rollback();
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return null;
//		// TODO Auto-generated method stub
//		
//	}
//
//
//
//	
//
//
//}

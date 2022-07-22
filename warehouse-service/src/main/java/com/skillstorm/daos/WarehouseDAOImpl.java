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
import com.skillstorm.daos.interfaces.WarehouseDAO;
import com.skillstorm.models.Warehouse;

public class WarehouseDAOImpl implements WarehouseDAO {
	
	@Override
	public List<Warehouse> getWarehouses() {
		String sql = "SELECT * FROM warehouses";
		
		//Connection will auto close in event of failure due to auto-closeable
		try (Connection conn = WarehousesDbCreds.getInstance().getConnection()) {
			//Create a Statement using the Connection object
			Statement stmt = conn.createStatement();
			
			//Executing the query returns a ResultSet which contains all of the values returned
			ResultSet rs = stmt.executeQuery(sql);
			
			LinkedList<Warehouse> warehouses = new LinkedList<>();
			
			//next() returns a boolean on whether the iterator is done yet
			//Need to advance cursor with it so that you can parse all results
			while(rs.next()) {
				//Looping over individual rows of the result set
				Warehouse warehouse = new Warehouse(rs.getInt("warehouseId"), rs.getString("warehouseName") ,rs.getInt("currentCapacity"), rs.getInt("maxCapacity"));
				warehouses.add(warehouse);
			}
			
			return warehouses;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null; //Failure, if I receive null back from this function something went wrong.
	}
	
	@Override
	public Warehouse getWarehouseById(int warehouseId) {
		String sql = "SELECT * FROM warehouses WHERE warehouseId =";
		
		//Connection will auto close in event of failure due to auto-closeable
		try (Connection conn = WarehousesDbCreds.getInstance().getConnection()) {
			//Create a Statement using the Connection object
			Statement stmt = conn.createStatement();
			
			//Executing the query returns a ResultSet which contains all of the values returned
			ResultSet rs = stmt.executeQuery(sql + warehouseId);
				
			Warehouse warehouse = null;
			
			//next() returns a boolean on whether the iterator is done yet
			//Need to advance cursor with it so that you can parse all results
			if(rs.next()) {
				//Looping over individual rows of the result set
				warehouse = new Warehouse(rs.getInt("warehouseId"), rs.getString("warehouseName") ,rs.getInt("currentCapacity"), rs.getInt("maxCapacity"));
			}
			
			return warehouse;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null; //Failure, if I receive null back from this function something went wrong.
	}
	
	@Override
	public void updateWarehouseCurrentCapacity(int warehouseId, int currentCapacity) {
		String sql = "UPDATE warehouses SET currentCapacity=? WHERE warehouseId=?";
		try (Connection conn = WarehousesDbCreds.getInstance().getConnection()) {
			
			//Start a transaction
			conn.setAutoCommit(false); //prevents each query from immediately altering DB
			
			//Obtain auto incremented values like so
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);			
			ps.setInt(1, currentCapacity);
			ps.setInt(2, warehouseId);
						
			int rowsAffected = ps.executeUpdate(); //If 0 is returned, my data didn't save
			if (rowsAffected != 0) {				
				ResultSet keys = ps.getGeneratedKeys();				
				conn.commit(); //execute all queries in a given transaction 
			} else {
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
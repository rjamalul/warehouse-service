package com.skillstorm;

import java.util.List;

import com.skillstorm.daos.CrateDAO;
import com.skillstorm.daos.CrateMySQLDAOImpl;
import com.skillstorm.models.Crate;

public class Driver {

//	static {
//		try {
//			//Load it into memory so I have it
//			Class.forName("com.mysql.jdbc.Driver");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//	}
	
	//Below is him commenting above out to test if we're connected to DB
	public static void main(String[] args) {
		CrateDAO dao = new CrateMySQLDAOImpl();
		
		List<Crate> crates = dao.findAll();
		System.out.println(crates);

	}

}

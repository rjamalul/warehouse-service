package com.skillstorm.servlets;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skillstorm.daos.interfaces.WarehouseDAO;
import com.skillstorm.daos.WarehouseDAOImpl;
import com.skillstorm.models.Crate;
import com.skillstorm.models.NotFound;
import com.skillstorm.models.Warehouse;
import com.skillstorm.services.URLParserService;

//Tomcat will provide implementation for our HttpServlet
@WebServlet(urlPatterns = "/warehouses/*")
public class WarehouseServlet extends HttpServlet {

	private static final long serialVersionUID = 5795274365670879885L; //re-check if this is my serialVersionUID
	WarehouseDAO warehouseDao = new WarehouseDAOImpl();
	URLParserService urlService = new URLParserService();
	ObjectMapper objectMapper = new ObjectMapper();
	
	@Override
	public void init() throws ServletException {
		// This allows us to write code that is run right as the servlet is created
		// You can establish any connections

		System.out.println("ArtistServlet Created!");
		super.init();
	}
	
	@Override
	public void destroy() {
		// If any connections were established in init
		// Terminate those connections here
		System.out.println("CrateServlet Destroyed!");
		super.destroy();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Warehouse> warehouses = new ArrayList<Warehouse>(); 
		
		System.out.println("GET method called");
		
		
		warehouses = warehouseDao.getWarehouses();
		
		PrintWriter responseOutput = resp.getWriter(); //lets us write to our HTTP Request
		String returnStringObject = objectMapper.writeValueAsString(warehouses);
		responseOutput.println(returnStringObject);
		
		System.out.println("I finished running");
	}
		
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		InputStream reqBody = req.getInputStream();
//		String reqBodyStringFormat = convertInputStreamToString(reqBody);
//		
//		System.out.println(reqBodyStringFormat);
//		
//		Crate newCrate = objectMapper.readValue(reqBodyStringFormat, Crate.class);
//		
//		String type = urlService.extractRequestFromURL(req.getPathInfo()); //req.getServletPath() 
//		
//		System.out.println(type);
//		
//		if (type != null && type.equalsIgnoreCase("update")) {
//			System.out.println("UPDATING THIS NOW");
//			newCrate = crateDao.updateCrate(newCrate);
//		} else {
//			newCrate = crateDao.addCrate(newCrate);
//		}		
//		
//		if (newCrate != null) {
//			resp.setContentType("application/json");
//			resp.getWriter().print(objectMapper.writeValueAsString(newCrate));
//			resp.setStatus(201); // The default is 200
//		} else {
//			resp.setStatus(400);
//			resp.getWriter().print(objectMapper.writeValueAsString(new NotFound("Unable to create crate")));
//		}
//		
//		System.out.println("Finished POST");
		
	}
	
	// Utiltiy function for Converting InputStream to String
    private static String convertInputStreamToString(InputStream is) throws IOException {
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        byte[] buffer = new byte[8192];
        int length;
        while ((length = is.read(buffer)) != -1) {
            result.write(buffer, 0, length);
        }        
        return result.toString("UTF-8");
    }

}

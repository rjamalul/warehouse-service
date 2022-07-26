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
import com.skillstorm.daos.interfaces.CrateDAO;
import com.skillstorm.daos.CrateDAOImpl;
import com.skillstorm.models.Crate;
import com.skillstorm.models.NotFound;
import com.skillstorm.services.URLParserService;
import com.skillstorm.services.CrateService;

//Tomcat will provide implementation for our HttpServlet
@WebServlet(urlPatterns = "/crates/*")
public class CrateServlet extends HttpServlet {

	private static final long serialVersionUID = 5795274365670879885L; //re-check if this is my serialVersionUID
	CrateDAO crateDao = new CrateDAOImpl();
	CrateService crateService = new CrateService();
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
		List<Crate> crates = new ArrayList<Crate>(); 
		
		System.out.println("GET method called");
		
		String id = req.getParameter("id");
		System.out.println(id);

		String type = urlService.extractRequestFromURL(req.getPathInfo()); 
		System.out.println(type);
		
		if (type != null && type.equalsIgnoreCase("warehouse")) { //this indicates look for only crates in a particular warehouse
			crates = crateDao.getCratesByWarehouseId(Integer.parseInt(id));
		} else { // Else find all crates
			crates = crateDao.findAll();
		}
		
		PrintWriter responseOutput = resp.getWriter(); //lets us write to our HTTP Request
		String returnStringObject = objectMapper.writeValueAsString(crates);
		responseOutput.println(returnStringObject);
		
		System.out.println("I finished running");
	}
		
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		InputStream reqBody = req.getInputStream();
		String reqBodyStringFormat = convertInputStreamToString(reqBody);
		
		System.out.println(reqBodyStringFormat);
		
		Crate newCrate = objectMapper.readValue(reqBodyStringFormat, Crate.class);
		
		String type = urlService.extractRequestFromURL(req.getPathInfo()); 
		
		newCrate = crateService.checkIfMaxCapacityIsHit(type, newCrate); //use crateService to determine if Max Capacity is Hit
				
		if (newCrate != null) {
			resp.setContentType("application/json");
			resp.getWriter().print(objectMapper.writeValueAsString(newCrate));
			resp.setStatus(201); // The default is 200
		} else {
			resp.setStatus(400);
			resp.getWriter().print(objectMapper.writeValueAsString(new NotFound("Unable to create crate")));
		}
		
		System.out.println("Finished POST");
		
	}
		
		
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String warehouseId = req.getParameter("warehouseId");
		crateDao.deleteCrate(Integer.parseInt(id), Integer.parseInt(warehouseId));
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

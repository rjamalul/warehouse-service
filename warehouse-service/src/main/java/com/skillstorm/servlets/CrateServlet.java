package com.skillstorm.servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skillstorm.daos.CrateDAO;
import com.skillstorm.daos.CrateMySQLDAOImpl;
import com.skillstorm.models.Crate;


//Tomcat will provide implementation for our HttpServlet
@WebServlet(urlPatterns = "/crates/*")
public class CrateServlet extends HttpServlet {

	CrateDAO crateDao = new CrateMySQLDAOImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Crate> crates = new ArrayList<Crate>(); 
		
		System.out.println("GET method called");
		
		
		crates = crateDao.findAll();
		
		PrintWriter responseOutput = resp.getWriter(); //lets us write to our HTTP Request
		responseOutput.println("{ \"data\" : {} }");
		
		System.out.println("I finished running");
	}
}

package com.training.registration.controller;

import java.io.IOException;

import com.training.registration.dao.RegisterDao;
import com.training.registration.model.Customer;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Register() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String firstName=request.getParameter("firstname");
		 String lastName=request.getParameter("lastname");
		  String userName=request.getParameter("username");
		 String password=request.getParameter("password");
		 String address=request.getParameter("address");
		 String contact =request.getParameter("contact");
		 
		 Customer customer=new Customer();
		 RegisterDao rdao=new RegisterDao();
		 String result=rdao.insert(customer);
		 response.getWriter().println(result);

}
}

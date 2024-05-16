package com.training.registration.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.training.registration.model.Customer;

import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class RegisterDao {
	 private String dburl = "jdbc:mysql://localhost:3306/customer";
	 private String dbuname = "root";
	 private String dbpassword = "admin12345";
	 private String dbdriver = "com.mysql.jdbc.Driver";
	 
	 public void loadDriver(String dbDriver) {
		 try {
			getClass().forName(dbDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 public Connection getConnection() {
		 Connection con = null;
		 try {
		 con = DriverManager.getConnection(dburl, dbuname, dbpassword);
		 } catch (SQLException e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 }
		 return con;
	 }
	 
	 public String insert(Customer customer) {
		 
		 loadDriver(dbdriver);
		 Connection con = getConnection();
		 String sql = "insert into customer.customer values(?,?,?,?,?,?,?)";
		 String result="Data Entered Successfully";
		 try {
		 PreparedStatement ps = con.prepareStatement(sql);
		 ps.setInt(1, 2);
		 ps.setString(2, customer.getFirstname());
		 ps.setString(3, customer.getLastname());
		 ps.setString(4, customer.getUsername());
		 ps.setString(5, customer.getPassword());
		 ps.setString(6, customer.getAddress());
		 ps.setString(7, customer.getContact());
		 ps.executeUpdate();
		 } catch (SQLException e) {
		 // TODO Auto-generated catch block
		 result="Data Not Entered Successfully";
		 e.printStackTrace();
		 }
		 return result;
		 }
}

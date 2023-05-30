package com.OBJ2100.ExampleApp.db;

import java.sql.SQLException;
import java.util.List;

/**
 * Implementation of the methods for establishing database connection
 */

public interface DatabaseInterface {
	
	//	open connection
	void open() throws SQLException;
	
	// close connection
	void close() throws SQLException;
	
	// test connection
	void test() throws SQLException;
	
	// get list of all employees
	List<Employees> getEmployees() throws SQLException;

	// get list of all offices
	List<Offices> getOffices() throws SQLException;	

	// get list of all products
	List<Products> getProducts() throws SQLException;
	
	//add employee with name
	void addEmployee(String firstName, String lastName) throws SQLException;
	
	//add employee with all details
	void addEmployee(String firstName, String lastName, String extension, String email, String officeCode, int reportsTo, String jobTitle) throws SQLException;
	
	//update employee
	void updateEmployee(String firstName, String lastName, String extension, String email, String officeCode, int reportsTo, String jobTitle) throws SQLException;
	
	//delete employee
	void deleteEmployee(String firstName, String lastName) throws SQLException;
	
	// get list of all customers by selected city
	List<Customers> getCustomersByCity(String city) throws SQLException;
	
	// get list of all customers by selected state
	List<Customers> getCustomersByState(String state) throws SQLException;
	
	// get list of all cities in the DB
	List<String> getCities() throws SQLException;
	
	// get list of all states in the DB
	List<String> getStates() throws SQLException;
}

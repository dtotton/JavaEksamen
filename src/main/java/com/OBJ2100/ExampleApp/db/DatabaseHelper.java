package com.OBJ2100.ExampleApp.db;

import java.math.BigDecimal;

/**
Assuming that you have proper MySQL JDBC driver:
How to use this class?
1. Create new object
  DBHelper db = new DBHelper();
2. Open connection
  db.open();
3. Call corresponding method
  db.test();
4. Close connection
  db.close;
  
+ jdbc driver can be found at: http://www.java2s.com/Code/Jar/c/Downloadcommysqljdbc515jar.htm
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper implements DatabaseInterface {

	// JDBC driver name and database URL
    private final String DB_URL = "jdbc:mysql://itfag.usn.no:3306/v22db120?useSSL=false";
    
    //  Database credentials
    private static final String USER = "v22u120";
    private static final String PASS = "test";
    
    private Connection conn = null;
    private Statement stmt = null;
    private PreparedStatement prepStmt = null;
    private ResultSet rSet = null;
    
	    
	    @Override
	    public void open() throws SQLException{
	        try {
	            //Establish connection
	            conn = DriverManager.getConnection(DB_URL, USER,PASS);
	            //Create statement that will be used for executing SQL queries
	            stmt = conn.createStatement();
	        } catch (SQLException ex) {
	            ex.printStackTrace();// More elegant solutions for catching errors exist but they are out of the scope for this course
	        }
	    }
	    
	    @Override
	    public void close() throws SQLException{
	        try {
	            stmt.close();
	            conn.close();
	        } catch (SQLException ex) {
	        	ex.printStackTrace();
	        }
	    }
	    
	    
	  /*  public List<Employees> getEmployees(double minSalary, String department) throws SQLException{
	    	ArrayList<Employees> employees = new ArrayList<Employees>();
	    	this.open();
	    	try {
		    	prepStmt = conn.prepareStatement("select * from employees where salary > ? and department=?");
		    	prepStmt.setDouble(1, minSalary);
		    	prepStmt.setString(2, department);

		    	rSet = prepStmt.executeQuery();
		    	while (rSet.next()) {
		    		int employeeNumber = rSet.getInt("employeeNumber");
					String firstName = rSet.getString("first_name");
					String lastName = rSet.getString("last_name");
					String email = rSet.getString("email");
					double salary = rSet.getDouble("salary");
//					String department = rSet.getString("department");
					
					Employees newEmployee = new Employees(employeeNumber, firstName, lastName, department, salary, email);
					employees.add(newEmployee);
				}
		    	return employees;
			} catch (Exception exc) {
				exc.printStackTrace();
			}
	    	return null;
	    }*/
	   
	    @Override
	    public List<Employees> getEmployees() throws SQLException{
	    	ArrayList<Employees> employees = new ArrayList<Employees>();
	    	this.open();
	    	try {
		    	prepStmt = conn.prepareStatement("select * from employees");
		    	rSet = prepStmt.executeQuery();

		    	while (rSet.next()) {
		    		int employeeNumber = rSet.getInt("employeeNumber");
					String firstName = rSet.getString("firstName");
					String lastName = rSet.getString("lastName");
					String extension = rSet.getString("extension");
					String email = rSet.getString("email");
					String officeCode = rSet.getString("officeCode");
					int reportsTo = rSet.getInt("reportsTo");
					String jobTitle = rSet.getString("jobTitle");
					
					Employees current= new Employees(employeeNumber, firstName, lastName, extension, email, officeCode, reportsTo, jobTitle);
					employees.add(current);
				}
		    	return employees;
			} catch (Exception exc) {
				exc.printStackTrace();
			}
	    	return null;
	    }

	    @Override
	    public List<Offices> getOffices() throws SQLException {    
	    	ArrayList<Offices> offices = new ArrayList<Offices>();
	    	this.open();
	    	try {
		    	prepStmt = conn.prepareStatement("select * from offices");
		    	rSet = prepStmt.executeQuery();

		    	while (rSet.next()) {
		    		String officeCode = rSet.getString("officeCode");
					String city = rSet.getString("city");
					String phone = rSet.getString("phone");
					String addressLine1 = rSet.getString("addressLine1");
					String addressLine2 = rSet.getString("addressLine2");
					String state = rSet.getString("state");
					String country = rSet.getString("country");
					String postalCode = rSet.getString("postalCode");
					String territory = rSet.getString("territory");
					
					Offices current= new Offices(officeCode, city, phone, addressLine1, addressLine2, state, country, postalCode, territory);
					offices.add(current);
				}
		    	return offices;
			} catch (Exception exc) {
				exc.printStackTrace();
			}	    	
	    	return null;
	    	
	    }

	    
	    @Override
	    public List<Products> getProducts() throws SQLException {    
	    	ArrayList<Products> products = new ArrayList<Products>();
	    	this.open();
	    	try {
		    	prepStmt = conn.prepareStatement("select * from products");
		    	rSet = prepStmt.executeQuery();

		    	while (rSet.next()) {
		    		String productCode = rSet.getString("productCode");
		    		String productName = rSet.getString("productName");
		    		String productLine = rSet.getString("productLine");
		    		String productScale = rSet.getString("productCode");
		    		String productVendor = rSet.getString("productVendor");
		    		String productDescription = rSet.getString("productDescription");
		    		short quantityInStock = rSet.getShort("quantityInStock");
		    		BigDecimal buyPrice = rSet.getBigDecimal("buyPrice");
		    		BigDecimal  MSRP = rSet.getBigDecimal("MSRP");
					
		    		Products current= new Products(productCode, productName, productLine, productScale, productVendor, productDescription, quantityInStock, buyPrice, MSRP);
					products.add(current);
				}
		    	return products;
			} catch (Exception exc) {
				exc.printStackTrace();
			}	    	
	    	return null;
	    }	    

	    
	    @Override
	    public void addEmployee(String lastName, String firstName, String extension,String email,String  officeCode,int reportsTo, String jobTitle) throws SQLException{
	    	try {
				open();
	    		prepStmt = conn.prepareStatement(
						"insert into employees " +
						"(lastName, firstName, extension, email, officeCode, reportsTO, jobTitle) " + 
						"values " + 
						"(?, ?, ?, ?, ?)");
	    		prepStmt.setString(1, lastName);
	    		prepStmt.setString(2, firstName);
	    		prepStmt.setString(4, extension);
	    		prepStmt.setString(3, email);
	    		prepStmt.setString(5, officeCode);
	    		prepStmt.setInt(6, reportsTo);
	    		prepStmt.setString(7, jobTitle);
	    		
	    		prepStmt.executeUpdate();
	    		
	    		close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    };
	    
	    @Override
	    public void test() throws SQLException{
	        try {
	            String sql;
	            sql = "SELECT * FROM employees";
	            ResultSet rs = stmt.executeQuery(sql); // DML
	            // stmt.executeUpdate(sql); // DDL
	            
	            //STEP 5: Extract data from result set
	            while(rs.next()){
	                //Display values
	            	System.out.println(rs.getString("firstName") + ", " + rs.getString("lastName"));
	            }
	            //STEP 6: Clean-up environment
	            rs.close();
	        } catch (SQLException ex) {
	        	ex.printStackTrace();
	        }
	    }

		@Override
		public void addEmployee(String firstName, String LastName) throws SQLException {
			// TODO Auto-generated method stub
			
		}
	  
	    @Override
	    public void deleteEmployee(String firstName, String lastName) throws SQLException {
	        try {
	            open();
	            prepStmt = conn.prepareStatement(
	                    "DELETE FROM employees WHERE first_name=? AND last_name=?"
	            );
	            prepStmt.setString(1, firstName);
	            prepStmt.setString(2, lastName);

	            prepStmt.executeUpdate();

	            close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public Employees getEmployee(String firstName, String lastName) throws SQLException {
	        Employees employee = null;
	        try {
	            open();
	            prepStmt = conn.prepareStatement(
	                    "SELECT * FROM employees WHERE first_name=? AND last_name=?"
	            );
	            prepStmt.setString(1, firstName);
	            prepStmt.setString(2, lastName);

	            ResultSet resultSet = prepStmt.executeQuery();

	            if (resultSet.next()) {
	            	int employeeNumber = rSet.getInt("employeeNumber");
	                String extension = resultSet.getString("extension");
	                String  email= resultSet.getString("email");
	                String officeCode = resultSet.getString("officeCode");
	                int reportsTo = resultSet.getInt("reportsTo");
	                String jobTitle = resultSet.getString("jobTitle");

	                employee = new Employees(employeeNumber, lastName, firstName, extension,  email,  officeCode, reportsTo, jobTitle);
	            }

	            close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return employee;
	    }

		@Override
		public void updateEmployee(String firstName, String lastName, String extension, String email, String officeCode,
				int reportsTo, String jobTitle) throws SQLException {
			// TODO Auto-generated method stub
			
		}
		/*getCustomersByCity fetches a list of all customers of the inputed city string*/
		@Override
		public List<Customers> getCustomersByCity(String cityIn) throws SQLException {
			ArrayList<Customers> customers = new ArrayList<Customers>();
	    	this.open();
	    	try {
		    	prepStmt = conn.prepareStatement("select * from customers WHERE city=?");
		    	prepStmt.setString(1, cityIn);
		    	rSet = prepStmt.executeQuery();

		    	while (rSet.next()) {
		    		int customerNumber = rSet.getInt("customerNumber");
					String customerName = rSet.getString("customerName");
					String contactLastName = rSet.getString("contactLastName");
					String contactFirstName = rSet.getString("contactFirstname");
					String phone = rSet.getString("phone");
					String adressLine1 = rSet.getString("addressLine1");
					String adressLine2 = rSet.getString("addressLine2");
					String city = rSet.getString("city");
					String state = rSet.getString("state");
					String postalCode = rSet.getString("postalCode");
					String country = rSet.getString("country");
					int salesRepEmployeeNumber = rSet.getInt("salesRepEmployeeNumber");
					BigDecimal creditLimit = rSet.getBigDecimal("creditLimit");
					
					Customers current= new Customers(customerNumber, customerName, contactLastName, contactFirstName, phone, adressLine1, adressLine2, city, state, postalCode, country, salesRepEmployeeNumber, creditLimit);
					customers.add(current);
				}
		    	return customers;
			} catch (Exception exc) {
				exc.printStackTrace();
			}
	    	return null;
	    }

		/*getCustomersByState fetches a list of all customers of the inputed state string */
		@Override
		public List<Customers> getCustomersByState(String stateIn) throws SQLException {
			ArrayList<Customers> customers = new ArrayList<Customers>();
	    	this.open();
	    	try {
		    	prepStmt = conn.prepareStatement("select * from customers WHERE state=?");
		    	prepStmt.setString(1, stateIn);
		    	rSet = prepStmt.executeQuery();

		    	while (rSet.next()) {
		    		int customerNumber = rSet.getInt("customerNumber");
					String customerName = rSet.getString("customerName");
					String contactLastName = rSet.getString("contactLastName");
					String contactFirstName = rSet.getString("contactFirstname");
					String phone = rSet.getString("phone");
					String adressLine1 = rSet.getString("addressLine1");
					String adressLine2 = rSet.getString("addressLine2");
					String city = rSet.getString("city");
					String state = rSet.getString("state");
					String postalCode = rSet.getString("postalCode");
					String country = rSet.getString("country");
					int salesRepEmployeeNumber = rSet.getInt("salesRepEmployeeNumber");
					BigDecimal creditLimit = rSet.getBigDecimal("creditLimit");
					
					Customers current= new Customers(customerNumber, customerName, contactLastName, contactFirstName, phone, adressLine1, adressLine2, city, state, postalCode, country, salesRepEmployeeNumber, creditLimit);
					customers.add(current);
				}
		    	return customers;
			} catch (Exception exc) {
				exc.printStackTrace();
			}
	    	return null;
		}
		//Fetches a list of all distinct cities currently in the customers table
		@Override
		public List<String> getCities() throws SQLException {
			ArrayList<String> cities = new ArrayList<String>();
	    	this.open();
	    	try {
		    	prepStmt = conn.prepareStatement("SELECT DISTINCT city FROM customers");
		    	rSet = prepStmt.executeQuery();

		    	while (rSet.next()) {
		    		String fetchedCity = rSet.getString("city");
					cities.add(fetchedCity);
				}
		    	return cities;
			} catch (Exception exc) {
				exc.printStackTrace();
			}
	    	return null;
		}
		//fetches a list of all distinct states currently in the customers table
		@Override
		public List<String> getStates() throws SQLException {
			ArrayList<String> states = new ArrayList<String>();
	    	this.open();
	    	try {
		    	prepStmt = conn.prepareStatement("SELECT DISTINCT state FROM customers");
		    	rSet = prepStmt.executeQuery();

		    	while (rSet.next()) {
		    		String fetchedState = rSet.getString("state");
					if(fetchedState != null) {
						
						states.add(fetchedState);
					}
		    		
				}
		    	return states;
			} catch (Exception exc) {
				exc.printStackTrace();
			}
	    	return null;
		}
		

		
}

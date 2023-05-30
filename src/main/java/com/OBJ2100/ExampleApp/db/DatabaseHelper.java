package com.OBJ2100.ExampleApp.db;

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
	    public void addEmployee(int employeeNumber, String lastName, String firstName, String extension,String email,String  officeCode,int reportsTo, String jobTitle) throws SQLException{
	    	try {
				open();
	    		prepStmt = conn.prepareStatement(
						"insert into employees " +
						"(employeeNumber, lastName, firstName, extension, email, officeCode, reportsTo, jobTitle) " + 
						"values " + 
	    				"(?, ?, ?, ?, ?, ?, ?, ?)");
	    		prepStmt.setInt(1, employeeNumber);
	    		prepStmt.setString(2, lastName);
	    		prepStmt.setString(3, firstName);
	    		prepStmt.setString(4, extension);
	    		prepStmt.setString(5, email);
	    		prepStmt.setString(6, officeCode);
	    		prepStmt.setInt(7, reportsTo);
	    		prepStmt.setString(8, jobTitle);
	    		
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
	    public void updateEmployee(String firstName, String lastName, String extension, String email, String officeCode, int reportsTo, String jobTitle) throws SQLException {
	        try {
	            open();
	            prepStmt = conn.prepareStatement(
	                    "UPDATE employees SET extension=?, email=?, officeCode=?, reportsTo=?, jobTitle=? WHERE firstName=? AND lastName=?"
	            );
	            
	            prepStmt.setString(1, extension);
	            prepStmt.setString(2, email);
	            prepStmt.setString(3, officeCode); 
	            prepStmt.setInt(4, reportsTo);
	            prepStmt.setString(5, jobTitle);
	            prepStmt.setString(6, firstName);
	            prepStmt.setString(7, lastName);

	            prepStmt.executeUpdate();

	            close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	  
	    @Override
	    public void deleteEmployee(String firstName, String lastName) throws SQLException {
	        try {
	            open();
	            prepStmt = conn.prepareStatement(
	                    "DELETE FROM employees WHERE firstName=? AND lastName=?"
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
	                    "SELECT * FROM employees WHERE firstName=? AND lastName=?"
	            );
	            prepStmt.setString(1, firstName);
	            prepStmt.setString(2, lastName);


	            ResultSet resultSet = prepStmt.executeQuery();

	            if (resultSet.next()) {
	            	int employeeNumber = resultSet.getInt("employeeNumber");
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



		
}

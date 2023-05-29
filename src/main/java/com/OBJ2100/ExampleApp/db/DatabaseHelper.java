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
	    
	    
	    public List<Employee> getEmployees(double minSalary, String department) throws SQLException{
	    	ArrayList<Employee> employees = new ArrayList<Employee>();
	    	this.open();
	    	try {
		    	prepStmt = conn.prepareStatement("select * from employees where salary > ? and department=?");
		    	prepStmt.setDouble(1, minSalary);
		    	prepStmt.setString(2, department);

		    	rSet = prepStmt.executeQuery();
		    	while (rSet.next()) {
		    		int id = rSet.getInt("id");
					String firstName = rSet.getString("first_name");
					String lastName = rSet.getString("last_name");
					String email = rSet.getString("email");
					double salary = rSet.getDouble("salary");
//					String department = rSet.getString("department");
					
					Employee newEmployee = new Employee(id, firstName, lastName, department, salary, email);
					employees.add(newEmployee);
				}
		    	return employees;
			} catch (Exception exc) {
				exc.printStackTrace();
			}
	    	return null;
	    }
	   
	    @Override
	    public List<Employee> getEmployees() throws SQLException{
	    	ArrayList<Employee> employees = new ArrayList<Employee>();
	    	this.open();
	    	try {
		    	prepStmt = conn.prepareStatement("select * from employees");
		    	rSet = prepStmt.executeQuery();

		    	while (rSet.next()) {
		    		int id = rSet.getInt("id");
					String firstName = rSet.getString("first_name");
					String lastName = rSet.getString("last_name");
					String email = rSet.getString("email");
					double salary = rSet.getDouble("salary");
					String department = rSet.getString("department");
					
					Employee current= new Employee(id, firstName, lastName, department, salary, email);
					employees.add(current);
				}
		    	return employees;
			} catch (Exception exc) {
				exc.printStackTrace();
			}
	    	return null;
	    }
	    
	    @Override
	    public void addEmployee(String firstName, String LastName, String department, String email, double salary) throws SQLException{
	    	try {
				open();
	    		prepStmt = conn.prepareStatement(
						"insert into employees " +
						"(first_name, last_name, department, email, salary) " + 
						"values " + 
						"(?, ?, ?, ?, ?)");
	    		prepStmt.setString(1, firstName);
	    		prepStmt.setString(2, LastName);
	    		prepStmt.setString(4, department);
	    		prepStmt.setString(3, email);
	    		prepStmt.setDouble(5, salary);
	    		
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
	            	System.out.println(rs.getString("first_name") + ", " + rs.getString("last_name"));
	            }
	            //STEP 6: Clean-up environment
	            rs.close();
	        } catch (SQLException ex) {
	        	ex.printStackTrace();
	        }
	    }

		@Override
		public void addEmployee(String firtsName, String LastName) throws SQLException {
			// TODO Auto-generated method stub
			
		}
	    @Override
	    public void updateEmployee(String firstName, String lastName, String department, String email, double salary) throws SQLException {
	        try {
	            open();
	            prepStmt = conn.prepareStatement(
	                    "UPDATE employees SET department=?, email=?, salary=? WHERE first_name=? AND last_name=?"
	            );
	            prepStmt.setString(1, department);
	            prepStmt.setString(2, email);
	            prepStmt.setDouble(3, salary);
	            prepStmt.setString(4, firstName);
	            prepStmt.setString(5, lastName);

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

	    public Employee getEmployee(int id, String firstName, String lastName) throws SQLException {
	        Employee employee = null;
	        try {
	            open();
	            prepStmt = conn.prepareStatement(
	                    "SELECT * FROM employees WHERE first_name=? AND last_name=?"
	            );
	            prepStmt.setString(1, firstName);
	            prepStmt.setString(2, lastName);

	            ResultSet resultSet = prepStmt.executeQuery();

	            if (resultSet.next()) {
	                String department = resultSet.getString("department");
	                String email = resultSet.getString("email");
	                double salary = resultSet.getDouble("salary");

	                employee = new Employee(id, firstName, lastName, department, salary, email);
	            }

	            close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return employee;
	    }
}

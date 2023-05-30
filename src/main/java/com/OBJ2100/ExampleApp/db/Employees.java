/**
 * This class represents the Employees entity.
 * It stores information about employees records.
 * 
 * @author Ståle Rivelsrud
 * @version 1.0
 */


package com.OBJ2100.ExampleApp.db;

public class Employees {
	private int employeeNumber, reportsTo;
	private String lastName, firstName, extension, email, officeCode, jobTitle;

    /**
     * Constructs a Employees object.
     *
	 * @param employeeNumber The employee number.
	 * @param lastName The last name of the employee.
	 * @param firstName The first name of the employee.
	 * @param extension The extension number of the employee.
	 * @param email The email address of the employee.
	 * @param officeCode The office code where the employee works.
	 * @param reportsTo The employee number to whom the employee reports.
	 * @param jobTitle The job title of the employee.
     */	
	
	public Employees (int employeeNumber, String lastName, String firstName, String extention, String email, String officeCode, int reportsTo, String jobTitle) {
		super();
		this.employeeNumber = employeeNumber;
		this.lastName = lastName;
		this.firstName = firstName;
		this.extension = extention;
		this.email = email;
		this.officeCode = officeCode;
		this.reportsTo = reportsTo;
		this.jobTitle = jobTitle;
	}

	/**
     * Retrieves the employee number.
     * 
     * @return The employee number.
     */
    public int getEmployeeNumber() {
        return employeeNumber;
    }

    /**
     * Sets the employee number.
     * 
     * @param employeeNumber The employee number to set.
     */
    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    /**
     * Retrieves the last name of the employee.
     * 
     * @return The last name of the employee.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the employee.
     * 
     * @param lastName The last name of the employee to set.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Retrieves the first name of the employee.
     * 
     * @return The first name of the employee.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the employee.
     * 
     * @param firstName The first name of the employee to set.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Retrieves the extension number of the employee.
     * 
     * @return The extension number of the employee.
     */
    public String getExtension() {
        return extension;
    }

    /**
     * Sets the extension number of the employee.
     * 
     * @param extension The extension number of the employee to set.
     */
    public void setExtension(String extension) {
        this.extension = extension;
    }

    /**
     * Retrieves the email address of the employee.
     * 
     * @return The email address of the employee.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the employee.
     * 
     * @param email The email address of the employee to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retrieves the office code where the employee works.
     * 
     * @return The office code where the employee works.
     */
    public String getOfficeCode() {
        return officeCode;
    }

    /**
     * Sets the office code where the employee works.
     *
     * @param officeCode The office code where the employee works to set.
     */
    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }

    /**
     * Retrieves the employee number to whom the employee reports.
     *
     * @return The employee number to whom the employee reports.
     */
    public int getReportsTo() {
        return reportsTo;
    }

    /**
     * Sets the employee number to whom the employee reports.
     *
     * @param reportsTo The employee number to whom the employee reports to set.
     */
    public void setReportsTo(int reportsTo) {
        this.reportsTo = reportsTo;
    }

    /**
     * Retrieves the job title of the employee.
     *
     * @return The job title of the employee.
     */
    public String getJobTitle() {
        return jobTitle;
    }

    /**
     * Sets the job title of the employee.
     *
     * @param jobTitle The job title of the employee to set.
     */
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

}

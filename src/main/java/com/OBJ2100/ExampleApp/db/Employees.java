/**
 * @author Ståle Rivelsrud
 * @version 1.0
 */


package com.OBJ2100.ExampleApp.db;

public class Employees {
	private int employeeNumber, reportsTo;
	private String lastName, firstName, extension, email, officeCode, jobTitle;
	
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

	public int getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getExtention() {
		return extension;
	}

	public void setExtention(String extention) {
		this.extension = extention;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOfficeCode() {
		return officeCode;
	}

	public void setOfficeCode(String officeCode) {
		this.officeCode = officeCode;
	}

	public int getReportsTo() {
		return reportsTo;
	}

	public void setReportsTo(int reportsTo) {
		this.reportsTo = reportsTo;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

}

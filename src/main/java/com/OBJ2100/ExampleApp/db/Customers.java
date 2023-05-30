/**
 * This class represents the Customers entity.
 * It stores information about customer records.
 *
 * @author Ståle Rivelsrud
 * @version 1.0
 */

package com.OBJ2100.ExampleApp.db;
import java.math.BigDecimal;

public class Customers {
	private int customerNumber, salesRepEmployeeNumber;
	private String customerName, contactLastName, contactFirstName, phone, addressLine1, addressLine2, city, state, postalCode, country;
	private BigDecimal creditLimit;

    /**
     * Constructs a Customers object.
     *
     * @param customerNumber         The customer number.
     * @param customerName           The customer's name.
     * @param contactLastName        The last name of the contact person.
     * @param contactFirstName       The first name of the contact person.
     * @param phone                  The phone number.
     * @param addressLine1           Address line 1.
     * @param addressLine2           Address line 2.
     * @param city                   The city.
     * @param state                  The state.
     * @param postalCode             The postal code.
     * @param country                The country.
     * @param salesRepEmployeeNumber The employee number of the sales representative.
     * @param creditLimit            The credit limit.
     */	
	
	public Customers(int customerNumber, String customerName, String contactLastName, String contactFirstName, String phone, String addressLine1, String addressLine2, String city, String state, String postalCode, String country, int salesRepEmployeeNumber, BigDecimal creditLimit) {
		super();
		this.customerNumber = customerNumber;
		this.customerName = customerName;
		this.contactLastName = contactLastName;
		this.contactFirstName = contactFirstName;
		this.phone = phone;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.country = country;
		this.salesRepEmployeeNumber = salesRepEmployeeNumber;
		this.creditLimit = creditLimit;
	}
	
    /**
     * Retrieves the customer number.
     *
     * @return The customer number.
     */
	public int getCustomerNumber() {
		return customerNumber;
	}

    /**
     * Sets the customer number.
     *
     * @param customerNumber The customer number to set.
     */
	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}

    /**
     * Retrieves the customer's name.
     *
     * @return The customer's name.
     */
	public String getCustomerName() {
		return customerName;
	}

    /**
     * Sets the customer's name.
     *
     * @param customerName The customer's name to set.
     */	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

    /**
     * Retrieves the last name of the contact person.
     *
     * @return The last name of the contact person.
     */
	public String getContactLastName() {
		return contactLastName;
	}

    /**
     * Sets the last name of the contact person.
     *
     * @param contactLastName The last name of the contact person to set.
     */
	public void setContactLastName(String contactLastName) {
		this.contactLastName = contactLastName;
	}

    /**
     * Retrieves the first name of the contact person.
     *
     * @return The first name of the contact person.
     */
	public String getContactFirstName() {
		return contactFirstName;
	}

    /**
     * Sets the first name of the contact person.
     *
     * @param contactFirstName The first name of the contact person to set.
     */
	public void setContactFirstName(String contactFirstName) {
		this.contactFirstName = contactFirstName;
	}

    /**
     * Retrieves the phone number.
     *
     * @return The phone number.
     */
	public String getPhone() {
		return phone;
	}

    /**
     * Sets the phone number.
     *
     * @param phone The phone number to set.
     */
	public void setPhone(String phone) {
		this.phone = phone;
	}

    /**
     * Retrieves address line 1.
     *
     * @return Address line 1.
     */
	public String getAddressLine1() {
		return addressLine1;
	}

    /**
     * Sets address line 1.
     *
     * @param addressLine1 Address line 1 to set.
     */
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

    /**
     * Retrieves address line 2.
     *
     * @return Address line 2.
     */
	public String getAddressLine2() {
		return addressLine2;
	}

    /**
     * Sets address line 2.
     *
     * @param addressLine2 Address line 2 to set.
     */
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

    /**
     * Retrieves the city.
     *
     * @return The city.
     */
	public String getCity() {
		return city;
	}

    /**
     * Sets the city.
     *
     * @param city The city to set.
     */
	public void setCity(String city) {
		this.city = city;
	}

    /**
     * Retrieves the state.
     *
     * @return The state.
     */
	public String getState() {
		return state;
	}

    /**
     * Sets the state.
     *
     * @param state The state to set.
     */
	public void setState(String state) {
		this.state = state;
	}

    /**
     * Retrieves the postal code.
     *
     * @return The postal code.
     */
	public String getPostalCode() {
		return postalCode;
	}

    /**
     * Sets the postal code.
     *
     * @param postalCode The postal code to set.
     */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

    /**
     * Retrieves the country.
     *
     * @return The country.
     */
	public String getCountry() {
		return country;
	}

    /**
     * Sets the country.
     *
     * @param country The country to set.
     */
	public void setCountry(String country) {
		this.country = country;
	}

    /**
     * Retrieves the sales representative employee number.
     *
     * @return The sales representative employee number.
     */
	public int getSalesRepEmployeeNumber() {
		return salesRepEmployeeNumber;
	}

    /**
     * Sets the sales representative employee number.
     *
     * @param salesRepEmployeeNumber The sales representative employee number to set.
     */
	public void setSalesRepEmployeeNumber(int salesRepEmployeeNumber) {
		this.salesRepEmployeeNumber = salesRepEmployeeNumber;
	}

    /**
     * Retrieves the credit limit.
     *
     * @return The credit limit.
     */
	public BigDecimal getCreditLimit() {
		return creditLimit;
	}

    /**
     * Sets the credit limit.
     *
     * @param creditLimit The credit limit to set.
     */
	public void setCreditLimit(BigDecimal creditLimit) {
		this.creditLimit = creditLimit;
	}

	
}

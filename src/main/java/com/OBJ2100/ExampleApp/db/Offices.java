/**
 * This class represents the Office entity.
 * It stores information about offices records.
 * 
 * @author Ståle Rivelsrud
 * @version 1.0
 */


package com.OBJ2100.ExampleApp.db;

public class Offices {
	private String officeCode, city, phone, addressLine1, addressLine2, state, country, postalCode, territory;

    /**
     * Constructs a Office object.
     *
	 * @param officeCode The office code.
	 * @param city The city where the office is located.
	 * @param phone The phone number of the office.
	 * @param addressLine1 The first line of the office address.
	 * @param addressLine2 The second line of the office address.
	 * @param state The state where the office is located.
	 * @param country The country where the office is located.
	 * @param postalCode The postal code of the office.
	 * @param territory The territory associated with the office.
     */		
	
	public Offices (String officeCode, String city, String phone, String addressLine1, String addressLine2, String state, String country, String postalCode, String territory) {
		super();
        this.officeCode = officeCode;
        this.city = city;
        this.phone = phone;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.state = state;
        this.country = country;
        this.postalCode = postalCode;
        this.territory = territory;
	}

	/**
     * Retrieves the office code.
     *
     * @return The office code.
     */
    public String getOfficeCode() {
        return officeCode;
    }

    /**
     * Sets the office code.
     *
     * @param officeCode The office code to set.
     */
    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }

    /**
     * Retrieves the city where the office is located.
     *
     * @return The city where the office is located.
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city where the office is located.
     *
     * @param city The city where the office is located to set.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Retrieves the phone number of the office.
     *
     * @return The phone number of the office.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the phone number of the office.
     *
     * @param phone The phone number of the office to set.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Retrieves the first line of the office address.
     *
     * @return The first line of the office address.
     */
    public String getAddressLine1() {
        return addressLine1;
    }

    /**
     * Sets the first line of the office address.
     *
     * @param addressLine1 The first line of the office address to set.
     */
    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    /**
     * Retrieves the second line of the office address.
     *
     * @return The second line of the office address.
     */
    public String getAddressLine2() {
        return addressLine2;
    }

    /**
     * Sets the second line of the office address.
     *
     * @param addressLine2 The second line of the office address to set.
     */
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

    /**
     * Retrieves the state where the office is located.
     *
     * @return The state where the office is located.
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the state where the office is located.
     *
     * @param state The state where the office is located to set.
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Retrieves the country where the office is located.
     *
     * @return The country where the office is located.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the country where the office is located.
     *
     * @param country The country where the office is located to set.
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Retrieves the postal code of the office.
     *
     * @return The postal code of the office.
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Sets the postal code of the office.
     *
     * @param postalCode The postal code of the office to set.
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * Retrieves the territory associated with the office.
     *
     * @return The territory associated with the office.
     */
    public String getTerritory() {
        return territory;
    }

    /**
     * Sets the territory associated with the office.
     *
     * @param territory The territory associated with the office to set.
     */
    public void setTerritory(String territory) {
        this.territory = territory;
    }
}

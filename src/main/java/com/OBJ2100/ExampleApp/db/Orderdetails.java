/**
 * This class represents the Orderdetails entity.
 * It stores information about the order details for a specific product.
 * 
 * @author Ståle Rivelsrud
 * @version 1.0
 */

package com.OBJ2100.ExampleApp.db;
import java.math.BigDecimal;

public class Orderdetails {
	private int orderNumber, quantityOrdered;
	private short orderLineNumber;
	private String productCode;
	private BigDecimal priceEach;

    /**
     * Constructs a Orderdetails object.
     *
	 * @param orderNumber The order number associated with the order detail.
	 * @param productCode The product code of the product in the order detail.
	 * @param quantityOrdered The quantity of the product ordered.
	 * @param priceEach The price per unit of the product.
	 * @param orderLineNumber The line number of the order detail.
     */		
		
	
	public Orderdetails (int orderNumber, String productCode, int quantityOrdered, BigDecimal priceEach, short orderLineNumber) {
		super();
		this.orderNumber = orderNumber;
		this.productCode = productCode;
		this.quantityOrdered = quantityOrdered;
		this.priceEach = priceEach;
		this.orderLineNumber = orderLineNumber;
	}

    /**
     * Retrieves the order number associated with the details.
     * 
     * @return The order number.
     */
    public int getOrderNumber() {
        return orderNumber;
    }

    /**
     * Sets the order number associated with the details.
     * 
     * @param orderNumber The order number to set.
     */
    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     * Retrieves the product code associated with the details.
     * 
     * @return The product code.
     */
    public String getProductCode() {
        return productCode;
    }

    /**
     * Sets the product code associated with the details.
     * 
     * @param productCode The product code to set.
     */
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    /**
     * Retrieves the quantity ordered.
     *
     * @return The quantity ordered.
     */
    public int getQuantityOrdered() {
        return quantityOrdered;
    }

    /**
     * Sets the quantity ordered.
     *
     * @param quantityOrdered The quantity ordered to set.
     */
    public void setQuantityOrdered(int quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    /**
     * Retrieves the price per unit.
     *
     * @return The price per unit.
     */
    public BigDecimal getPriceEach() {
        return priceEach;
    }

    /**
     * Sets the price per unit.
     *
     * @param priceEach The price per unit to set.
     */
    public void setPriceEach(BigDecimal priceEach) {
        this.priceEach = priceEach;
    }

    /**
     * Retrieves the order line number.
     *
     * @return The order line number.
     */
    public short getOrderLineNumber() {
        return orderLineNumber;
    }

    /**
     * Sets the order line number.
     *
     * @param orderLineNumber The order line number to set.
     */
    public void setOrderLineNumber(short orderLineNumber) {
        this.orderLineNumber = orderLineNumber;
    }
}

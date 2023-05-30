/**
 * This class represents the Product entity.
 * It stores information about products.
 *  
 * @author Ståle Rivelsrud
 * @version 1.0
 */


package com.OBJ2100.ExampleApp.db;
import java.math.BigDecimal;

public class Products {
	private String productCode, productName, productLine, productScale, productVendor, productDescription;
	private short quantityInStock;
	private BigDecimal buyPrice, MSRP;

    /**
     * Constructs a Products object.
     *
     * @param productCode        The product code.
     * @param productName        The product name.
     * @param productLine        The product line.
     * @param productScale       The product scale.
     * @param productVendor      The product vendor.
     * @param productDescription The product description.
     * @param quantityInStock    The quantity in stock.
     * @param buyPrice           The buy price.
     * @param MSRP               The manufacturer's suggested retail price.
     */	
	public Products (String productCode, String productName, String productLine, String productScale, String productVendor, String productDescription, short quantityInStock, BigDecimal buyPrice, BigDecimal MSRP) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.productLine = productLine;
		this.productScale = productScale;
		this.productVendor = productVendor;
		this.productDescription = productDescription;
		this.quantityInStock =  quantityInStock;
		this.buyPrice = buyPrice;
		this.MSRP = MSRP;
	}


    /**
     * Retrieves the product code.
     *
     * @return The product code.
     */
    public String getProductCode() {
        return productCode;
    }

    /**
     * Sets the product code.
     *
     * @param productCode The product code to set.
     */
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    /**
     * Retrieves the product name.
     *
     * @return The product name.
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Sets the product name.
     *
     * @param productName The product name to set.
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * Retrieves the product line.
     *
     * @return The product line.
     */
    public String getProductLine() {
        return productLine;
    }

    /**
     * Sets the product line.
     *
     * @param productLine The product line to set.
     */
    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    /**
     * Retrieves the product scale.
     *
     * @return The product scale.
     */
    public String getProductScale() {
        return productScale;
    }

    /**
     * Sets the product scale.
     *
     * @param productScale The product scale to set.
     */
    public void setProductScale(String productScale) {
        this.productScale = productScale;
    }

    /**
     * Retrieves the product vendor.
     *
     * @return The product vendor.
     */
    public String getProductVendor() {
        return productVendor;
    }

    /**
     * Sets the product vendor.
     *
     * @param productVendor The product vendor to set.
     */
	public void setProductVendor(String productVendor) {
		this.productVendor = productVendor;
	}


	public String getProductDescription() {
		return productDescription;
	}

    /**
     * Sets the product description.
     *
     * @param productDescription The product description to set.
     */
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    /**
     * Retrieves the quantity in stock.
     *
     * @return The quantity in stock.
     */
    public short getQuantityInStock() {
        return quantityInStock;
    }

    /**
     * Sets the quantity in stock.
     *
     * @param quantityInStock The quantity in stock to set.
     */
    public void setQuantityInStock(short quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    /**
     * Retrieves the buy price.
     *
     * @return The buy price.
     */
    public BigDecimal getBuyPrice() {
        return buyPrice;
    }

    /**
     * Sets the buy price.
     *
     * @param buyPrice The buy price to set.
     */
    public void setBuyPrice(BigDecimal buyPrice) {
        this.buyPrice = buyPrice;
    }

    /**
     * Retrieves the manufacturer's suggested retail price (MSRP).
     *
     * @return The MSRP.
     */
    public BigDecimal getMSRP() {
        return MSRP;
    }

    /**
     * Sets the manufacturer's suggested retail price (MSRP).
     *
     * @param MSRP The MSRP to set.
     */
    public void setMSRP(BigDecimal MSRP) {
        this.MSRP = MSRP;
    }
}

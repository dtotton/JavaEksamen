package com.OBJ2100.ExampleApp.db;
import java.math.BigDecimal;

public class Products {
	private String productCode, productName, productLine, productScale, productVendor, productDescription;
	private short quantityInStock;
	private BigDecimal buyPrice, MSRP;

	
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


	public String getProductCode() {
		return productCode;
	}


	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getProductLine() {
		return productLine;
	}


	public void setProductLine(String productLine) {
		this.productLine = productLine;
	}


	public String getProductScale() {
		return productScale;
	}


	public void setProductScale(String productScale) {
		this.productScale = productScale;
	}


	public String getProductVendor() {
		return productVendor;
	}


	public void setProductVendor(String productVendor) {
		this.productVendor = productVendor;
	}


	public String getProductDescription() {
		return productDescription;
	}


	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}


	public short getQuantityInStock() {
		return quantityInStock;
	}


	public void setQuantityInStock(short quantityInStock) {
		this.quantityInStock = quantityInStock;
	}


	public BigDecimal getBuyPrice() {
		return buyPrice;
	}


	public void setBuyPrice(BigDecimal buyPrice) {
		this.buyPrice = buyPrice;
	}


	public BigDecimal getMSRP() {
		return MSRP;
	}


	public void setMSRP(BigDecimal mSRP) {
		MSRP = mSRP;
	}
}

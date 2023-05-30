/**
 * This class represents the Productlines entity.
 * It stores information about productlines.
 * 
 * @author Ståle Rivelsrud
 * @version 1.0
 */


package com.OBJ2100.ExampleApp.db;

public class Productlines {

	private String productLine, textDescription, htmlDescription, image;

    /**
     * Constructs a Productlines object.
     *
     * @param productLine     The product line.
     * @param textDescription The text description of the product line.
     * @param htmlDescription The HTML description of the product line.
     * @param image           The image associated with the product line.
     */
	
	public Productlines (String productLine, String textDescription, String htmlDescription, String image) {
		super();
		this.productLine = productLine;
		this.textDescription = textDescription;
		this.htmlDescription = htmlDescription;
		this.image = image;
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
     * Retrieves the text description of the product line.
     *
     * @return The text description.
     */
    public String getTextDescription() {
        return textDescription;
    }

    /**
     * Sets the text description of the product line.
     *
     * @param textDescription The text description to set.
     */
    public void setTextDescription(String textDescription) {
        this.textDescription = textDescription;
    }

    /**
     * Retrieves the HTML description of the product line.
     *
     * @return The HTML description.
     */
    public String getHtmlDescription() {
        return htmlDescription;
    }

    /**
     * Sets the HTML description of the product line.
     *
     * @param htmlDescription The HTML description to set.
     */
    public void setHtmlDescription(String htmlDescription) {
        this.htmlDescription = htmlDescription;
    }

    /**
     * Retrieves the image associated with the product line.
     *
     * @return The image.
     */
    public String getImage() {
        return image;
    }

    /**
     * Sets the image associated with the product line.
     *
     * @param image The image to set.
     */
    public void setImage(String image) {
        this.image = image;
    }
}

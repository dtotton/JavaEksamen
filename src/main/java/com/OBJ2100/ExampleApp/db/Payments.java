/**
 * This class represents the Payments entity.
 * It stores information about customer payments.
 *
 * @author Ståle Rivelsrud
 * @version 1.0
 */

package com.OBJ2100.ExampleApp.db;

import java.math.BigDecimal;
import java.sql.Date;

public class Payments {
    private int customerNumber;
    private String checkNumber;
    private Date paymentDate;
    private BigDecimal amount;

    /**
     * Constructs a Payments object.
     *
     * @param customerNumber The customer number associated with the payment.
     * @param checkNumber    The check number for the payment.
     * @param paymentDate    The date of the payment.
     * @param amount         The amount of the payment.
     */
    public Payments(int customerNumber, String checkNumber, Date paymentDate, BigDecimal amount) {
        super();
        this.customerNumber = customerNumber;
        this.checkNumber = checkNumber;
        this.paymentDate = paymentDate;
        this.amount = amount;
    }

    /**
     * Retrieves the customer number associated with the payment.
     *
     * @return The customer number.
     */
    public int getCustomerNumber() {
        return customerNumber;
    }

    /**
     * Sets the customer number associated with the payment.
     *
     * @param customerNumber The customer number to set.
     */
    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    /**
     * Retrieves the check number for the payment.
     *
     * @return The check number.
     */
    public String getCheckNumber() {
        return checkNumber;
    }

    /**
     * Sets the check number for the payment.
     *
     * @param checkNumber The check number to set.
     */
    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }

    /**
     * Retrieves the date of the payment.
     *
     * @return The payment date.
     */
    public Date getPaymentDate() {
        return paymentDate;
    }

    /**
     * Sets the date of the payment.
     *
     * @param paymentDate The payment date to set.
     */
    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    /**
     * Retrieves the amount of the payment.
     *
     * @return The payment amount.
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Sets the amount of the payment.
     *
     * @param amount The payment amount to set.
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}

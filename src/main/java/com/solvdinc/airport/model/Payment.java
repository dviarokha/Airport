package com.solvdinc.airport.model;

import com.solvdinc.airport.action.IPay;
import com.solvdinc.airport.constant.PaymentMethod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.util.Objects;

public class Payment implements IPay {
    private String paymentID;
    private PaymentMethod method;
    private BigDecimal amount;
    private boolean isPaid;

    public Payment() {
    }

    private static final Logger logger = LogManager.getLogger(Payment.class);

    public Payment(String paymentID, PaymentMethod method, BigDecimal amount, boolean isPaid) {
        this.paymentID = paymentID;
        this.method = method;
        this.amount = amount;
        this.isPaid = isPaid;
    }

    public String getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(String paymentID) {
        this.paymentID = paymentID;
    }

    public PaymentMethod getMethod() {
        return method;
    }

    public void setMethod(PaymentMethod method) {
        this.method = method;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    @Override
    public String toString() {
        return "Payment " +
                "paymentID = " + paymentID + '\'' +
                ", method:" + method + '\'' +
                ", amount " + amount + '\'' +
                ", isPaid=" + isPaid;
    }

    @Override
    public void processPayment() {
        logger.info("Payment Info: " + paymentID + ", " + method + " already completed.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (this.getClass() != o.getClass()) {
            return false;
        }
        Payment payment = (Payment) o;
        return paymentID.equals(payment.paymentID) && isPaid == payment.isPaid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentID, isPaid);
    }

}

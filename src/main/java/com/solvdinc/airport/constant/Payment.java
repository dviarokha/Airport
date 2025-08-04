package com.solvdinc.airport.constant;

import java.math.BigDecimal;
import java.util.Objects;

public record Payment(String paymentID, PaymentMethod method, BigDecimal amount, boolean isPaid) {

    @Override
    public String toString() {
        return "Payment{" +
                "paymentID='" + paymentID + '\'' +
                ", method=" + method +
                ", amount=" + amount +
                ", isPaid=" + isPaid +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return isPaid == payment.isPaid && Objects.equals(paymentID, payment.paymentID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentID, isPaid);
    }
}

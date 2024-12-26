package org.pfragatina.shared.domain;


import java.util.Objects;

public abstract class MoneyValueObject {

    private double value;
    private String currency;

    public MoneyValueObject(double value, String currency) {
        this.value = value;
        this.currency = currency;
    }

    public double value() {
        return value;
    }

    public String currency() {
        return currency;
    }

    @Override
    public String toString() {
        return this.value() + " " + this.currency();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        MoneyValueObject that = (MoneyValueObject) o;
        return Double.compare(value, that.value) == 0 && Objects.equals(currency, that.currency);
    }

    @Override
    public int hashCode() {
        int result = Double.hashCode(value);
        result = 31 * result + Objects.hashCode(currency);
        return result;
    }
}

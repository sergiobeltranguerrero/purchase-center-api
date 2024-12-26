package org.pfragatina.shared.domain;

public abstract class DoubleValueObject {
    double value;

    public DoubleValueObject(double value) {
        this.value = value;
    }

    public double value() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DoubleValueObject)) {
            return false;
        }
        DoubleValueObject that = (DoubleValueObject) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(value);
    }
}

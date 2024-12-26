package org.pfragatina.shared.domain;

public abstract class BooleanValueObject {
    private Boolean value;

    public BooleanValueObject(Boolean value) {
        this.value = value;
    }

    public Boolean value() {
        return value;
    }

    @Override
    public String toString() {
        return this.value().toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BooleanValueObject)) {
            return false;
        }
        BooleanValueObject that = (BooleanValueObject) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}

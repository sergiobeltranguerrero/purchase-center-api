package org.pfragatina.backoffice.inscriptions.application;

import org.pfragatina.backoffice.inscriptions.domain.Inscription;
import org.pfragatina.shared.domain.bus.query.Response;

import java.util.Objects;


public final class InscriptionResponse implements Response {
    private final String id;
    private final String name;
    private final double price;
    private final int memberNumber;
    private final boolean isDouble;

    public InscriptionResponse(String id, String name, double price, int memberNumber, boolean isDouble) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.memberNumber = memberNumber;
        this.isDouble = isDouble;
    }

    public static InscriptionResponse fromAggregate(Inscription inscription) {
        return new InscriptionResponse(inscription.id().value(), inscription.name().value(),
                inscription.price().value(), inscription.memberNumber().value(), inscription.isDouble().value());
    }

    public String id() {
        return id;
    }

    public String name() {
        return name;
    }

    public double price() {
        return price;
    }

    public int memberNumber() {
        return memberNumber;
    }

    public boolean isDouble() {
        return isDouble;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        InscriptionResponse that = (InscriptionResponse) o;
        return Math.abs(price - that.price) < 0.00001 &&
                memberNumber == that.memberNumber &&
                isDouble == that.isDouble &&
                Objects.equals(id, that.id) &&
                Objects.equals(name, that.name);
    }


    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(name);
        result = 31 * result + Double.hashCode(price);
        result = 31 * result + memberNumber;
        result = 31 * result + Boolean.hashCode(isDouble);
        return result;
    }

}

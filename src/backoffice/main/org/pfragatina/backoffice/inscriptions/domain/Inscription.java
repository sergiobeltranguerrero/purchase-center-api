package org.pfragatina.backoffice.inscriptions.domain;

import org.pfragatina.shared.domain.AggregateRoot;

import java.util.Objects;

public final class Inscription extends AggregateRoot {
    private final InscriptionId id;
    private final InscriptionName name;
    private final InscriptionPrice price;
    private final InscriptionMemberNumber memberNumber;
    private final InscriptionIsDouble isDouble;

    public Inscription(InscriptionId id, InscriptionName name, InscriptionPrice price,
                       InscriptionMemberNumber memberNumber, InscriptionIsDouble isDouble) {

        this.id = id;
        this.name = name;
        this.price = price;
        this.memberNumber = memberNumber;
        this.isDouble = isDouble;
    }

    private Inscription() {
        this.id = null;
        this.name = null;
        this.price = null;
        this.memberNumber = null;
        this.isDouble = null;
    }

    public static Inscription create(InscriptionId id, InscriptionName name, InscriptionMemberNumber memberNumber,
                                     InscriptionIsDouble isDouble) {

        InscriptionPrice price = InscriptionPriceCalculator.calculate(isDouble);

        Inscription inscription = new Inscription(id, name, price, memberNumber, isDouble);
        inscription.record(new InscriptionCreatedDomainEvent(id.value(), name.value(), price.value(),
                memberNumber.value(), isDouble.value()));

        return inscription;
    }

    public InscriptionId id() {
        return id;
    }

    public InscriptionName name() {
        return name;
    }

    public InscriptionPrice price() {
        return price;
    }

    public InscriptionMemberNumber memberNumber() {
        return memberNumber;
    }

    public InscriptionIsDouble isDouble() {
        return isDouble;
    }

    @Override
    public String toString() {
        return "Inscription{" +
                "id=" + id +
                ", name=" + name +
                ", price=" + price +
                ", memberNumber=" + memberNumber +
                ", isDouble=" + isDouble +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Inscription that = (Inscription) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(price, that.price) &&
                Objects.equals(memberNumber, that.memberNumber) &&
                Objects.equals(isDouble, that.isDouble);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, memberNumber, isDouble);
    }
}

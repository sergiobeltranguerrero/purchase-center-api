package org.pfragatina.backoffice.inscriptions.domain;

import org.pfragatina.shared.domain.bus.event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public final class InscriptionCreatedDomainEvent extends DomainEvent {
    private final String name;
    private final double price;
    private final int memberNumber;
    private final boolean isDouble;

    public InscriptionCreatedDomainEvent() {
        super(null);
        this.name = null;
        this.price = 0;
        this.memberNumber = 0;
        this.isDouble = false;
    }

    public InscriptionCreatedDomainEvent(String aggregateId, String name, double price, int memberNumber,
                                         boolean isDouble) {
        super(aggregateId);
        this.name = name;
        this.price = price;
        this.memberNumber = memberNumber;
        this.isDouble = isDouble;
    }

    public InscriptionCreatedDomainEvent(String aggregateId, String eventId, String occurredOn, String name,
                                         double price,
                                         int memberNumber, boolean isDouble) {
        super(aggregateId, eventId, occurredOn);
        this.name = name;
        this.price = price;
        this.memberNumber = memberNumber;
        this.isDouble = isDouble;
    }

    @Override
    public String eventName() {
        return "inscription.created";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<String, Serializable>() {{
            put("name", name);
            put("price", price);
            put("memberNumber", memberNumber);
            put("isDouble", isDouble);
        }};
    }

    @Override
    public DomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId,
                                      String occurredOn) {
        return new InscriptionCreatedDomainEvent(
                aggregateId,
                eventId,
                occurredOn,
                (String) body.get("name"),
                (double) body.get("price"),
                (int) body.get("memberNumber"),
                (boolean) body.get("isDouble")
        );
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

        InscriptionCreatedDomainEvent that = (InscriptionCreatedDomainEvent) o;
        return memberNumber == that.memberNumber &&
                isDouble == that.isDouble &&
                Objects.equals(name, that.name) &&
                Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, memberNumber, isDouble);
    }
}

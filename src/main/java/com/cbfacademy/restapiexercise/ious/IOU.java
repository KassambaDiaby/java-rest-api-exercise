package com.cbfacademy.restapiexercise.ious;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public class IOU {
    private final UUID id;// unique identifier for the IOU
    private String borrower;// name of borrower
    private String lender;// name of lender
    private BigDecimal amount;// amount covered by IOU
    private Instant dateTime;// date and time of IOU being issued

    // id isn't included as a paramater in constructor because we will not create
    // the id's
    // ourselves when creating objects, we will instead generate it / automatic
    // generation of unique id for each IOU object.
    public IOU(String borrower, String lender, BigDecimal amount, Instant datetime) {
        this.id = UUID.randomUUID();// generate new ID each time
        this.borrower = borrower;
        this.lender = lender;
        this.amount = amount;
        this.dateTime = datetime;
    }

    public UUID getID() {
        return id;
    }

    public String getBorrower() {
        return borrower;
    }

    public String getLender() {
        return lender;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Instant getDateTime() {
        return dateTime;
    }
}

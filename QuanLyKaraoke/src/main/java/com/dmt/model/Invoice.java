package com.dmt.model;

import java.sql.Date;

public class Invoice {
    private int id;
    private int customerId;
    private int roomId;
    private Date startDate;

    public Invoice(int id, int customerId, int roomId, Date startDate ) {
        this.id = id;
        this.customerId = customerId;
        this.roomId = roomId;
        this.startDate = startDate;
    }

    // Getter and Setter methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

}

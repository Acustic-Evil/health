package com.travelAgency.Kursovaya.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Booking{

    private @Id @GeneratedValue(strategy = GenerationType.AUTO) Long id_booking;

    //TODO: id_room
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_room")
    private Room room;

    private String guest_full_name;
    private String guest_email;
    private String guest_phone;
    private Date checkin_date;
    private Date checkout_date;

    public Booking() {
    }

    public Booking(String guest_full_name, String guest_email, String guest_phone, Date checkin_date, Date checkout_date) {
        this.guest_full_name = guest_full_name;
        this.guest_email = guest_email;
        this.guest_phone = guest_phone;
        this.checkin_date = checkin_date;
        this.checkout_date = checkout_date;
    }

    public Long getId_booking() {
        return id_booking;
    }

    public void setId_booking(Long id_booking) {
        this.id_booking = id_booking;
    }

    public String getGuest_full_name() {
        return guest_full_name;
    }

    public void setGuest_full_name(String guest_full_name) {
        this.guest_full_name = guest_full_name;
    }

    public String getGuest_email() {
        return guest_email;
    }

    public void setGuest_email(String guest_email) {
        this.guest_email = guest_email;
    }

    public String getGuest_phone() {
        return guest_phone;
    }

    public void setGuest_phone(String guest_phone) {
        this.guest_phone = guest_phone;
    }

    public Date getCheckin_date() {
        return checkin_date;
    }

    public void setCheckin_date(Date checkin_date) {
        this.checkin_date = checkin_date;
    }

    public Date getCheckout_date() {
        return checkout_date;
    }

    public void setCheckout_date(Date checkout_date) {
        this.checkout_date = checkout_date;
    }
}


package com.travelAgency.Kursovaya.entity;

import javax.persistence.*;

@Entity
@Table
public class Room {

    @OneToOne(mappedBy="room", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Booking booking;

    private @Id @GeneratedValue(strategy = GenerationType.AUTO) int id_room;
    private boolean occupied;
    private String number_of_bedrooms;
    @Column(unique = true)
    private String room_number;
    private String luxury_level;

    public Room() {
    }
    public int getId_room() {
        return id_room;
    }

    public void setId_room(int id_room) {
        this.id_room = id_room;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public String getNumber_of_bedrooms() {
        return number_of_bedrooms;
    }

    public void setNumber_of_bedrooms(String number_of_bedrooms) {
        this.number_of_bedrooms = number_of_bedrooms;
    }

    public String getRoom_number() {
        return room_number;
    }

    public void setRoom_number(String room_number) {
        this.room_number = room_number;
    }

    public String getLuxury_level() {
        return luxury_level;
    }

    public void setLuxury_level(String luxury_level) {
        this.luxury_level = luxury_level;
    }


    public Room(boolean occupied, String number_of_bedrooms, String room_number, String luxury_level) {
        this.occupied = occupied;
        this.number_of_bedrooms = number_of_bedrooms;
        this.room_number = room_number;
        this.luxury_level = luxury_level;
    }
}


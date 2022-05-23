package com.jerryboot.springbootdemo.model;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "Room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RoomID")
    private Integer roomId;

    @Column(name = "RoomName")
    private String roomName;

    @Column(name = "Price")
    private String price;

    @Column(name = "Tag")
    private String tag;

    @Column(name = "Upper_limit")
    private Integer upperLimit;

    @Column(name = "Description")
    private String description;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "HotelID")
    private Hotel hotel;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "room", cascade = CascadeType.ALL)
    private Set<Booking> booking = new LinkedHashSet<Booking>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "room", cascade = CascadeType.ALL)
    private Set<Comment> comment = new LinkedHashSet<Comment>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "room", cascade = CascadeType.ALL)
    private Set<RoomImg> roomImg = new LinkedHashSet<RoomImg>();


    public Room() {
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Integer getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(Integer upperLimit) {
        this.upperLimit = upperLimit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Set<Booking> getBooking() {
        return booking;
    }

    public void setBooking(Set<Booking> booking) {
        this.booking = booking;
    }

    public Set<Comment> getComment() {
        return comment;
    }

    public void setComment(Set<Comment> comment) {
        this.comment = comment;
    }

    public Set<RoomImg> getRoomImg() {
        return roomImg;
    }

    public void setRoomImg(Set<RoomImg> roomImg) {
        this.roomImg = roomImg;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Room [roomId=");
        builder.append(roomId);
        builder.append(", roomName=");
        builder.append(roomName);
        builder.append(", price=");
        builder.append(price);
        builder.append(", tag=");
        builder.append(tag);
        builder.append(", upperLimit=");
        builder.append(upperLimit);
        builder.append(", description=");
        builder.append(description);
        builder.append(", hotel=");
        builder.append(hotel);
        builder.append(", booking=");
        builder.append(booking);
        builder.append(", comment=");
        builder.append(comment);
        builder.append(", roomImg=");
        builder.append(roomImg);
        builder.append("]");
        return builder.toString();
    }

}

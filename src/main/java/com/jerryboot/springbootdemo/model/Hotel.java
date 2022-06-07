package com.jerryboot.springbootdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "Hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HotelID")
    private Integer hotelId;

    @Column(name = "Name")
    private String hotelName;

    @Column(name = "Description")
    private String description;

    @Column(name = "Address")
    private String add;

    @Column(name = "Px")
    private String px;

    @Column(name = "Py")
    private String py;

    @Column(name = "Region")
    private String region;

    @Column(name = "Town")
    private String town;

    @Column(name = "Tel")
    private String Tel;

    @Column(name = "Pics")
    private String pics;

    @Column(name = "PicDIscribe")
    private String picDIscribe;

    @Column(name = "Serviceinfo")
    private String serviceinfo;

    @Column(name = "Parkinginfo")
    private String parkinginfo;

    @Column(name = "TotalNumberofRooms")
    private Integer totalNumberofRooms;

    @Column(name = "LowestPrice")
    private Integer lowestPrice;

    @Column(name = "CeilingPrice")
    private Integer ceilingPrice;

    @Column(name = "HotelAccount")
    private String HotelAccount;

    @Column(name = "HotelPassword")
    private String HotelPassword;


    @Column(name = "AverageRating")
    private Double AverageRating;


    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "hotel", cascade = CascadeType.ALL)
    private Set<Room> room = new LinkedHashSet<Room>();


    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "hotel", cascade = CascadeType.ALL)
    private Set<Comment> comment = new LinkedHashSet<Comment>();


    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "hotel", cascade = CascadeType.ALL)
    private Set<Booking> booking = new LinkedHashSet<Booking>();

    public Hotel() {
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        Tel = tel;
    }

    public String getPics() {
        return pics;
    }

    public void setPics(String pics) {
        this.pics = pics;
    }

    public String getPicDIscribe() {
        return picDIscribe;
    }

    public void setPicDIscribe(String picDIscribe) {
        this.picDIscribe = picDIscribe;
    }

    public String getServiceinfo() {
        return serviceinfo;
    }

    public void setServiceinfo(String serviceinfo) {
        this.serviceinfo = serviceinfo;
    }

    public String getParkinginfo() {
        return parkinginfo;
    }

    public void setParkinginfo(String parkinginfo) {
        this.parkinginfo = parkinginfo;
    }

    public Integer getTotalNumberofRooms() {
        return totalNumberofRooms;
    }

    public void setTotalNumberofRooms(Integer totalNumberofRooms) {
        this.totalNumberofRooms = totalNumberofRooms;
    }

    public Integer getLowestPrice() {
        return lowestPrice;
    }

    public void setLowestPrice(Integer lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    public Integer getCeilingPrice() {
        return ceilingPrice;
    }

    public void setCeilingPrice(Integer ceilingPrice) {
        this.ceilingPrice = ceilingPrice;
    }

    public String getHotelAccount() {
        return HotelAccount;
    }

    public void setHotelAccount(String hotelAccount) {
        HotelAccount = hotelAccount;
    }

    public String getHotelPassword() {
        return HotelPassword;
    }

    public void setHotelPassword(String hotelPassword) {
        HotelPassword = hotelPassword;
    }

    public double getAverageRating() {
        return AverageRating;
    }

    public void setAverageRating(double averageRating) {
        AverageRating = averageRating;
    }

    public Set<Room> getRoom() {
        return room;
    }

    public void setRoom(Set<Room> room) {
        this.room = room;
    }

    public Set<Comment> getComment() {
        return comment;
    }

    public void setComment(Set<Comment> comment) {
        this.comment = comment;
    }

    public Set<Booking> getBooking() {
        return booking;
    }

    public void setBooking(Set<Booking> booking) {
        this.booking = booking;
    }

    public String getPx() {
        return px;
    }

    public void setPx(String px) {
        this.px = px;
    }

    public String getPy() {
        return py;
    }

    public void setPy(String py) {
        this.py = py;
    }

    public void setAverageRating(Double averageRating) {
        AverageRating = averageRating;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelId=" + hotelId +
                ", hotelName='" + hotelName + '\'' +
                ", description='" + description + '\'' +
                ", add='" + add + '\'' +
                ", px='" + px + '\'' +
                ", py='" + py + '\'' +
                ", region='" + region + '\'' +
                ", town='" + town + '\'' +
                ", Tel='" + Tel + '\'' +
                ", pics='" + pics + '\'' +
                ", picDIscribe='" + picDIscribe + '\'' +
                ", serviceinfo='" + serviceinfo + '\'' +
                ", parkinginfo='" + parkinginfo + '\'' +
                ", totalNumberofRooms=" + totalNumberofRooms +
                ", lowestPrice=" + lowestPrice +
                ", ceilingPrice=" + ceilingPrice +
                ", HotelAccount='" + HotelAccount + '\'' +
                ", HotelPassword='" + HotelPassword + '\'' +
                ", AverageRating=" + AverageRating +
                ", room=" + room +
                ", comment=" + comment +
                ", booking=" + booking +
                '}';
    }
}

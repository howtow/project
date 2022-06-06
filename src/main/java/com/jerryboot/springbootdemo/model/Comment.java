package com.jerryboot.springbootdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Transient;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CommentID")
    private Integer commentId;

    @Column(name = "Comment")
    private String comment;

    @Column(name = "Rating")
    private double rating;

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CommentTime",columnDefinition = "date")
    private Date commentTime;

    public void onCreate(){
        if (commentTime == null){
            commentTime =new Date();
        }
    }


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "UserID")
    private Customer customer;


    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "BookingID")
    private Booking booking;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "HotelID")
    private Hotel hotel;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "RoomID")
    private Room room;

    public Comment() {
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentID) {
        this.commentId = commentID;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }



    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", comment='" + comment + '\'' +
                ", rating=" + rating +
                ", commentTime=" + commentTime +
                ", customer=" + customer +
                ", booking=" + booking +
                ", hotel=" + hotel +
                ", room=" + room +
                '}';
    }
}

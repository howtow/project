package com.jerryboot.springbootdemo.model;

import org.springframework.data.annotation.Transient;

import javax.persistence.*;

@Entity
@Table(name = "Comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CommentID")
    private Integer commentId;

    @Column(name = "Comment")
    private String comment;

    @Column(name = "UserID")
    private Integer userId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "UserID", insertable = false, updatable = false)
    private Customer customer;

    @Column(name = "BookingID")
    private Integer bookingId;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "BookingID", insertable = false, updatable = false)
    private Booking booking;

    @Column(name = "HotelID")
    private Integer hotelId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "HotelID", insertable = false, updatable = false)
    private Hotel hotel;

    @Column(name = "RoomID")
    @Transient
    private Integer roomId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "RoomID", insertable = false, updatable = false)
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userID) {
        this.userId = userID;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingID) {
        this.bookingId = bookingID;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelID) {
        this.hotelId = hotelID;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomID) {
        this.roomId = roomID;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Comment [commentID=");
        builder.append(commentId);
        builder.append(", comment=");
        builder.append(comment);
        builder.append(", userID=");
        builder.append(userId);
        builder.append(", bookingID=");
        builder.append(bookingId);
        builder.append(", hotelID=");
        builder.append(hotelId);
        builder.append(", roomID=");
        builder.append(roomId);
        builder.append("]");
        return builder.toString();
    }

}

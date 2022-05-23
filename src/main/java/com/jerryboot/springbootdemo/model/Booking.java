package com.jerryboot.springbootdemo.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

@Entity
@Table(name = "Booking")
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BookingID")
	private Integer bookingId;
	
	@Column(name = "State")
	private String state;
	
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "BookingTimes" , columnDefinition = "datetime")
	private Date bookingTimes;
	
	@Column(name = "DateOfStay")
	private String dateOfStay;
	
	@Column(name = "Rating")
	private double rating;
	
	@Column(name = "BookingName")
	private String bookingName;

	@Email(message = "請輸入email")
	@Column(name = "Email")
	private String email;

	@Column(name = "CreditCard")
	private String creditCard;
	
	@Column(name = "Annotation")
	private String annotation;
	
	@Column(name = "ArriveTimes")
	private String arriveTimes;
	

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "UserID")
	private Customer customer;
	

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "HotelID")
	private Hotel hotel;
	

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "RoomID")
	private Room room;
	
	@OneToOne(fetch = FetchType.EAGER, mappedBy = "booking", cascade = CascadeType.ALL)
	private Comment comment = new Comment();
	
	public Booking() {
	}

	@PrePersist // 物件狀態轉換到 Persistent 以前，要做的事情
	public void onCreate() {
		if(bookingTimes == null) {
			bookingTimes = new Date();
		}
	}
	
	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingID) {
		this.bookingId = bookingID;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getBookingTimes() {
		return bookingTimes;
	}

	public void setBookingTimes(Date bookingTimes) {
		this.bookingTimes = bookingTimes;
	}

	public String getDateOfStay() {
		return dateOfStay;
	}

	public void setDateOfStay(String dateOfStay) {
		this.dateOfStay = dateOfStay;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getBookingName() {
		return bookingName;
	}

	public void setBookingName(String bookingName) {
		this.bookingName = bookingName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}

	public String getAnnotation() {
		return annotation;
	}

	public void setAnnotation(String annotation) {
		this.annotation = annotation;
	}

	public String getArriveTimes() {
		return arriveTimes;
	}

	public void setArriveTimes(String arriveTimes) {
		this.arriveTimes = arriveTimes;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
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
		StringBuilder builder = new StringBuilder();
		builder.append("Booking [bookingId=");
		builder.append(bookingId);
		builder.append(", state=");
		builder.append(state);
		builder.append(", bookingTimes=");
		builder.append(bookingTimes);
		builder.append(", dateOfStay=");
		builder.append(dateOfStay);
		builder.append(", rating=");
		builder.append(rating);
		builder.append(", bookingName=");
		builder.append(bookingName);
		builder.append(", email=");
		builder.append(email);
		builder.append(", creditCard=");
		builder.append(creditCard);
		builder.append(", annotation=");
		builder.append(annotation);
		builder.append(", arriveTimes=");
		builder.append(arriveTimes);
		builder.append(", customer=");
		builder.append(customer);
		builder.append(", hotel=");
		builder.append(hotel);
		builder.append(", room=");
		builder.append(room);
		builder.append(", comment=");
		builder.append(comment);
		builder.append("]");
		return builder.toString();
	}

}

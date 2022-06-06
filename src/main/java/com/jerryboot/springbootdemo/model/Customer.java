package com.jerryboot.springbootdemo.model;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UserID")
	private Integer userId;

	@Column(name = "Email")
	private String email;
	
	@Column(name = "Password")
	private String password;
	
	@Column(name = "UserName")
	@NotEmpty(message = "請輸入名字")
	private String userName;
	
	@Column(name = "Phone")
	private Integer phone;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "Birthday", columnDefinition = "date")
	private Date birthday;
	
	@Column(name = "Nationality")
	private String nationality;
	
	@Column(name = "Gender")
	private String gender;
	
	@Column(name = "Address")
	private String address;
	
	@Column(name = "CreditCard")
	@CreditCardNumber
	private String creditCard;
	
	@Column(name = "State")
	private String state;

	@Column(name = "Enabled")
	private Boolean enabled;

	@Column(name = "Salt")
	private Integer salt;

	@Column(name = "Verification_code")
	private String verificationCode;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer", cascade = CascadeType.ALL)
	private Set<Comment> comment = new LinkedHashSet<Comment>();

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer", cascade = CascadeType.ALL)
	private Set<Booking> booking = new LinkedHashSet<Booking>();

	public Customer() {
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Integer getSalt() {
		return salt;
	}

	public void setSalt(Integer salt) {
		this.salt = salt;
	}

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
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

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Customer{");
		sb.append("userId=").append(userId);
		sb.append(", email='").append(email).append('\'');
		sb.append(", password='").append(password).append('\'');
		sb.append(", userName='").append(userName).append('\'');
		sb.append(", phone=").append(phone);
		sb.append(", birthday=").append(birthday);
		sb.append(", nationality='").append(nationality).append('\'');
		sb.append(", gender='").append(gender).append('\'');
		sb.append(", address='").append(address).append('\'');
		sb.append(", creditCard='").append(creditCard).append('\'');
		sb.append(", state='").append(state).append('\'');
		sb.append(", enabled=").append(enabled);
		sb.append(", salt=").append(salt);
		sb.append(", verificationCode='").append(verificationCode).append('\'');
		sb.append(", comment=").append(comment);
		sb.append(", booking=").append(booking);
		sb.append('}');
		return sb.toString();
	}
}

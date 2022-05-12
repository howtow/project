package com.jerryboot.springbootdemo.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RoomImg")
public class RoomImg {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RoomImgID")
	private Integer roomImgId;
	
	@Column(name = "RoomID")
	private Integer roomId;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "RoomID",insertable = false, updatable = false)
	private Room room;
	
	@Lob
	@Column(name = "Img")
	private byte[] img;
	
	@Column(name = "ImgDescribe")
	private String imgDescribe;
	
	public RoomImg() {
	}

	public Integer getRoomImgId() {
		return roomImgId;
	}

	public void setRoomImgId(Integer roomImgId) {
		this.roomImgId = roomImgId;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}

	public String getImgDescribe() {
		return imgDescribe;
	}

	public void setImgDescribe(String imgDescribe) {
		this.imgDescribe = imgDescribe;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RoomImg [roomImgId=");
		builder.append(roomImgId);
		builder.append(", roomId=");
		builder.append(roomId);
		builder.append(", img=");
		builder.append(Arrays.toString(img));
		builder.append(", imgDescribe=");
		builder.append(imgDescribe);
		builder.append("]");
		return builder.toString();
	}

}

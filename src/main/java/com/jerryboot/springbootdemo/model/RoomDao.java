package com.jerryboot.springbootdemo.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomDao extends JpaRepository<Room,Integer> {
}

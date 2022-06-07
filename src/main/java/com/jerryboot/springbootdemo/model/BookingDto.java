package com.jerryboot.springbootdemo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class BookingDto implements Serializable {

    @JsonProperty("state")
    private String state;

    public BookingDto() {
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

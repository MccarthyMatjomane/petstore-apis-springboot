package com.redwoodgroup.petstore.dto;

import java.time.LocalDateTime;

public class PetWithoutDate {
    private String name;
    private int status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

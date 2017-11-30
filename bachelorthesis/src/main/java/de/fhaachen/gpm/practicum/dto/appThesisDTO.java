package de.fhaachen.gpm.practicum.dto;

import java.io.Serializable;

public class appThesisDTO implements Serializable{
    private int approved;
    private int id;

    public int getApproved() {
        return approved;
    }

    public void setApproved(int approved) {
        this.approved = approved;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

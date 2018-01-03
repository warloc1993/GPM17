package de.fhaachen.gpm.practicum.dto;

import java.io.Serializable;

public class CalculateTotalGradeReturnDTO implements Serializable{

    private boolean success;
    private double average;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }
}
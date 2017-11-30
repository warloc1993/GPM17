package de.fhaachen.gpm.practicum.dto;

import java.io.Serializable;

public class returnDTO implements Serializable {
    private boolean success;
    private int student_id;
    private int thesis_id;

    public int getThesis_id() {
        return thesis_id;
    }

    public void setThesis_id(int thesis_id) {
        this.thesis_id = thesis_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {

        return success;
    }
}

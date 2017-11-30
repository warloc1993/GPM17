package de.fhaachen.gpm.practicum.dto;

import java.io.Serializable;

public class addThesisDTO implements Serializable {
    private String name;
    private String prename;
    private String thesis_title;
    private String supervisor;

    public void setName(String name) {
        this.name = name;
    }

    public void setPrename(String prename) {
        this.prename = prename;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public void setThesis_title(String thesis_title) {
        this.thesis_title = thesis_title;
    }

    public String getName() {
        return name;
    }

    public String getPrename() {
        return prename;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public String getThesis_title() {
        return thesis_title;
    }
}

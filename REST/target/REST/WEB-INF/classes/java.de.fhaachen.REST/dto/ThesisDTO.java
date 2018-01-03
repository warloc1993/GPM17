package main.resources.java.de.fhaachen.REST.dto;
import javax.persistence.*;
import java.io.Serializable;

public class ThesisDTO implements Serializable {
    private String name;
    private String prename;
    private String thesis_title;
    private String supervisor;
    private int approved;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public void setApproved(int approved) {
        this.approved = approved;
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

    public int getApproved() {
        return approved;
    }
}

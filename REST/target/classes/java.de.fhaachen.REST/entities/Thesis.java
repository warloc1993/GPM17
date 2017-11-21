package main.resources.java.de.fhaachen.REST.entities;
import javax.persistence.*;
@Entity
@Table(name = "thesis")
public class Thesis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int student_id;

    @Column
    private String title;

    @Column
    private String supervisor;

    @Column
    private int approved;

    public Thesis() {
    }

    public Thesis(int id, int student_id, String title, String supervisor, int approved) {
        this.id = id;
        this.student_id = student_id;
        this.title = title;
        this.supervisor = supervisor;
        this.approved = approved;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public int getApproved() {
        return approved;
    }

    public void setApproved(int approved) {
        this.approved = approved;
    }}



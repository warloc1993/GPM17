package main.resources.java.de.fhaachen.REST.entities;
import javax.persistence.*;
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private String prename;

    @Column
    private int passed_practice_project;

    @Column
    private int passed_bachelor_thesis;

    @Column
    private int passed_colloquium;

    public Student() {
    }

    public Student(int id, String name, String prename, int passed_practice_project, int passed_bachelor_thesis, int passed_colloquium) {
        this.id = id;
        this.name = name;
        this.prename = prename;
        this.passed_practice_project = passed_practice_project;
        this.passed_bachelor_thesis = passed_bachelor_thesis;
        this.passed_colloquium = passed_colloquium;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrename() {
        return prename;
    }

    public void setPrename(String prename) {
        this.prename = prename;
    }

    public int getPassed_practice_project() {
        return passed_practice_project;
    }

    public void setPassed_practice_project(int passed_practice_project) {
        this.passed_practice_project = passed_practice_project;
    }

    public int getPassed_bachelor_thesis() {
        return passed_bachelor_thesis;
    }

    public void setPassed_bachelor_thesis(int passed_bachelor_thesis) {
        this.passed_bachelor_thesis = passed_bachelor_thesis;
    }

    public int getPassed_colloquium() {
        return passed_colloquium;
    }

    public void setPassed_colloquium(int passed_colloquium) {
        this.passed_colloquium = passed_colloquium;
    }}




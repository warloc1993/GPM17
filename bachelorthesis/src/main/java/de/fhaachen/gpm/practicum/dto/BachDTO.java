package de.fhaachen.gpm.practicum.dto;

public class BachDTO {
    private String name;
    private String prename;
    private int Passed_bachelor_thesis;

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

    public int getPassed_bachelor_thesis() {
        return Passed_bachelor_thesis;
    }

    public void setPassed_bachelor_thesis(int passed_bachelor_thesis) {
        Passed_bachelor_thesis = passed_bachelor_thesis;
    }
}

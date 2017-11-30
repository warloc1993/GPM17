package de.fhaachen.gpm.practicum.dto;

public class CollDTO {
    private String name;
    private String prename;
    private int Passed_colloquium;

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

    public int getPassed_colloquium() {
        return Passed_colloquium;
    }

    public void setPassed_colloquium(int passed_colloquium) {
        Passed_colloquium = passed_colloquium;
    }
}

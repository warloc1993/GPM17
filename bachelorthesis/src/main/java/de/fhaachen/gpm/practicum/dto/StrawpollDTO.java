package de.fhaachen.gpm.practicum.dto;

public class StrawpollDTO {
    private String title;
    private String[] options =new String[2];

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }
}

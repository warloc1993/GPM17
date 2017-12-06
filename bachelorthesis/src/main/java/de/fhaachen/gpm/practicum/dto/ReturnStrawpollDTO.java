package de.fhaachen.gpm.practicum.dto;

public class ReturnStrawpollDTO {
    private int id;
    private String title;
    private String[] options;
    private Integer[] votes;
    private boolean captcha;
    private String dupcheck;
    private boolean multi;

    public boolean isMulti() {
        return multi;
    }

    public void setMulti(boolean multi) {
        this.multi = multi;
    }

    public String getDupcheck() {
        return dupcheck;
    }

    public void setDupcheck(String dupcheck) {
        this.dupcheck = dupcheck;
    }

    public boolean isCaptcha() {
        return captcha;
    }

    public void setCaptcha(boolean captcha) {
        this.captcha = captcha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Integer[] getVotes() {
        return votes;
    }

    public void setVotes(Integer[] votes) {
        this.votes = votes;
    }
}

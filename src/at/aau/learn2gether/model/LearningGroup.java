package at.aau.learn2gether.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LearningGroup implements Comparable<LearningGroup> {

    private Course lv;
    private String description;
    private Date date;
    private Room room;
    private Boolean isSelected;

    public Course getLv() {
        return lv;
    }

    public LearningGroup setLv(Course lv) {
        this.lv = lv;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public LearningGroup setDescription(String description) {
        this.description = description;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public LearningGroup setDate(Date date) {
        this.date = date;
        return this;
    }

    public Room getRoom() {
        return room;
    }

    public LearningGroup setRoom(Room room) {
        this.room = room;
        return this;
    }

    public Boolean isSelected() {
        return isSelected;
    }

    public LearningGroup setSelected(Boolean selected) {
        isSelected = selected;
        return this;
    }

    public String getDateFormatted() {
        return new SimpleDateFormat("E, dd.MM.yyy").format(this.date).toString();
    }

    @Override
    public int compareTo(LearningGroup o) {
        return this.date.compareTo(o.getDate());
    }
}
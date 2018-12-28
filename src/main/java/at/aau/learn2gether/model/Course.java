package at.aau.learn2gether.model;

public class Course {

    private String number;
    private String title;
    private String type;

    public String getNumber() {
        return number;
    }

    public Course setNumber(String number) {
        this.number = number;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Course setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getType() {
        return type;
    }

    public Course setType(String type) {
        this.type = type;
        return this;
    }

    @Override
    public String toString() {
        return String.format("%s %s [%s]", this.number, this.title, this.type);
    }
}
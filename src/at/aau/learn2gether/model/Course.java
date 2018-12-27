package at.aau.learn2gether.model;

public class Course {

    private String number;
    private String title;
    private String typ;

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

    public String getTyp() {
        return typ;
    }

    public Course setTyp(String typ) {
        this.typ = typ;
        return this;
    }

    @Override
    public String toString() {
        return String.format("%s %s [%s]", this.number, this.title, this.typ);
    }
}
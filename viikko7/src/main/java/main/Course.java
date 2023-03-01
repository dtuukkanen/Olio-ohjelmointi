package main;

public class Course implements PrintInfo {
    private int maxNumberOfStudents;
    private String name;
    private String id;

    public Course (int maxNumberOfStudents, String name, String id) {
        this.maxNumberOfStudents = maxNumberOfStudents;
        this.name = name;
        this.id = id;
    }

    public String getInformation() {
        String information = id + " " + name;
        return information;
    }
}

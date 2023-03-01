package main;

import java.util.ArrayList;

public class Gifu {
    private String university;
    private ArrayList<Course> courses = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Enrollment> enrollments = new ArrayList<>();

    public Gifu(String university) {
        this.university = university;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    //public Course getCourse(int id)

    //public ArrayList getCourses()

    public void listCourses() {
        int i = 0;
        for (Course course : courses) {
            System.out.println(i + ") " + course.getInformation());
            i++;
        }
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void listStudents() {
        int i = 0;
        for (Student student : students) {
            System.out.println(i + ") " + student.getInformation());
            i++;
        }
    }
}

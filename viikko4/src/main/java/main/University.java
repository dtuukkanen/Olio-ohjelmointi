package main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class University {
    final private String FILENAME;
    private ArrayList<Student> students = new ArrayList<>();

    public University() {
        FILENAME = "students.data";
    }

    public void addStudent(Student newStudent) {
        students.add(newStudent);
    }

    public void listStudents() {
        System.out.println("Opiskelijat:");
        for (Student student : students) {
            student.printSpecs();
        }
    }

    public void listStudentsIndexed() {
        int i = 0;
        for (Student student : students) {
            System.out.println(i + ": " + student.getName());
            i++;
        }
    }

    public Student getStudent(int chosen) {
        return students.get(chosen);
    }

    public void listStudies(Student student) {
        student.printStudies();
    }

    public void saveStudents() {
        try {
            ObjectOutputStream studentWriter = new ObjectOutputStream(new FileOutputStream(FILENAME));
            studentWriter.writeObject(students);
            studentWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadStudents() {
        try {
            ObjectInputStream studentReader = new ObjectInputStream(new FileInputStream(FILENAME));
            students = (ArrayList<Student>) studentReader.readObject();
            studentReader.close();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
}

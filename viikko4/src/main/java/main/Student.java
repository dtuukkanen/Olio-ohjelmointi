package main;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

public class Student implements Serializable {
    private String name;
    private String studentNumber;
    private LinkedHashMap<String, Integer> studies = new LinkedHashMap<String, Integer>();

    public Student(String name, String studentNumber) {
        this.name = name;
        this.studentNumber = studentNumber;
    }

    public void printSpecs() {
        System.out.println(studentNumber + ": " + name);
    }

    public String getName() {
        return name;
    }

    public double countAverage() {
        // Return 0.0 if no items in hashmap
        if (studies.isEmpty()) { 
            return 0.0; 
        }
        double summa = 0;
        int amount = 0;
        Set<String> keys = studies.keySet();
        for (String key : keys) {
            summa += studies.get(key);
            amount++;
        }
        double average = summa / amount;
        return average;
    }

    public double countMedian() {
        // Return 0.0 if no items in hashmap
        if (studies.isEmpty()) { 
            return 0.0; 
        }
        // Add grades to seperate list
        ArrayList<Integer> grades = new ArrayList<>();
        Set<String> keys = studies.keySet();
        for (String key : keys) {
            grades.add(studies.get(key));
        }
        // Sort grades
        Collections.sort(grades);
        // Count median
        int mid = grades.size() / 2;
        if (grades.size() % 2 == 0) {
            return (grades.get(mid) + grades.get(mid - 1)) / 2.0;
        }
        return grades.get(mid);
    }
    
    public void addGrade(String course, int grade) {
        studies.put(course, grade);
    }

    public void printStudies() {
        Set<String> keys = studies.keySet();
        for (String key : keys) {
            String course = key;
            int grade = studies.get(key);
            System.out.println(course + ": " + grade);
        }
    }
}
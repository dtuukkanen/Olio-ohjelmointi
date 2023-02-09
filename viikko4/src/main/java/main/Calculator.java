package main;

public class Calculator {

    public double getAverageGrade(Student student) {
        return student.countAverage();
    }

    public double getMedianGrade(Student student) {
        return student.countMedian();
    }
}


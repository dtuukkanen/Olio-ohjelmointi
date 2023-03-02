package main;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in); 

        String input;
        int option;
        Boolean exit = false;
        Gifu sisu = null;
        Student student;
        Course course;
        int index;
        ArrayList<Enrollment> courses;
        ArrayList<Enrollment> students;

        System.out.println("Tervetuloa Gifu-järjestelmään");
        System.out.println("Mille yliopistolle haluat ottaa järjestelmän käyttöön?");
        input = sc.nextLine();
        sisu = new Gifu(input);

        while(!exit) {
            System.out.print("1) Luo uusi kurssi, ");
            System.out.print("2) Luo uusi opiskelija, ");
            System.out.print("3) Listaa kurssit, ");
            System.out.print("4) Listaa opiskelijat, ");
            System.out.print("5) Lisää opiskelija kurssille, ");
            System.out.print("6) Anna kurssiarvosanat, ");
            System.out.print("7) Listaa kurssilla olevat opiskelijat, ");
            System.out.print("8) Listaa opiskelijan arvosanat, ");
            System.out.print("9) Listaa kaikkien kurssien kaikkien opiskelijoiden arvosanat, ");
            System.out.println("0) Lopeta ohjelma");
            option = Integer.parseInt(sc.nextLine());

            switch(option) {
                case 1:
                    System.out.println("Anna kurssin nimi:");
                    String courseName = sc.nextLine();
                    System.out.println("Anna kurssin ID:");
                    String courseId = sc.nextLine();
                    System.out.println("Anna kurssin maksimi opiskelijamäärä:");
                    int courseAmountOfStudents = Integer.parseInt(sc.nextLine());
                    course = new Course(courseName, courseId, courseAmountOfStudents);
                    sisu.addCourse(course);
                    break;
                case 2:
                    System.out.println("Anna opiskelijan nimi:");
                    String studentName = sc.nextLine();
                    System.out.println("Anna opiskelijan opiskelijanumero:");
                    String studentId = sc.nextLine();
                    student = new Student(studentName, studentId);
                    sisu.addStudent(student);
                    break;
                case 3:
                    sisu.listCourses();
                    break;
                case 4:
                    sisu.listStudents();
                    break;
                case 5:
                    sisu.listCourses();
                    System.out.println("Mille kurssille haluat lisätä opiskelijan? Syötä kurssin numero:");
                    index = Integer.parseInt(sc.nextLine());
                    course = sisu.getCourse(index);
                    sisu.listStudents();
                    System.out.println("Minkä opiskelijan haluat lisätä kurssille? Syötä opiskelijan numero:");
                    index = Integer.parseInt(sc.nextLine());
                    student = sisu.getStudent(index);
                    sisu.enrollStudent(student, course);
                    break;
                case 6:
                    sisu.listCourses();
                    System.out.println("Minkä kurssin haluat arvostella? Syötä kurssin numero:");
                    index = Integer.parseInt(sc.nextLine());
                    course = sisu.getCourse(index);
                    students = sisu.getEnrollments(course);
                    for (Enrollment enrollment : students) {
                        student = enrollment.getStudent();
                        System.out.println("Anna arvosana opiskelijalle " + student.getInformation());
                        int grade = Integer.parseInt(sc.nextLine());
                        enrollment.gradeCourse(grade);
                    }
                    break;
                case 7:
                    sisu.listCourses();
                    System.out.println("Minkä kurssin opiskelijat haluat listata? Syötä kurssin numero:");
                    index = Integer.parseInt(sc.nextLine());
                    course = sisu.getCourse(index);
                    students = sisu.getEnrollments(course);
                    for (Enrollment enrollment : students) {
                        student = enrollment.getStudent();
                        System.out.println(student.getInformation() + ", arvosana: " + enrollment.getGrade());
                    }
                    break;
                case 8:
                    sisu.listStudents();
                    System.out.println("Minkä opiskelijan arvosanat haluat listata? Syötä opiskelijan numero:");
                    index = Integer.parseInt(sc.nextLine());
                    student = sisu.getStudent(index);
                    courses = sisu.getEnrollments(student);
                    System.out.println("Opiskelijan " + student.getInformation() + " arvosanat:");
                    for (Enrollment enrollment : courses) {
                        course = enrollment.getCourse();
                        System.out.println(course.getInformation() + ", arvosana: " + enrollment.getGrade());
                    }
                    break;
                case 9:
                    for (Course courseInCourses : sisu.getCourses()) {
                        courses = sisu.getEnrollments(courseInCourses);
                        System.out.println(courseInCourses.getInformation());
                        for (Enrollment enrollment : courses) {
                            student = enrollment.getStudent();
                            System.out.println(student.getInformation() + ", arvosana: " + enrollment.getGrade());
                        }
                    }
                    break;
                case 0:
                    exit = true;
                    break;
            }
        }
        System.out.println("Kiitos ohjelman käytöstä.");
        sc.close();
    }
}

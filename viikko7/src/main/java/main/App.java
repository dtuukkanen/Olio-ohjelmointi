package main;

import java.util.Scanner;

public class App {
    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in); 
        String input;
        int option;
        Boolean exit = false;
        Gifu sisu = null;

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
                    Course newCourse = new Course(courseAmountOfStudents, courseName, courseId);
                    sisu.addCourse(newCourse);
                    break;
                case 2:
                    System.out.println("Anna opiskelijan nimi:");
                    String studentName = sc.nextLine();
                    System.out.println("Anna opiskelijan opiskelijanumero:");
                    String studentId = sc.nextLine();
                    Student newStudent = new Student(studentName, studentId);
                    sisu.addStudent(newStudent);
                    break;
                case 3:
                    sisu.listCourses();
                    break;
                case 4:
                    sisu.listStudents();
                    break;
                case 0:
                    System.out.println("Kiitos ohjelman käytöstä.");
                    exit = true;
                    break;
            }
        }
        sc.close();
    }
}

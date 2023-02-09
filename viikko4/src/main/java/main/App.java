package main;

import java.util.Scanner;

public class App {
    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in); // Import scanner

        University university = new University();
        Student student = null;
        Calculator calculator = new Calculator();

        boolean exit = false; // Exit option
        while (!exit) {
            // Menu
            System.out.print("1) Lisää opiskelija, ");
            System.out.print("2) Listaa opiskelijat, ");
            System.out.print("3) Lisää opiskelijalle suorite, ");
            System.out.print("4) Listaa opiskelijan suoritteet, ");
            System.out.print("5) Laske opiskelijan suoritusten keskiarvo, ");
            System.out.print("6) Laske opiskelijan suoritusten mediaani, ");
            System.out.print("7) Tallenna opiskelijat tiedostoon, ");
            System.out.print("8) Lataa opiskelijat tiedostosta, ");
            System.out.println("0) Lopeta ohjelma");
            int option = Integer.parseInt(sc.nextLine());

            switch(option) {
                case 1:
                    System.out.println("Anna opiskelijan nimi?");
                    String name = sc.nextLine();
                    System.out.println("Anna opiskelijan opiskelijanumero:");
                    String studentNumber = sc.nextLine();
                    Student newStudent = new Student(name, studentNumber);
                    university.addStudent(newStudent);
                    break;
                case 2:
                    university.listStudents();
                    break;
                case 3:
                    university.listStudentsIndexed();
                    System.out.println("Mille opiskelijalle suorite lisätään?");
                    int chosen = Integer.parseInt(sc.nextLine());
                    System.out.println("Mille kurssille suorite lisätään?");
                    String course = sc.nextLine();
                    System.out.println("Mikä arvosana kurssille lisätään?");
                    int grade = Integer.parseInt(sc.nextLine());
                    student = university.getStudent(chosen);
                    student.addGrade(course, grade);
                    break;
                case 4:
                    university.listStudentsIndexed();
                    System.out.println("Minkä opiskelijan suoritteet listataan?");
                    chosen = Integer.parseInt(sc.nextLine());
                    student = university.getStudent(chosen);
                    university.listStudies(student);
                    break;
                case 5:
                    university.listStudentsIndexed();
                    System.out.println("Minkä opiskelijan suoritteiden keskiarvo lasketaan?");
                    chosen = Integer.parseInt(sc.nextLine());
                    student = university.getStudent(chosen);
                    System.out.println("Keskiarvo on " + calculator.getAverageGrade(student));
                    break;
                case 6:
                    university.listStudentsIndexed();
                    System.out.println("Minkä opiskelijan suoritteiden mediaani lasketaan?");
                    chosen = Integer.parseInt(sc.nextLine());
                    student = university.getStudent(chosen);
                    System.out.println("Mediaani on " + calculator.getMedianGrade(student));
                    break;
                case 7:
                    university.saveStudents();
                    break;
                case 8:
                    university.loadStudents();
                    break;
                case 0:
                    exit = true;
                    System.out.println("Kiitos ohjelman käytöstä.");
                    break;
                default:
                    System.out.println("Syöte oli väärä");
                    break;
            }
        }
        sc.close();
    }
}

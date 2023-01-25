package main;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in); // Scanner added for inputs
        Hedgehog hedgehog = new Hedgehog(); // Creates hedgehog object with name of "Pikseli" and age of 5

        boolean exit = false; // In case we want to exit we change this value to true
        while(!exit) {
            // Menu we ask every time before doing anything
            System.out.println("1) Pistä siili puhumaan, 2) Luo uusi siili, 3) Juoksuta siiliä, 0) Lopeta ohjelma");
            String stringInput = sc.nextLine();
            int choice = Integer.parseInt(stringInput);

           switch(choice) {
            /* Exit-option */
            case 0:
                System.out.println("Kiitos ohjelman käytöstä.");
                exit = true;
                break;
            /* Make hedgehog speak */
            case 1:
                System.out.println("Mitä siili sanoo:");
                stringInput = sc.nextLine();
                hedgehog.speak(stringInput);
                break;
            /* Change values of hedgehog object */
            case 2:
                System.out.println("Anna siilin nimi:");
                String name = sc.nextLine();
                System.out.println("Anna siilin ikä:");
                stringInput = sc.nextLine();
                int age = Integer.parseInt(stringInput);
                hedgehog = new Hedgehog(name, age);
                break;
            /* Make hedgehog run as many rounds as you want */
            case 3:
                System.out.println("Kuinka monta kierrosta?");
                stringInput = sc.nextLine();
                int rounds = Integer.parseInt(stringInput);
                hedgehog.run(rounds);
                break;
            /* Choice was unknown */
            default:
                System.out.println("Syöte oli väärä");
                break;
           }
        }
    sc.close(); // Close scanner
    }
}

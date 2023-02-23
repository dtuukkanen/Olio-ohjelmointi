package main;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in); // Scanner added for inputs

        // Give name to the zoo
        System.out.println("Anna eläintarhalle nimi:");
        String zooName = sc.nextLine(); 
        Zoo zoo = new Zoo(zooName);

        boolean exit = false; // In case we want to exit we change this value to true
        while(!exit) {
            // Menu we ask every time before doing anything
            System.out.println("1) Luo uusi eläin, 2) Listaa kaikki eläimet, 3) Juoksuta eläimiä, 0) Lopeta ohjelma");
            String stringInput = sc.nextLine();
            int choice = Integer.parseInt(stringInput);

           switch(choice) {
            /* Exit-option */
            case 0:
                System.out.println("Kiitos ohjelman käytöstä.");
                exit = true;
                break;
            /* Add new animal to zoo */
            case 1:
                System.out.println("Mikä laji?");
                String species = sc.nextLine();
                System.out.println("Anna eläimen nimi:");
                String name = sc.nextLine();
                System.out.println("Anna eläimen ikä:");
                int age = Integer.parseInt(sc.nextLine());

                Animal newAnimal = new Animal(species, name, age);
                zoo.addAnimal(newAnimal);
                break;
            /* List animals in zoo */
            case 2:
                zoo.listAnimals();
                break;
            /* Make animals run in zoo */
            case 3:
                System.out.println("Kuinka monta kierrosta?");
                int rounds = Integer.parseInt(sc.nextLine());
                zoo.runAnimals(rounds);
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

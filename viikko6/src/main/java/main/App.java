package main;

import java.util.ArrayList;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        Vehicle newVehicle = null;
        
        boolean exit = false;
        while(!exit) {
            System.out.println("1) Luo uusi kulkuneuvo, 2) Listaa kulkuneuvot 3) Aja autoja, 4) Lennä lentokoneita, 5) Seilaa laivoja, 0) Lopeta ohjelma");
            int option = Integer.parseInt(sc.nextLine());
            switch(option) {
                case 1:
                    System.out.println("Minkä kulkuneuvon haluat rakentaa? 1) auto, 2) lentokone, 3) laiva");
                    int type = Integer.parseInt(sc.nextLine());
                    System.out.println("Anna kulkuneuvon valmistaja:");
                    String manufacturer = sc.nextLine();
                    System.out.println("Anna kulkuneuvon malli:");
                    String model = sc.nextLine();
                    System.out.println("Anna kulkuneuvon huippunopeus:");
                    int maxSpeed = Integer.parseInt(sc.nextLine());
                    if (type == 1) {
                        newVehicle = new Car(manufacturer, model, maxSpeed);
                    } else if (type == 2) {
                        newVehicle = new Plane(manufacturer, model, maxSpeed);
                    } else if (type == 3) {
                        newVehicle = new Ship(manufacturer, model, maxSpeed);
                    }
                    vehicles.add(newVehicle);
                    break;
                case 2:
                    for (Vehicle vehicle : vehicles) {
                        vehicle.printSpecs();
                        System.out.println("");
                    }
                    break;
                case 3:
                    for(Vehicle vehicle : vehicles) {
                        if (vehicle.getType() == "Auto")
                        ((Car)vehicle).drive();
                    }
                    break;
                case 4:
                    for(Vehicle vehicle : vehicles) {
                        if (vehicle.getType() == "Lentokone")
                        ((Plane)vehicle).fly();
                    }
                    break;
                case 5:
                    for(Vehicle vehicle : vehicles) {
                        if (vehicle.getType() == "Laiva")
                        ((Ship)vehicle).sail();
                    }
                    break;
                case 0:
                    exit = true;
                    System.out.println("Kiitos ohjelman käytöstä.");
                    break;
            }
        }
        sc.close();
    }
}

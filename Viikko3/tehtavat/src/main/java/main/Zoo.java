package main;

import java.util.ArrayList;

public class Zoo {
    private ArrayList<Animal> animals = new ArrayList<>();
    private String zooName;
    
    public Zoo(String zooName) {
        this.zooName = zooName;
    }

    public void addAnimal(Animal newAnimal) {
        animals.add(newAnimal);
    }

    public void listAnimals() {
        System.out.println(zooName + " pitää sisällään seuraavat eläimet:");
        for (Animal animal : animals) {
            animal.printSpecs();
        }
    }

    public void runAnimals(int rounds) {
        for (Animal animal : animals) {
            animal.runAnimal(rounds);
        }
    }
}

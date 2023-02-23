package main;

public class Engine {
    private String name;
    private int power;

    public Engine(String name, int power) {
        this.name = name;
        this.power = power;
    }

    public void printSpecs() {
        System.out.println("Moottori: " + name + " " + power + "kw");
    }
}

package main;

public class Vehicle {
    protected String type;
    protected String manufacturer;
    protected String model;
    protected int maxSpeed;
    protected Engine engine;

    public Vehicle(String type, String manufacturer, String model, int maxSpeed) {
        this.type = type;
        this.manufacturer = manufacturer;
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    public String getType() {
        return type;
    }

   public void printSpecs() {
        System.out.println(type + ": " + manufacturer + " " + model);
        engine.printSpecs();
        System.out.println("Huippunopeus: " + maxSpeed + "km/h");
    }
}

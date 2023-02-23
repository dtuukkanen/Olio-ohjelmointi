package main;

public class Hedgehog {
    private String name;
    private int age;

    /* Basic values of Hedgehog */
    public Hedgehog() {
        name = "Pikseli";
        age = 5;
    }

    /* Change values of Hedgehog */
    public Hedgehog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /* Make Hedgehog speak */
    public void speak(String text) {
        if (text.isBlank()) {
            System.out.println("Olen " + name + " ja ikäni on " + age + " vuotta, mutta antaisitko silti syötteen?");
            return;
        }
        System.out.println(name + ": " + text);
    }

    /* Make Hedgehog run */
    public void run(int rounds) {
        for (int i = 0; i < rounds; i++) {
            System.out.println(name + " juoksee kovaa vauhtia!");
        }
    }
}

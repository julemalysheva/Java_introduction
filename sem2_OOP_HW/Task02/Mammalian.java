package sem2_OOP_HW.Task02;

public abstract class Mammalian implements Animal {
    double weight;
    String color;
    //Food food;


    @Override
    public void sleep() {
        System.out.println("Спит");
    }

    @Override
    public void sounds() {
        System.out.println("Издает звуки");
    }

    @Override
    public void move() {
        System.out.println("Двигается");
    }

    @Override
    public void reproduction() {
        System.out.println("Дает потомство");
    }


    @Override
    public void growth() {
        System.out.println("Растет и развивается");
    }
}

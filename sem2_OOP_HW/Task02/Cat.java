package sem2_OOP_HW.Task02;

import java.util.Objects;

public class Cat extends Pets implements Predators{
    String breed;
    int id;
    static int count;
    static {
        count = 0;
    }

    public Cat(String gender, String nickName, int age, double weight, String breed, String color) {
        super(gender, nickName, age, weight, color);
        this.breed = breed;
        this.id = ++count;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "breed='" + breed + '\'' +
                ", id=" + id +
                ", nickName='" + nickName + '\'' +
                ", owner=" + owner +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public void eats(Food food) {
        this.eatsMeat(food);
    }

    @Override
    public void giveBenefit() {
        System.out.println("Ловит мышей, играет, греет");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cat cat = (Cat) o;
        return id == cat.id && Objects.equals(breed, cat.breed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), breed, id);
    }

    @Override
    public void move() {
        System.out.println("Бежит на кис-кис; ходит мягкой поступью, прягает, играет");
    }

    @Override
    public void sounds() {
        System.out.println("Мяу-мяу");
    }
}

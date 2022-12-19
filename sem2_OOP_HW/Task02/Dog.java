package sem2_OOP_HW.Task02;

import java.util.Objects;

public class Dog extends Pets implements Predators{
    String breed;
    int id;
    static int count;
    static {
        count = 0;
    }


    public Dog(String gender, String nickName, int age, double weight, String color, String breed) {
        super(gender, nickName, age, weight, color);
        this.breed = breed;
        this.id = ++count;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "breed='" + breed + '\'' +
                ", id=" + id +
                ", owner=" + owner +
                ", gender='" + gender + '\'' +
                ", nickName='" + nickName + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public void giveBenefit() {
        System.out.println("Прогулки, игры, охота, преданность, лижет руки, греет");
    }

    @Override
    public void eats(Food food) {
        eatsMeat(food);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Dog dog = (Dog) o;
        return id == dog.id && Objects.equals(breed, dog.breed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), breed, id);
    }
    @Override
    public void sounds() {
        System.out.println("Гав-гав, тяф-тяф))");
    }

    @Override
    public void move() {
        System.out.println("Бежит на свою кличку, идет на место по команде, бегает за палкой, прыгает и активно играет");
    }
}

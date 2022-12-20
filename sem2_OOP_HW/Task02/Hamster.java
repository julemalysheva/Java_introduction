package sem2_OOP_HW.Task02;

import java.util.Objects;

public class Hamster extends Pets implements Herbivores{
    int id;
    static int count;
    static {
        count = 0;
    }

    public Hamster(String gender, String nickName, int age, double weight, String color) {
        super(gender, nickName, age, weight, color);
        this.id = ++count;

    }

    @Override
    public String toString() {
        return "Hamster{" +
                "owner=" + owner +
                ", id=" + id +
                ", gender='" + gender + '\'' +
                ", nickName='" + nickName + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public void eats(Food food) {
        this.eatVegetable(food);
    }

    @Override
    public void giveBenefit() {
        System.out.println("Мило играет - для души");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Hamster hamster = (Hamster) o;
        return id == hamster.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }

    @Override
    public void sounds() {
//        super.sounds();
        System.out.println("Пищит, трещит");
    }
}

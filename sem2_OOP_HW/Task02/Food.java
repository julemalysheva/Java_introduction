package sem2_OOP_HW.Task02;

public class Food {
    boolean isMeat;
    String name;

    public Food(boolean isMeat, String name) {
        this.isMeat = isMeat;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                '}';
    }
}

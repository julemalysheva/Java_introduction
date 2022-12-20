package sem2_OOP_HW.Task02;

public interface Predators extends Animal{
    default void eatsMeat(Food food){
        if (food.isMeat) System.out.println(Animal.super.getClass().getSimpleName() + " Хищник съест " + food);
        else System.out.println(Animal.super.getClass().getSimpleName()+ " Хищник вряд ли будет есть "+ food);
    }
}

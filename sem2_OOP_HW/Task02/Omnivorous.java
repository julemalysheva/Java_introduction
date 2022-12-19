package sem2_OOP_HW.Task02;

public interface Omnivorous extends Animal {
    default void eatsAll(Food food){
        System.out.println(Animal.super.getClass().getSimpleName()+ " Всеядное, при желании будет есть "+ food);
    }
}

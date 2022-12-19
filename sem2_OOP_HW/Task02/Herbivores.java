package sem2_OOP_HW.Task02;

public interface Herbivores extends Animal{
   default void eatVegetable(Food food){
      if (food.isMeat) System.out.println(Animal.super.getClass().getSimpleName() + " Травоядное не ест " + food);
      else System.out.println(Animal.super.getClass().getSimpleName()+ " Травоядное съест "+ food);

   }
}

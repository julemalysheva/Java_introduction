package sem2_OOP_HW.Task02;

public interface Animal {
    void eats(Food food);
    void sleep();
    void sounds();
    void move();
    void reproduction();
    void growth();
    //размножение, развитие, движение
    //можно сделать интерфейс наследник: травоядные, всеядные, плотоядные
    //летающие, плавающие, наземные
    //дикие, домашние - приносят пользу и потомство в неволе, подчинены человеку
}

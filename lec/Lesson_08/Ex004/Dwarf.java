package lec.Lesson_08.Ex004;

public class Dwarf extends Druid {
    
    public Dwarf(String name, int hp) {
        super();//в данном случае через Супер берем констр.Druid, а не базового класса
        System.out.println("Вызван Dwarf(String name, int hp)");
    }

    public Dwarf() {
        this("", 0);
        System.out.println("Вызван Dwarf()");
    }
   
}
package lec.Lesson_06.part2;

import java.util.Arrays;
import java.util.HashSet;

public class Ex001_Worker {
    public static void main(String[] args) {
        //в клиентском коде, в данном случае в точке входа создаем экземпляры Worker
        Worker w1 = new Worker();//в контексте ООП называется конструктором
        w1.firstName = "Имя_1";
        w1.lastName = "Фамилия_1";
        w1.salary = 100;
        w1.id = 1000;
//пока не опишем критерии сравнения эти экземпляры не будут равны
        //нужно переопределить хэш-функцию и equals
        Worker w4 = new Worker();//происходит расположение в памяти
        w4.firstName = "Имя_1";
        w4.lastName = "Фамилия_1";
        w4.salary = 100;
        w4.id = 1000;

        Worker w2 = new Worker();
        w2.firstName = "Имя_2";
        w2.lastName = "Фамилия_2";
        w2.salary = 200;
        w2.id = 2000;

        Worker w3 = new Worker();
        w3.firstName = "Имя_3";
        w3.lastName = "Фамилия_3";
        w3.salary = 300;
        w3.id = 3000;
//lec.Lesson_06.part2.Worker@378bf509 - хэш код если не переопределить методы
        System.out.println(w1.toString());
        System.out.println(w2);
        System.out.println(w3);
        System.out.println(w4);//@16b98e56 - хэши разные, для java это разные объекты

//в печать получаем набор символов - нужно опереопределить метод toString

        System.out.println(w1 == w4);//false
        System.out.println(w1.equals(w4));//после переопределения true

        var workers = new HashSet<Worker>(Arrays.asList(w1, w2, w3));
        System.out.println(workers.contains(w4));//после переопределения true

    }
}

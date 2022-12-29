package sem4_OOP;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Program {
    public static void main(String[] args) {
        Task task = new Task(LocalDate.now(), LocalDateTime.now().toLocalTime(),
                LocalDateTime.of(2023,12,30,12,30),"Yulya M.",
                "Сдать домашнее задание");
        Task task1 = new Task(LocalDate.now(), LocalDateTime.now().toLocalTime(),
                LocalDateTime.of(2022,1,30,12,30),"Yulya M.",
                "Сдать задание");
        System.out.println(task);
        System.out.println(task1);
        TaskTree.addTask(task);
        TaskTree.addTask(task1);
        Menu.startApplication();
    }
}

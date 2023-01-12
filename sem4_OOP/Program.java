package sem4_OOP;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Program {
    public static void main(String[] args) {
        //заполняю для примера, чтоб было с чем работать и тестировать
        Task task = new Task(LocalDate.now(), LocalDateTime.now().toLocalTime(),
                LocalDateTime.of(2023,1,30,12,30),"Yulya M.",
                "Сдать домашнее задание");
        Task task1 = new Task(LocalDate.now(), LocalDateTime.now().toLocalTime(),
                LocalDateTime.of(2022,12,30,12,30),"Yulya M.",
                "Сдать задание");
        TaskTree.addTask(task);
        TaskTree.addTask(task1);
        TaskTree.printTask();//хранятся в TreeSet - сортировка компаратором сразу по ближайшей дате дедлайна - по срочности задач
        Menu.startApplication();//идет запуск меню и предполагается пользовательский ввод и изменение, работает
        //выгрузка в csv пока только
    }
}

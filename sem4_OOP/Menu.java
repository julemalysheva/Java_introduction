package sem4_OOP;

import java.util.Scanner;

//класс будет отвечать за взаимодействие с пользователем - Меню
public class Menu {
    static public void startApplication() {
        Scanner scanner = new Scanner(System.in);
        Planner planner = new Planner();
        try {
            while (true) {
                System.out.println("""
                        Выберите пункт меню:
                        1 - Добавить задачу
                        2 - Изменить задачу
                        3 - Отменить задачу
                        4 - Просмотреть все задачи
                        5 - Очистить планнер
                        6 - Загрузить из файла
                        7 - Выгрузить в файл
                        8 - Отобрать задачи по дате дедлайна
                        9 - Выход""");
                switch (scanner.nextInt()) {
                    case 1 -> planner.inputTask();
                    case 2 -> planner.changeTask();
                    case 3 -> planner.deleteTask();
                    case 4 -> TaskTree.printTask();
                    //подумать с приоритетом
                    case 5 -> TaskTree.clearTaskTree();
                    case 6 -> planner.loadData();
                    case 7 -> planner.saveData();
                    case 8 -> planner.chosenDateDeadline();//compareTo сравнивает даты
                    case 9 -> {
                        System.out.println("Работа завершена");
                        scanner.close();
                        System.exit(0);
                    }
                    default -> System.out.println("Некорректный ввод");
                }
            }
        }
            catch(Exception ex){
                    System.out.println("Выберите пункт меню - введите число");
                }
    }
}

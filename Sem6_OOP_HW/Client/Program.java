package Sem6_OOP_HW.Client;

/**
 * Точка входа в программу
 */
public class Program {
    public static void main(String[] args) {
/**
 * Создаем новый экземпляр приложения, передавая в конструктор тип View.
 * Запускаем приложение.
 */
        new App(new ConsoleView()).start();

    }


}

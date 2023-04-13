package Exceptions.lesson3;
/*Задание №3
1. Создайте класс исключения, который будет выбрасываться при делении на
0. Исключение должно отображать понятное для пользователя сообщение
об ошибке.
2. Создайте класс исключений, которое будет возникать при обращении к
пустому элементу в массиве ссылочного типа. Исключение должно
отображать понятное для пользователя сообщение об ошибке
3. Создайте класс исключения, которое будет возникать при попытке открыть
несуществующий файл. Исключение должно отображать понятное для
пользователя сообщение об ошибке.*/

public class Calculator {
    public static void main(String[] args) {
        try {
            System.out.println(divide(5, 0));
        } catch (DivideByZeroException e) {
            //throw new RuntimeException(e);
            System.out.println(e.getMessage());
        }
    }
    public static int divide(int a, int b) throws DivideByZeroException {
        if (b == 0) {
            throw new DivideByZeroException();
        }
        return a / b;
    }
}
//Класс исключения для деления на ноль:
class DivideByZeroException extends RuntimeException { //наследоваться от RuntimeException?
    public DivideByZeroException() {
        super("Деление на ноль невозможно!");
    }
}
//Класс исключения для пустого элемента массива ссылочного типа:
class EmptyArrayElementException extends Exception {
    public EmptyArrayElementException() {
        super("Обращение к пустому элементу массива!");
    }
}
//Класс исключения для несуществующего файла:
class FileDoesNotExistException extends Exception {
    public FileDoesNotExistException() {
        super("Файл не существует!");
    }
}



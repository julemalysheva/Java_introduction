package Exceptions.lesson2.HW_Seminar2;

/*Дан следующий код, исправьте его там, где требуется
        (задание 3 https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)*/

public class Task03Sem2 {
    //Убрать объявление "throws Exception" в сигнатуре метода main, так как в нём уже есть обработчик исключений.
    public static void main(String[] args) {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = { 1, 2 };
            abc[3] = 9;
            //Изменить порядок блоков catch
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (ArithmeticException ex) { //добавить ArithmeticException, т.к. возможно деление на 0
            System.out.println("Попытка деления на 0");
        } catch (Exception ex) { //Заменить "Throwable" на "Exception" в блоке catch, так как обработчик
            // Throwable может перехватывать исключения, которые не являются наследниками класса Exception.
            System.out.println("Что-то пошло не так...");
        }
    }

    //В методе printSum убрать объявление "throws FileNotFoundException", так как этот метод не вызывает операции,
    // которые могут привести к FileNotFoundException
    public static void printSum(Integer a, Integer b) {
        System.out.println(a + b);
    }

}

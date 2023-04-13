package Exceptions.lesson3;
/*Создайте класс Счетчик, у которого есть метод add(), увеличивающий
значение внутренней int переменнойна 1.Сделайте так, чтобы с объектом
такого типа можно было работать в блоке try-with-resources. Нужно бросить
исключение, если работа с объектом типа счетчик была не в ресурсном try
и/или ресурс остался открыт.Подумайте какой тип исключения подойдет
лучше всего.*/

public class Counter implements AutoCloseable {
    private int count = 0;
    private boolean closed = false;

    public void add() {
        if (closed) {
            throw new IllegalStateException("Счетчик был закрыт");
        }
        count++;
    }

    @Override
    public void close() {
        if (closed) {
            throw new IllegalStateException("Счетчик уже был закрыт");
        }
        closed = true;
    }

    public static void main(String[] args) {
        try (Counter counter = new Counter()) {
            for (int i = 0; i < 5; i++) {
                counter.add();
            }
            // Попытка вызвать add() после закрытия объекта counter:
            counter.close();
            counter.add(); // выбросится IllegalStateException
        } catch (IllegalStateException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

}

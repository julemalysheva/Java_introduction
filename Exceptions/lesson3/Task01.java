package Exceptions.lesson3;

import java.io.IOException;

/*Создайте метод doSomething(), который может быть источником одного из
типов checked exceptions (тело самого метода прописывать не обязательно).
Вызовите этот метод из main и обработайте в нем исключение, которое
вызвал метод doSomething().*/

public class Task01 {
    public static void main(String[] args) {
        try {
            doSomething();
        } catch (IOException e) {
            System.out.println("Произошло исключение: " + e.getMessage());
        }
    }

    public static void doSomething() throws IOException {
        // Тело метода, которое может выбрасывать исключение IOException
    }
}

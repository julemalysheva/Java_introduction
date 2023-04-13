package Exceptions.lesson3;
/*Задание №4
1. Напишите метод,на вход которого подаётся двумерный строковый массив
размером 4х4. При подаче массива другого размера необходимо бросить
исключение MyArraySizeException.
2. Далее метод должен пройтись по всем элементам массива,преобразовать в
int и просуммировать. Если в каком-то элементе массива преобразование
не удалось (например, в ячейке лежит символ или текст вместо числа),
должно быть брошено исключение MyArrayDataException с детализацией, в
какой именно ячейке лежат неверные данные.
3. В методе main() вызвать полученный метод, обработать возможные
исключения MyArraySizeException и MyArrayDataException и вывести
результат расчета (сумму элементов,при условии что подали на вход
корректный массив).*/

public class Task04 {
    public static void main(String[] args) {
        String[][] correctArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };
        String[][] incorrectArraySize = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"}
        };
        String[][] incorrectArrayData = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "a", "16"}
        };

        try {
            System.out.println("correctArray");
            System.out.println("Сумма элементов массива: " + sumArray(correctArray));
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
            System.out.println("Неверные данные в ячейке: " + e.getRowIndex() + ", " + e.getColIndex());
        }

        try {
            System.out.println("incorrectArraySize");
            System.out.println("Сумма элементов массива: " + sumArray(incorrectArraySize));
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
            System.out.println("Неверные данные в ячейке: " + e.getRowIndex() + ", " + e.getColIndex());
        }

        try {
            System.out.println("incorrectArrayData");
            System.out.println("Сумма элементов массива: " + sumArray(incorrectArrayData));
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
            System.out.println("Неверные данные в ячейке: " + e.getRowIndex() + ", " + e.getColIndex());
        }
    }

    public static int sumArray(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;

        if (arr.length != 4 || arr[0].length != 4 || arr[1].length != 4 || arr[2].length != 4 || arr[3].length != 4) {
            throw new MyArraySizeException();
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }

        return sum;
    }

}

class MyArraySizeException extends Exception {
    public MyArraySizeException() {
        super("Некорректный размер массива!");
    }
}

class MyArrayDataException extends Exception {
    private int rowIndex;
    private int colIndex;

    public MyArrayDataException(int rowIndex, int colIndex) {
        super(String.format("Неверные данные в ячейке [%d][%d]!", rowIndex, colIndex));
        this.rowIndex = rowIndex;
        this.colIndex = colIndex;
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public int getColIndex() {
        return colIndex;
    }
}

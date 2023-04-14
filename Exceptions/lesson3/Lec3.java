package Exceptions.lesson3;
//код с методички для быстрого доступа - Лекция 3 исключения - код тестовый

import javax.swing.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class Lec3 {

    /*В примере ниже читаем содержимое файла для решения какой-то
задачи, детали этой задачи не важны. В блоке finally освобождаем
файл.
*/
    public static void main(String args[]) {
        FileReader reader = null;
        try {
            reader = new FileReader(new
                    File("file.txt"));
// Полезная работа, связанная с чтением файла..
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
/*а. Было бы неплохо упростить этот код. Для этого
используем конструкцию try-with-resources. Код примет вид:*/
        try (FileReader reader = new FileReader(new
                File("file.txt")))
        { /*Рядом с try в круглых скобках указывается создаваемый ресурс, который
            при выходе из блока try должен быть освобождён, и не важно будет ли
            брошено какое-то исключение или нет*/

        // Полезная работа, связанная с чтением  файла..

        } catch (IOException e) {
            e.printStackTrace();
        }

        //Там можно указать только объекты, реализующие
        //интерфейс AutoClosable.
        try (Box box = new Box()) {
        } catch (Exception e) {
            e.printStackTrace();
        }

        //А если в блоке try-with-resources надо создать два объекта?
        //Просто разделите создание объектов точкой с запятой
        try (Box box1 = new Box();
             Box box2 = new Box()) {
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Обработка исключений выше по стеку
        //воспользуется  ключевым словом throws.
        public void saveReportToFile(String path, String data) throws IOException {
            String modifiedOutputData = data; // Представим, что здесь форматируются входные данные
            try (PrintWriter writer = new PrintWriter(path)) {
                writer.println(modifiedOutputData);
            }
        }
        public void onSaveReportButtonClick() {
            String path = generateOutputReportPath();
            String outputData = "Очень важные данные для отчета";
            ReportExporter reportExporter = new
                    ReportExporter();
            try {
                reportExporter.saveReportToFile(path, outputData);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Ошибка!Невозможно сохранить отчет", "Ошибка!",
                JOptionPane.ERROR_MESSAGE);
            }
        }

        //А если нам понадобилось обработать исключение в двух местах: и
        public void saveReportToFile(String path, String data) throws IOException {
            String modifiedOutputData = data; // Представим, что  здесь форматируются входные данные
            try (PrintWriter writer = new PrintWriter(path)) {
                writer.println(modifiedOutputData);
            } catch (IOException e) {
            // Что-то полезное делаем
                throw e; //и снова бросаем исключение, которое ловим выше по стеку
            }
        }

        //Создание собственных типов исключений
        class MyException extends RuntimeException {
        }
        class IllegalImageFormatException extends
                RuntimeException {
        }
        class IllegalFilterParametersException extends
                RuntimeException {
        }
        //Все исключения,
        //характерные для вашей библиотеки или проекта, было бы логично
        //сгруппировать, чтобы у них был общий корень. Посмотрим, что это значит.
        class JavaCVException extends RuntimeException {
        }
        class IllegalImageFormatException extends JavaCVException {
        }
        class IllegalFilterParametersException extends JavaCVException {
        }

        // это дает интересный эффект
        try {
            cvLib.loadImage("C:/image.png");
        } catch (JavaCVException e) {
            e.printStackTrace();
        }
        /*Пока пользователь начинает работу с вашей библиотекой, он может везде
перехватывать корневое исключение, не волнуясь, что приложение упадёт.
Как только он получит достаточно опыта, то сможет начать менять код и
указывать реакцию на уже конкретные исключения.*/

        // ...
        try {
            CvImage img = cvLib.loadImage("C:/image.png");
            cvLib.filters().blur(img, 2);
        } catch (IllegalImageFormatException e) {
            System.out.println("Выбрано изображение с неподдерживаемым форматом, выберите другой файл");
        } catch (IllegalFilterParametersException e) {
            System.out.println("Выбраны некорректные параметры фильтра");
        } catch (JavaCVException e) {
            System.out.println("Ой");
        }
//        Ещё один интересный подход при работе с собственными типами
//        исключений — «оборачивание» одного исключения в другое.
        try {
        // Вычисления
        // Вычисления
        // Вычисления
        } catch (Exception e) {
            throw new IllegalFilterParametersException();
        }


        /*Добавим немного особенностей нашим исключениям. Допустим, мы решили
написать метод, преобразующий массив строк в массив целых чисел.*/
        System.out.println(Arrays.toString(transform(new String[]{"1", "2", "3", "4"})));

    public static int[] transform(String[] input) {
        int[] output = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            output[i] = Integer.parseInt(input[i]);
        }
        return output;
    }

    //А если потребуется вместо этого бросить своё исключение, и чтобы
        //исключение хранило информацию об индексе некорректного элемента?
        class ArrayTransformationException extends
                RuntimeException {
        }

        //Позволим исключению хранить в себе информацию о некорректном элементе массива.
        class ArrayTransformationException extends RuntimeException {
            private int illegalElementIndex;
            private String illegalElementValue;
            public int getIllegalElementIndex() {
                return illegalElementIndex;
            }
            public String getIllegalElementValue() {
                return illegalElementValue;
            }
            public ArrayTransformationException(int illegalElementIndex, String illegalElementValue) {
                super(String.format("Во входном массиве на позиции: %d находится некорректный элемент: %s",
                illegalElementIndex, illegalElementValue));
                this.illegalElementIndex = illegalElementIndex;
                this.illegalElementValue = illegalElementValue;
            }
        }

        //как этим пользоваться:
        System.out.println(Arrays.toString(transform(new
                String[]{"1", "2", "3", "4"})));
    }
    public static int[] transform(String[] input) {
        int[] output = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            try {
                output[i] = Integer.parseInt(input[i]);
            } catch (NumberFormatException e) {
                throw new ArrayTransformationException(i, input[i]);
            }
        }
        return output;
    }
    //некоррект. массив
    System.out.println(Arrays.toString(transform(new String[]{"1", "2a", "3", "4"})));

       /* Результат в консоли:
        Exception in thread "main" ArrayTransformationException:
        Во входном массиве на позиции: 1 находится некорректный
        элемент: 2a
        at MainApp.transform(MainApp.java:14)
        at MainApp.main(MainApp.java:5)*/


}



class Box implements AutoCloseable {
    @Override
    public void close() throws Exception {
// Закрываем коробку
    }
}


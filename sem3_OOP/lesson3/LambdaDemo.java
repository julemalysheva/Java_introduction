package oop.lesson3;

public class LambdaDemo {
    public static void main(String[] args) {
        MyNum myNum; // объявление ссылки на интерфейс
        myNum = () -> 98.6; //простое лямбда вырожение
        System.out.println("Постоянное значение " + myNum.getNum());
        MyParaNum myParaNum = (x) -> 1.0/x;
        System.out.println("Обратная велечина 4 = " + myParaNum.getNum(4.0));
        System.out.println("Обратная велечина 8 = " + myParaNum.getNum(8.0));

    }
}

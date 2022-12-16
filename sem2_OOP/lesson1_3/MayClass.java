package sem2_OOP.lesson1_3;
//класс на основе B, который в свою очередь на основе A - переопределяем методы из Инт.A и B
public class MayClass implements B{
    @Override
    public void mach3() {
        System.out.println("Реализация метода mach3");
    }

    @Override
    public void mach1() {
        System.out.println("Реализация метода mach1");
    }

    @Override
    public void mach2() {
        System.out.println("Реализация метода mach2");
    }
}

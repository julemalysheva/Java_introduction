package sem2_OOP.lesson1;
//создали класс NumberTwo, который реализует интерфейс Methods
public class NumberTwo implements Methods {

    int start;
    int val;
    int prev;

    public NumberTwo() {
        start = 0;
        val = 0;
        prev = -2;
    }
//ниже переопределяем обязательные методы интерфейса
    @Override
    public int getNext() {
        val += 2;
        prev = val;
        return val;
    }

    @Override
    public void reset() {
        start = 0;
        val = 0;
        prev = -2;
    }

    @Override
    public void setStart(int x) {
        start = x;
        val = x;
        prev = x - 2;
    }
//при необходимости можем создать свои методы класса
    int getPrevious() {
        return prev;
    }
}

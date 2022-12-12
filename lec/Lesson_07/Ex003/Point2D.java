package lec.Lesson_07.Ex003;


/** 
 * Это точка 2D
*/
public class Point2D {
    private int x, y; // Это координата х и у

    /**
     * Это конструктор ...
     * @param valueX это координата Х
     * @param valueY это координата Y
     */
    public Point2D(int valueX, int valueY) {
        x = valueX;
        y = valueY;
    }
//перегрузка - описать метод в рамках одной сущности с др.сигнатурой, количеством/типом аргументов
    //this вызываем верхний конструктор, и пробрасываем в обе переменные наш аргумент
    public Point2D(int value) {
        this(value, value);
    }
    //конструктор без аргументов - констр.по умолчанию
    public Point2D() {
        this(0);
    }

    /**
     *
     * @return значение переменной
     */
    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
    
    public void setX(int value){
        this.x = value;
    }

    public void setY(int value){
        this.y = value;
    }
//ctor -сниппет для создания конструктора
    
    private String getInfo(){
        return String.format("x: %d; y: %d", x, y);
    }
    //переопределяем метод, написанный до нас через @Override
    @Override
    public String toString() {
        return getInfo();
    }
//static - обращаться нужно не через конкретный экземпляр, а через имя типа
    public static double distance(Point2D a, Point2D b) {
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }

    // ctor
    // get; set;
    // docs
    //
}

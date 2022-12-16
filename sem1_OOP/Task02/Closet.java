package sem1_OOP.Task02;

import java.util.Random;

public class Closet {

    enum Condition{
        OPENED, CLOSED
    }
    private Condition condition;
    private String color, location, id;
    private int width, height, depth;
    private int fullness;
    //например, считать сколько раз положили, если 10 - становится полным и положить больше нельзя
    public static Random r;
    private static int number_closet;
    static {
        r = new Random();
        number_closet = 0;
    }
    private final int maxFullness;


    /**
     * Конструктор шкафа - при создании в статусе Закрыт, наполненность задается рандомно, по условию считаю 10 - полный
     * @param color цвет
     * @param location место расположения
     * @param width ширина
     * @param height высота
     * @param depth глубина
     */
    public Closet(String color, String location, int width, int height, int depth) {
        this.color = color;
        this.location = location;
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.condition = Condition.CLOSED;//может рандомно?
        this.fullness = Closet.r.nextInt(0, 10);//0-пустой, 10 - полный
        this.maxFullness = Closet.r.nextInt(10,20);
        number_closet++;
        this.id = String.format("Closet#%d", number_closet);
    }

    @Override
    public String toString() {
        return "Closet{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", condition='" + condition + '\'' +
                ", fullness=" + fullness +
                ", maxFullness=" + maxFullness +
                '}';
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setFullness(int fullness) {
        this.fullness = fullness;
    }

    public int getFullness() {
        return fullness;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public int getMaxFullness() {
        return maxFullness;
    }

    public String getId() {
        return id;
    }
    //методы м.б.например: взять-положить, переставить шкаф - соответственно меняется наполняемость setFullness
    //или локация setLocation
}

package sem1_OOP.Task02;

import java.util.Random;

public class Human {
    private String name;
    private final Integer id;
    private int numberItems;
    private static Integer count;
    public static Random r;

    static {
        count = 0;
        r = new Random();
    }

    /**
     * Конструктор персоны человека: ID присваивается по порядку, рандомно определяется кол-во вещей на руках
     * @param name Имя человека
     */
    public Human(String name) {
        this.name = name;
        count++;
        this.id = count;
        this.numberItems = Human.r.nextInt(0, 10);
    }

    public Human() {
        this("unknown");
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", numberItems=" + numberItems +
                '}';
    }

    //методы взять/положить/передвинуть/очистить - а в классе шкафа меняется Статус и наполненность
    //у человека изменяется кол-во вещей
    public void openCloset(Closet closet){
        if (closet.getCondition() == Closet.Condition.CLOSED){
            System.out.println(this.name + " открыл шкаф");
            closet.setCondition(Closet.Condition.OPENED);
        }
    }
    public void closeCloset(Closet closet){
        if (closet.getCondition() == Closet.Condition.OPENED){
            System.out.println(this.name + " закрыл шкаф");
            closet.setCondition(Closet.Condition.CLOSED);
        }
    }
    public void changeLocation(Closet closet, String newLoc){
        closet.setLocation(newLoc);
        System.out.println(this.name+" переставил шкаф " + closet.getId() + " в " + newLoc);
    }
    public void clearCloset(Closet closet){
        if (closet.getFullness()>0){
            openCloset(closet);
            int allItems = closet.getFullness();
            closet.setFullness(0);
            this.numberItems += allItems;
            System.out.println(this.name + " очистил шкаф " + closet.getId());
            closeCloset(closet);
        }
    }

    public void putItem(int count, Closet closet){
        if (this.numberItems >=count && count>0){
            openCloset(closet);
            if ((closet.getFullness()+count) <= closet.getMaxFullness()){
                closet.setFullness(closet.getFullness()+count);
                this.numberItems -= count;
                System.out.println(this.name + " положил в " + closet.getId() + " " + count + "вещей");
            }
            else System.out.println("Шкаф " + closet + " переполнен. Можно положить "+
                    (closet.getMaxFullness()- closet.getFullness()) +"\nИли выберите другой шкаф");
            closeCloset(closet);
        }
    }

    public void takeItem(int count, Closet closet){
        if ((closet.getFullness() - count) > 0){
            openCloset(closet);
            this.numberItems+=count;
            closet.setFullness(closet.getFullness() - count);
            System.out.println(this.name + " взял из " + closet.getId() + " " + count + "вещей");
            closeCloset(closet);
        } else {
            System.out.println("Нет столько вещей в шкафу " + closet+ ", доступно "+ closet.getFullness());
        }
    }
}

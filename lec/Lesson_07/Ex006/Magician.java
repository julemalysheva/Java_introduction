package lec.Lesson_07.Ex006;

public class Magician extends BaseHero {

    private int mana;
    private int maxMana;

    public Magician() {
        //при обращении к членам родительского класса лучше писать super для лучшей навигации по коду
        super(String.format("Hero_Magician #%d", ++Magician.number),
                Magician.r.nextInt(100, 200));
        //после вызова конструктора базового класса мы можем делать доинициализацию под задачу конкретного текущего класса
        this.maxMana = Magician.r.nextInt(50, 150);
        this.mana = maxMana;
    }

    public int Attack() {
        int damage = BaseHero.r.nextInt(20, 30);
        this.mana -= (int)(damage * 0.8);
        if (mana < 0) return 0;
        else return damage;
    }

    public String getInfo() {
        return String.format("%s  Mana: %d", super.getInfo(), this.mana);
    }
}
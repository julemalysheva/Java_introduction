package lec.Lesson_08.Ex003;

import lec.Lesson_08.Ex003.alliance.Dwarf;

public class Program {
    public static void main(String[] args) {

        // #region teams
        //// Когда героев становится больше

        // int teamCount = 10;
        // Random rand = new Random();

        // List<BaseHero> teams = new ArrayList<>();
        // for (int i = 0; i < teamCount; i++) {
        //     int val = rand.nextInt(4);
        //     switch (val) {
        //         case 0:
        //             teams.add(new Priest());
        //             break;
        //         case 1:
        //             teams.add(new Magician());
        //             break;
        //         case 2:
        //             teams.add(new Druid());
        //             break;
        //         default:
        //             // teams.add(new BaseHero());
        //             break;
        //     }
        //     System.out.println(teams.get(i).getInfo());
        // }

        // System.out.println();

        // #endregion

        // #region ToDo BaseHero

        // // BaseHero hero = new BaseHero();
        // // System.out.println(hero.getInfo());
        // // ToDo BaseHero
         Priest priest = new Priest();
         System.out.println(priest.getInfo());
         //если слева указать тип родительский BaseHero, который не реализует конкр.логику -все начинает ломаться
        //в таком случае при вызове дочернего метода нужно привести его к нужному типу.
         Druid druid = new Druid();
         System.out.println(druid.getInfo());
         Magician magician = new Magician();
         System.out.println(magician.getInfo());

         priest.attack(magician);
         System.out.println(magician.getInfo());
         priest.attack(magician);
         System.out.println(magician.getInfo());
        druid.healing(magician);
         System.out.println(magician.getInfo());
         druid.healing(magician);
         System.out.println(magician.getInfo());
         druid.healing(magician);
         System.out.println(magician.getInfo());
         druid.healing(magician);
         System.out.println(magician.getInfo());
         druid.healing(magician);
         System.out.println(magician.getInfo());

        // #endregion

        // #region
        BaseHero dh = new Druid();
        /*BaseHero*/
        Dwarf dwarf = new Dwarf();
        //приведение к нужному типу для вызова метода
        //dwarf.dwarf_method();
        //((Dwarf)dwarf).dwarf_method();
        System.out.println(dwarf.name);
        // #endregion
    }
}
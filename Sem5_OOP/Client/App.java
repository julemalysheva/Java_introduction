package Sem5_OOP.Client;

import Sem5_OOP.Logger.MyLog;
import Sem5_OOP.MVP.CalcComlex.CalcComplexModel;
import Sem5_OOP.MVP.CalcRational.CalcRationalModel;
import Sem5_OOP.MVP.Model;
import Sem5_OOP.MVP.Presenter;
import Sem5_OOP.MVP.View;

import java.io.File;
import java.util.Scanner;
import java.util.logging.Logger;

public class App {
    static Scanner in = new Scanner(System.in);
    static MyLog myLog = new MyLog(Logger.getLogger(App.class.getName()));

    static View view = new ConsoleView();
    static Model model;
    static Presenter presenter;

    public static void start() {
        while (true) {
            System.out.println("""
                    Выберите пункт меню:
                        1 - операции с рац.числами
                        2 - операции с комплекс.числами
                        3 - посмотреть лог файл
                        4 - выход из программы
                    """);
            switch (in.nextInt()) {
                case 1:
                    myLog.log("Выбран пункт меню: 1 - операции с рац.числами ");
                    presenter = new Presenter<>(new CalcRationalModel(),view);
                    presenter.buttonClick();//или сразу так? presenter.buttonClickRational();
                    break;
                case 2:
                    myLog.log("2 - операции с комплекс.числами");
                    presenter = new Presenter<>(new CalcComplexModel(),view);
                    presenter.buttonClick(); //или так? buttonClickComplex();
                    break;
                case 3:
                    myLog.log("3 - посмотреть лог файл");
                    view.viewLog(new File("sem5_OOP\\logCalc.txt"));
                    break;
                case 4:
                    myLog.log("4 - выход из программы");
                    return;
                default:
                    myLog.log("Выбран некорректный пункт меню. Повторите ввод");
                    break;

            }
        }
    }
}

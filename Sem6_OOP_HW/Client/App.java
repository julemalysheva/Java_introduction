package Sem6_OOP_HW.Client;

import Sem6_OOP_HW.MVP.CalcComlex.PresenterComplex;
import Sem6_OOP_HW.MVP.CalcRational.PresenterRational;
import Sem6_OOP_HW.MVP.I__Presenter;
import Sem6_OOP_HW.MVP.View;

import java.io.File;

/**
 * Класс App - запуск и верхнее меню приложения
 */
public class App {
    private View view;
    private I__Presenter presenter;//задается после пользовательского выбора

    /**
     * Конструктор экземпляра App, принимает параметры:
     * @param view тип View, например, new ConsoleView() или др.
     */
    public App(View view) {
        this.view = view;
    }
    //Принцип инверсии зависимостей: экз-р App при создании может принять любой тип View при необходимости,
    //и не ограничиваться ConsoleView

    /**
     * метод задает значение переменной presenter, а именно создает экземпляр конкретного класса,
     * расширяемого I__Presenter в зависимости от выбора пользователя
     * @param num числовое обозначение пользовательского выбора - пункт меню
     */
    void setPresenter(int num) {
        if (num == 1) presenter = new PresenterRational(view);
        else if (num == 2) {
            presenter = new PresenterComplex(view);
        }
    }

    /**
     * Запуск приложения и старт главного меню
     */
    public void start() {
        int menu = 0;
        while (true) {
            menu = view.getVariant("""
                    Выберите пункт меню:
                        1 - операции с рац.числами
                        2 - операции с комплекс.числами
                        3 - посмотреть лог файл
                        4 - выход из программы
                    """);
            switch (menu) {
                case 1, 2:
                    this.setPresenter(menu); //установили Презентер в зависимости от выбранного пункта
                    //дальше неважно, какой там презентер, т.к. реализован метод интерфейса I__Presenter - buttonClick()
                    presenter.buttonClick();
                    //Принцип 5 - инверсии зависимостей. Здесь приложение слабо связано с типом расчетов,
                    //оно зависит от Абстракций и легче расширяется при необходимости
                    break;
                case 3:
                    view.viewLog(new File("sem5_OOP\\logCalc.txt"));
                    break;
                case 4:
                    return;
                default:
                    view.viewData( "Некорректный пункт меню!"," Повторите ввод.");
                    break;

            }
        }
    }
}

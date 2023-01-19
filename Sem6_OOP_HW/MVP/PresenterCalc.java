package Sem6_OOP_HW.MVP;


import Sem6_OOP_HW.Logger.MyLog;

import java.util.logging.Logger;

/**
 * Абстрактный класс описывает компоненту связи Model и View между собой,
 * расширяется интерфейсом I__Presenter для реализвции дочерними классами
 */
public abstract class PresenterCalc implements I__Presenter{
    static protected MyLog myLog;
    static {
        myLog = new MyLog(Logger.getLogger(PresenterCalc.class.getName()));
    }

    protected View view;
    protected Model model;


}

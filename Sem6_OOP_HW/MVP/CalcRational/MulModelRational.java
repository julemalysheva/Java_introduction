package Sem6_OOP_HW.MVP.CalcRational;

import Sem6_OOP_HW.MVP.CalcModel;

/**
 * Класс описывает модель Умножения рациональных чисел
 */
public class MulModelRational extends CalcModel<Double> {

    /**
     * метод расчета
     * @return результат расчета
     */
    @Override
    public Double result()  {
        return x*y;
    }

}

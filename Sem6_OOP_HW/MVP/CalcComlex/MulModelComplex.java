package Sem6_OOP_HW.MVP.CalcComlex;

import Sem6_OOP_HW.Infrastructure.Complex;
import Sem6_OOP_HW.MVP.CalcModel;

/**
 * Класс описывает модель Умножения комплексных чисел
 */
public class MulModelComplex extends CalcModel<Complex> {
    /**
     * Метод расчета
     * @return результат расчета
     */
    @Override
    public Complex result()  {
        return this.x.mul(this.y);
    }


}

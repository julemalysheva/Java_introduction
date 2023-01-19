package Sem6_OOP_HW.MVP.CalcComlex;

import Sem6_OOP_HW.Infrastructure.Complex;
import Sem6_OOP_HW.MVP.CalcModel;

/**
 * Класс описывает модель Разности комплексных чисел
 */
public class SubModelComplex extends CalcModel<Complex> {
    /**
     * метод расчета
     * @return результат расчета
     */
    @Override
    public Complex result()  {
        return this.x.sub(this.y);
    }


}

//
//
//public interface Payments{
//    /**Оплата */
//    public void DoTransaction(flag){
//    }
//}
//
//public class Cash implements Payments{
//    /**Транзакция за наличные*/
//    @Override
//    public void doTransaction(BigDecimal amount){
//        //logic
//    }
//}
//
//public class BankCard implements Payments{
//    /**Транзакция банковской картой*/
//    @Override
//    public void doTransaction(BigDecimal amount){
//        //logic
//    }
//}
//
//public class PayPhone implements Payments{
//    /**Транзакция по номеру телефона*/
//    @Override
//    public void doTransaction(BigDecimal amount){
//        //logic
//    }
//}
///**Основной класс магазин */
//public class Shop {
//    private Payments payments;
//    public Shop(Payments payments) {
//        this.payments = payments;
//    }
//    public void doPayment(Object order, BigDecimal amount){
//        payments.doTransaction(amount);
//    }
//}*/
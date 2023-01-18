import java.math.BigDecimal;

public class Account {
   
    public BigDecimal balance(String numberAccount){
        //logic
        return bigDecimal;
    };
    public void refill(String numberAccount, BigDecimal sum){
        //logic
    }   
}

public class SailoryAccount extends PaymentAccount{
    @Override
    public BigDecimal balance(String numberAccount){
        //logic
        return bigDecimal;
    }
    @Override
    public void refill(String numberAccount, BigDecimal sum){
        //logic
    }
    @Override
    public void payment(String numberAccount, BigDecimal sum){
        //logic
    }       
}

public class DipositeAccount extends Account{
    @Override
    public BigDecimal balance(String numberAccount){
        //logic
        return bigDecimal;
    }
    @Override
    public void refill(String numberAccount, BigDecimal sum){
        //logic
    }
}

public class PaymentAccount extends Account{
    @Override
    public void payment(String numberAccount, BigDecimal sum){
        //logic
    }       
}

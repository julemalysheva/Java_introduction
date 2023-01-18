public interface Payments1 {
    void payWebMoney();
}
public interface Payments2 {
    void payCreditCard();
}
public interface Payments3 {
    void payPhoneNumber();
}

public class internetPaymentService implements Payments1, Payments2, Payments3{

    @Override
    public void payWebMoney() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void payCreditCard() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void payPhoneNumber() {
        // TODO Auto-generated method stub
        
    }

}

public class terminalPaymentService implements Payments1, Payments2{

    @Override
    public void payWebMoney() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void payCreditCard() {
        // TODO Auto-generated method stub
        
    }
}
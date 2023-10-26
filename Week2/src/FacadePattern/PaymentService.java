package FacadePattern;

public class PaymentService {
    public void paymentByCreditCard() {
        System.out.println("Payment by Credit Card");
    }

    public void paymentByEbankingAccount() {
        System.out.println("Payment by E-banking account");
    }

    public void paymentByCash() {
        System.out.println("Payment by cash");
    }
}

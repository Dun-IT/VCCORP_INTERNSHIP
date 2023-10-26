package FacadePattern;

public class ShopFacade {
    private static final ShopFacade INSTANCE = new ShopFacade();
    private AccountService accountService;
    private PaymentService paymentService;
    private ShippingService shippingService;
    private EmailService emailService;
    private SmsService smsService;

    private ShopFacade() {
        accountService = new AccountService();
        paymentService = new PaymentService();
        shippingService = new ShippingService();
        emailService = new EmailService();
        smsService = new SmsService();
    }

    public static ShopFacade getInstance() {
        return INSTANCE;
    }

    public void buyProductByCashWithFreeShipping(String email) {
        accountService.getAccount(email);
        paymentService.paymentByCash();
        shippingService.freeShipping();
        emailService.sendMail(email);
        System.out.println("Done\n");
    }

    public void buyProductByBankingWithExpressShipping(String email, String phone) {
        accountService.getAccount(email);
        paymentService.paymentByEbankingAccount();
        shippingService.expressShipping();
        smsService.sendSMS(phone);
        emailService.sendMail(email);
        System.out.println("Done\n");
    }
}

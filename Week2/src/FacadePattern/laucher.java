package FacadePattern;

public class laucher {
    public static void main(String[] args) {
        ShopFacade.getInstance().buyProductByCashWithFreeShipping("doan@gmail.com");
        ShopFacade.getInstance().buyProductByBankingWithExpressShipping("doan@gmail.com", "012456789");
    }
}

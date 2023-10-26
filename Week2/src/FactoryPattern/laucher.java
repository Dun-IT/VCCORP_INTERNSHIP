package FactoryPattern;

public class laucher {
    public static void main(String[] args) {
        Shop shop1 = ShopFactory.getShop(ShopType.LAZADASHOP);
        System.out.println(shop1.getShopName());

        Shop shop2 = ShopFactory.getShop(ShopType.TIKISHOP);
        System.out.println(shop2.getShopName());
    }
}

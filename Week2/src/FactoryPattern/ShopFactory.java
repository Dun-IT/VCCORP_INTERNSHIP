package FactoryPattern;

public class ShopFactory {
    private ShopFactory() {
    }
    public static final Shop getShop(ShopType shopType) {
        switch (shopType) {
            case TIKISHOP:
                return new TikiShop();
            case LAZADASHOP:
                return new LazadaShop();
            default:
                return null;
        }
    }
}

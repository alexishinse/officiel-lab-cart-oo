package ca.ulaval.glo4002.cart.domain.shop;

public class FragileShopItem extends ShopItem {

    private static final int SHIPPING_PRICE_PER_KG = 3;
    private static final int EXTRA_FRAGILE_SHIPPING_PRICE = 5;

    public FragileShopItem(String itemSku, String name, int price, int weight, double profitMarginPercentage,
                         boolean available) {
        super(itemSku, name, price, weight, profitMarginPercentage, available);
    }

    @Override
    public int getItemPriceWithShipping() {
        return price + getShippingCost();
    }

    private int getShippingCost() {
        return (weight * SHIPPING_PRICE_PER_KG) + EXTRA_FRAGILE_SHIPPING_PRICE;
    }
}

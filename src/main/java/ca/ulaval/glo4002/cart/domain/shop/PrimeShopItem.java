package ca.ulaval.glo4002.cart.domain.shop;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PrimeShopItem extends ShopItem {

    public PrimeShopItem(String itemSku, String name, int price, int weight, double profitMarginPercentage,
            boolean available) {
            super(itemSku, name, price, weight, profitMarginPercentage, available);
    }

    @Override
    public int getItemPriceWithShipping() {
        return price;
    }
}

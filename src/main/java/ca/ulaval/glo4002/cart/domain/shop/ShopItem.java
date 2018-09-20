package ca.ulaval.glo4002.cart.domain.shop;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlSeeAlso({StandardShopItem.class, PrimeShopItem.class})
public abstract class ShopItem {

    @XmlElement
    @JsonProperty
    private String itemSku;

    @XmlElement
    @JsonProperty
    private String name;

    @XmlElement
    @JsonProperty
    private boolean available;

    @XmlElement
    @JsonProperty
    protected int price;

    @XmlElement
    @JsonProperty
    protected int weight;

    @XmlElement
    @JsonProperty
    // Ne pas enlever @JsonProperty, ceci sert pour le panneau d'admin où on saisit les items
    private double profitMarginPercentage;

    private ShopItem() {
        // JAXB
    }

    public ShopItem(String itemSku, String name, int price, int weight, double profitMarginPercentage,
                           boolean available) {
        this.itemSku = itemSku;
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.profitMarginPercentage = profitMarginPercentage;
        this.available = available;
    }

    public abstract int getItemPriceWithShipping();

    public String getName() {
        return name;
    }

    public boolean isAvailable() {
        return available;
    }

    public boolean hasSku(String sku) {
        return this.itemSku.equals(sku);
    }


}

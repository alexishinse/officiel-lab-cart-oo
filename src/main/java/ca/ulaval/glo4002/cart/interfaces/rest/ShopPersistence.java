package ca.ulaval.glo4002.cart.interfaces.rest;

import ca.ulaval.glo4002.cart.domain.shop.ShopItem;

import java.util.List;


public abstract class ShopPersistence {
    public abstract List<ShopItem> GetShops();

    public abstract void PersistShops(List<ShopItem> items);
}

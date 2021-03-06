package ca.ulaval.glo4002.cart.application.shop;

import ca.ulaval.glo4002.cart.domain.shop.ShopItem;
import ca.ulaval.glo4002.cart.interfaces.rest.ShopPersistence;

import java.util.ArrayList;
import java.util.List;

public class ShopMemory extends ShopPersistence {
    private List<ShopItem> shopsInMemory;

    public ShopMemory() {
        shopsInMemory = new ArrayList<ShopItem>();
    }

    public List<ShopItem> GetShops() {
        return shopsInMemory;
    }

    public void PersistShops(List<ShopItem> items) {
        shopsInMemory = items;
    }

}

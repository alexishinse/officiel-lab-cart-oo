package ca.ulaval.glo4002.cart.interfaces.rest;

import ca.ulaval.glo4002.cart.application.cart.CartMemory;
import ca.ulaval.glo4002.cart.application.cart.CartRepository;
import ca.ulaval.glo4002.cart.application.shop.ShopMemory;
import ca.ulaval.glo4002.cart.application.shop.ShopRepository;


public class PersistenceProvider {
    public static CartPersistence getCartRepository() {
        if (System.getProperty("store").equalsIgnoreCase("xml")) {
            return new CartRepository();
        } else {
            return new CartMemory();
        }
    }

    public static ShopPersistence getShopRepository() {
        if (System.getProperty("store").equalsIgnoreCase("xml")) {
            return new ShopRepository();
        } else {
            return new ShopMemory();
        }
    }
}

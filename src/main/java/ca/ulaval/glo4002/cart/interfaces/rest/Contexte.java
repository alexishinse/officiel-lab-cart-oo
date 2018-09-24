package ca.ulaval.glo4002.cart.interfaces.rest;

import ca.ulaval.glo4002.cart.application.cart.CartApplicationService;
import ca.ulaval.glo4002.cart.application.shop.ShopApplicationService;


public class Contexte {

    private boolean isAppInDemoMode = false;

    public Contexte() {
        InitializeDemoIndicator();
    }

    public CartResource CreateCartResource() {
        CartPersistence cartPersistence = PersistenceProvider.getCartRepository();
        ShopPersistence shopPersistence = PersistenceProvider.getShopRepository();
        CartApplicationService cartService = new CartApplicationService(cartPersistence);
        ShopApplicationService shopService = new ShopApplicationService(shopPersistence, isAppInDemoMode);
        return new CartResource(cartService, shopService);
    }

    public ShopResource CreateShopResource() {
        ShopPersistence shopPersistence = PersistenceProvider.getShopRepository();
        ShopApplicationService shopService = new ShopApplicationService(shopPersistence, isAppInDemoMode);
        return new ShopResource(shopService);
    }

    private void InitializeDemoIndicator() {
        isAppInDemoMode = System.getProperty("mode").equalsIgnoreCase("demo");
    }

}

package ca.ulaval.glo4002.cart.application.shop;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import ca.ulaval.glo4002.cart.domain.shop.PrimeShopItem;
import ca.ulaval.glo4002.cart.domain.shop.ShopItem;
import ca.ulaval.glo4002.cart.domain.shop.StandardShopItem;
import ca.ulaval.glo4002.cart.interfaces.rest.PersistenceProvider;
import ca.ulaval.glo4002.cart.interfaces.rest.ShopPersistence;


public class ShopApplicationService {
    private final ShopPersistence shopRepository;
    private final boolean isInDemoMode;

    public ShopApplicationService(ShopPersistence _persistence, boolean _isInDemoMode) {
        this.shopRepository = _persistence;
        this.isInDemoMode = _isInDemoMode;
    }

    public List<ShopItem> listAvailableItems() {
        List<ShopItem> items = shopRepository.GetShops();
        if (items.isEmpty() && isInDemoMode) {
            Logger.getGlobal().info("Prefilling data in the shop for the demo");
            prefillDemoData();
            items = shopRepository.GetShops();
        }

        return items.stream().filter(ShopItem::isAvailable).collect(Collectors.toList());
    }

    public ShopItem findItemBySku(String sku) {
        return listAvailableItems().stream()
                .filter(x -> x.hasSku(sku))
                .findFirst()
                .orElseThrow(ItemNotFoundException::new);
    }

    private void prefillDemoData() {
        addItem(new StandardShopItem("1251521", "Peanuts", 5, 1, 1.20, true));
        addItem(new PrimeShopItem("236637", "Clean Code", 35, 2, 0.50, false));
        addItem(new StandardShopItem("235265", "Détendeur Mares Abyss Navy 22", 999, 5, 0.15, true));
        addItem(new StandardShopItem("276101", "Imprimante 3D", 2341, 31, 0.60, true));
        addItem(new PrimeShopItem("818113", "GoPro", 650, 1, 4.60, true));
        addItem(new StandardShopItem("51-153", "Peinture à numéro", 1, 2, 1.40, true));
    }

    private void addItem(ShopItem item) {
        List<ShopItem> items = shopRepository.GetShops();
        items.add(item);

        shopRepository.PersistShops(items);
    }
}

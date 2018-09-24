package ca.ulaval.glo4002.cart.application.cart;

import ca.ulaval.glo4002.cart.domain.cart.Cart;
import ca.ulaval.glo4002.cart.interfaces.rest.CartPersistence;

import java.util.ArrayList;
import java.util.List;


public class CartMemory extends CartPersistence {

    private ArrayList<Cart> cartsInMemory;

    public CartMemory() {
        cartsInMemory = new ArrayList<Cart>();
    }

    public List<Cart> GetCarts() {
        return cartsInMemory;
    }

    public void CreateCarts(List<Cart> carts) {
        cartsInMemory.addAll(carts);
    }

}

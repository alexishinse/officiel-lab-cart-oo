package ca.ulaval.glo4002.cart.interfaces.rest;

import ca.ulaval.glo4002.cart.domain.cart.Cart;

import java.util.List;


public abstract class CartPersistence {

     public abstract List<Cart> GetCarts();

     public abstract void PersistCarts(List<Cart> carts);
}

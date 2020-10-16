package edu.miu.e_mart.util;


import javax.servlet.http.HttpServletRequest;

import edu.miu.e_mart.domain.ShoppingCart;

public class Util {

    /**
     * This is a helper method to add a cart to session and to return new shopping cart
     * If the cart is not in session otherwise it will return a cart from session
     * @param request  the http request to put shopping cart to session
     * @return a new shopping cart if the cart is in session otherwise the cart from session.
     */
    public static ShoppingCart getCartInSession(HttpServletRequest request) {

        // Get Cart from Session.
        ShoppingCart shoppingCart = (ShoppingCart) request.getSession().getAttribute("aShoppingCart");

        // If null, create it.
        if (shoppingCart == null) {
            shoppingCart = new ShoppingCart();

            // And store to Session.
            request.getSession().setAttribute("aShoppingCart", shoppingCart);
        }

        return shoppingCart;
    }

    /**
     * It will remove a cart from session
     * @param request the http request
     *
     */
    public static void removeCartInSession(HttpServletRequest request) {
        request.getSession().removeAttribute("aShoppingCart");
    }


}

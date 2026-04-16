package edu.pe.cibertec.saucedemo.ui;

public class CarritoPage {

    public static String addButton(String nombreProducto){
        String formatted = nombreProducto.toLowerCase().replace(" ","-");
        return "[data-test='add-to-cart-" + formatted + "']";
    };

    public static String removeButton(String nombreProducto){
        String formatted = nombreProducto.toLowerCase().replace(" ","-");
        return "[data-test='remove-" + formatted + "']";
    };

    public static String CART_LINK = "[data-test='shopping-cart-link']";
    public static String CART_BADGE = "[data-test='shopping-cart-badge']";

    public static String CART_ITEMS = "[data-test='inventory-item-name']";
}

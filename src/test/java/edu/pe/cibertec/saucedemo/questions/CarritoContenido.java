package edu.pe.cibertec.saucedemo.questions;

import edu.pe.cibertec.saucedemo.ui.CarritoPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.playwright.Target;
import net.serenitybdd.screenplay.playwright.questions.Text;


import java.util.List;

public class CarritoContenido {

    public static Question<List<String>> productos() {
        return Text.ofEach(CarritoPage.CART_ITEMS);
    }
}

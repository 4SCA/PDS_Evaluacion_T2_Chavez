package edu.pe.cibertec.saucedemo.questions;

import edu.pe.cibertec.saucedemo.ui.CarritoPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.playwright.Target;
import net.serenitybdd.screenplay.playwright.questions.Text;

public class CarritoCantidad {

    public static Question<String> value(){
        return Text.of(Target.the("Cart badge").locatedBy(CarritoPage.CART_BADGE));
    }
}

package edu.pe.cibertec.saucedemo.questions;

import edu.pe.cibertec.saucedemo.ui.CheckoutPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.playwright.Target;
import net.serenitybdd.screenplay.playwright.questions.Visibility;

public class FormularioVisible {

    public static Question<Boolean> formularioVisible(){
        return Visibility.of(Target.the("First name input").locatedBy(CheckoutPage.FIRST_NAME));
    }
}

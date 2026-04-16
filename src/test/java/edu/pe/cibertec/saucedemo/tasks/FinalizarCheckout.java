package edu.pe.cibertec.saucedemo.tasks;

import edu.pe.cibertec.saucedemo.ui.CheckoutPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.playwright.interactions.Click;

public class FinalizarCheckout {
    public static Performable finalizarCheckout(){
        return Task.where("{0} finishes checkout",
                Click.on(CheckoutPage.FINISH_BUTTON));
    }
}

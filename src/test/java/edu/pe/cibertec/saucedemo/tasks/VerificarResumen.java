package edu.pe.cibertec.saucedemo.tasks;

import edu.pe.cibertec.saucedemo.ui.CheckoutPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.playwright.questions.Text;
import net.serenitybdd.screenplay.questions.Presence;

public class VerificarResumen {
    public static Performable itemTotal(String totalEsperado){
        return Task.where("{0} verifies order summary", actor -> {
            String actual = Text.of(String.valueOf(CheckoutPage.ITEM_TOTAL_SUMMARY)).answeredBy(actor);

            actual = actual.replace("Item total: ", "").trim();

            if (!actual.equals(totalEsperado)){
                throw new AssertionError("Expected: " + totalEsperado + " but was: " + actual);
            }
        });
    }

    public static Performable mensajeConfirmacion(String mensaje){
        return Task.where("{0} verifies confirmation message",

                actor -> {
                    String actual = Text.of(String.valueOf(CheckoutPage.CONFIRMATION_MESSAGE))
                            .answeredBy(actor);

                    actual = actual.trim();

                    if (!actual.equals(mensaje)) {
                        throw new AssertionError(
                                "Expected: " + mensaje + " but was: " + actual
                        );
                    }
                }
        );
    }

}

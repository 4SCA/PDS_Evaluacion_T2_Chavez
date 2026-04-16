package edu.pe.cibertec.saucedemo.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import com.microsoft.playwright.Page;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class VerificarSesion {
    public static Performable tiempoDeCargaMayor(int tiempoEsperado){
        return Task.where("{0} verifies load time", actor -> {
            Page page = actor.abilityTo(net.serenitybdd.screenplay.playwright.abilities.BrowseTheWebWithPlaywright.class).getCurrentPage();

            long inicio = System.currentTimeMillis();

            page.waitForURL("**/inventory.html");

            assertThat(page.locator(".title")).containsText("Products");

            long fin = System.currentTimeMillis();

            long total = fin - inicio;

            if (total <= tiempoEsperado){
                throw new AssertionError("Expected > " + tiempoEsperado + "ms but was " + total + "ms");
            }
        });
    }
}

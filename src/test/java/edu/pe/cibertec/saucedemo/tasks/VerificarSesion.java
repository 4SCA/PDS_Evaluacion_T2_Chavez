package edu.pe.cibertec.saucedemo.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import com.microsoft.playwright.Page;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.playwright.abilities.BrowseTheWebWithPlaywright;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class VerificarSesion {
    private static Page page(){
        return BrowseTheWebWithPlaywright.as(OnStage.theActorInTheSpotlight()).getCurrentPage();
    }

    public static void inventoryListVisible(){
        assertThat(page().locator(".inventory_list")).isVisible();
    }

    public static void titulo(String tituloEsperado){
        assertThat(page().locator("[data-test='title']")).containsText(tituloEsperado);
    }

    public static void sesionActiva(){
        assertThat(page().locator(".shopping_cart_link")).isVisible();
    }

    public static void irAlCarrito() {
        page().locator(".shopping_cart_link").click();
    }

    public static void volverAlInventario() {
        page().locator("#continue-shopping").click();
    }

}

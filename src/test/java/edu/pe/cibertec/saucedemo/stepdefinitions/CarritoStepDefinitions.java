package edu.pe.cibertec.saucedemo.stepdefinitions;

import edu.pe.cibertec.saucedemo.questions.CarritoCantidad;
import edu.pe.cibertec.saucedemo.questions.CarritoContenido;
import edu.pe.cibertec.saucedemo.tasks.AgregarAlCarrito;
import edu.pe.cibertec.saucedemo.tasks.EliminarDelCarrito;
import edu.pe.cibertec.saucedemo.ui.CarritoPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.playwright.interactions.Click;

public class CarritoStepDefinitions {

    @And("she adds the product {string} to the cart")
    public void sheAddsProductToCart(String nombreProducto){
        OnStage.theActorInTheSpotlight().attemptsTo(
                AgregarAlCarrito.producto(nombreProducto)
        );
    }

    @Then("the cart icon should display {string}")
    public void theCartIconShouldDisplay(String cantidad) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(CarritoCantidad.value(), equalTo(cantidad))
        );
    }

    @And("the cart should contain {string} and {string}")
    public void theCartShouldContainProducts(String producto1, String producto2) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(CarritoPage.CART_LINK)
        );
        OnStage.theActorInTheSpotlight().should(seeThat(CarritoContenido.productos(), hasItems(producto1, producto2))
        );
    }

    @And("she removes the product {string} from the cart")
    public void sheRemovesTheProductFromTheCart(String productName) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                EliminarDelCarrito.producto(productName)
        );
    }

    @And("the cart should only contain {string}")
    public void theCartShouldOnlyContain(String product) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(CarritoContenido.productos(), hasItem(product))
        );
    }
}

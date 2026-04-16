package edu.pe.cibertec.saucedemo.stepdefinitions;

import edu.pe.cibertec.saucedemo.questions.FormularioVisible;
import edu.pe.cibertec.saucedemo.tasks.FinalizarCheckout;
import edu.pe.cibertec.saucedemo.tasks.VerificarResumen;
import edu.pe.cibertec.saucedemo.tasks.CompletarCheckout;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actors.OnStage;
import static org.hamcrest.Matchers.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class CheckoutStepDefinitions {

    @And("she proceeds to checkout with first name {string}, last name {string} and postal code {string}")
    public void sheProceedsToCheckout(String firstName, String lastName, String postalCode) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                CompletarCheckout.datosUsuario(firstName, lastName, postalCode)
        );
    }

    @And("she verifies the order summary shows item total {string}")
    public void sheVerifiesOrderSummary(String total) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                VerificarResumen.itemTotal(total)
        );
    }

    @And("she completes the order")
    public void sheCompletesTheOrder() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                FinalizarCheckout.finalizarCheckout()
        );
    }

    @Then("she should see the confirmation message {string}")
    public void sheShouldSeeConfirmation(String message) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                VerificarResumen.mensajeConfirmacion(message));
    }

    @And("the checkout form should remain visible")
    public void checkoutFormVisible() {
        OnStage.theActorInTheSpotlight().should(seeThat(FormularioVisible.formularioVisible())
        );

    }
}

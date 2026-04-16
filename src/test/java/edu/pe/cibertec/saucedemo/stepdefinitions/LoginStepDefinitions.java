package edu.pe.cibertec.saucedemo.stepdefinitions;

import com.microsoft.playwright.Page;
import edu.pe.cibertec.saucedemo.questions.TheErrorMessage;
import edu.pe.cibertec.saucedemo.questions.ThePageTitle;
import edu.pe.cibertec.saucedemo.tasks.LoginAs;
import edu.pe.cibertec.saucedemo.tasks.OpenTheLoginPage;
import edu.pe.cibertec.saucedemo.tasks.VerificarSesion;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.playwright.abilities.BrowseTheWebWithPlaywright;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;

public class LoginStepDefinitions {
    private long startTime;
    private long duration;

    @Given("{word} is on the SauceDemo login page")
    public void openLoginPage(String actorName) {
        Actor actor = OnStage.theActorCalled(actorName);
        actor.whoCan(BrowseTheWebWithPlaywright.usingTheDefaultConfiguration());
        actor.attemptsTo(OpenTheLoginPage.page());
    }

    @When("she logs in with username {string} and password {string}")
    public void loginWith(String username, String password) {
        startTime = System.currentTimeMillis();
        OnStage.theActorInTheSpotlight().attemptsTo(
                LoginAs.user(username).withPassword(password)
        );
        duration = System.currentTimeMillis() - startTime;
    }

    @Then("she should be redirect to the inventory page")
    public void shouldBeRedirectedToInventoryPage() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ThePageTitle.displayed(), equalTo("Products"))
        );
    }

    @Then("she should see the page title {string}")
    public void shouldSeeThePageTitle(String pageTitle) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ThePageTitle.displayed(), equalTo(pageTitle))
        );
    }

    @Then("she should see the error message {string}")
    public void shouldSeeTheErrorMessage(String errorMessage) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(TheErrorMessage.displayed(), equalTo(errorMessage))
        );
    }

    @Then("she should remain on the login page")
    public void shouldRemainOnTheLoginPage() {
        Page page = OnStage.theActorInTheSpotlight().abilityTo(BrowseTheWebWithPlaywright.class).getCurrentPage();

        assertThat(page.locator("#login-button")).isVisible();
    }

    @Then("the page load time should be greater than 3000 milliseconds")
    public void validarTiempo() {
        org.junit.Assert.assertTrue("Tiempo insuficinte: " + duration, duration > 3000);
    }

    @When("she navigates to the cart page")
    public void irAlCarrito() {
        VerificarSesion.irAlCarrito();
    }

    @When("she navigates back to the inventory page")
    public void volverAlInventario() {
        VerificarSesion.volverAlInventario();
        VerificarSesion.inventoryListVisible();
    }

    @Then("she should still be logged in")
    public void sesionActiva() {
        VerificarSesion.sesionActiva();
    }
}

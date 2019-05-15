package fligths.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import fligths.pages.HomePage;
import fligths.utils.TestContext;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePageSteps {
    private HomePage homePage;
    private TestContext testContext;
    private WebDriver driver;

    public HomePageSteps(TestContext testContext){
        this.testContext = testContext;
        driver = this.testContext.getWebDriverManager().getDriver();
        homePage = new HomePage(driver);
    }

    @Then("^navego a la pagina de inicio$")
    public void navegarALogin() {
        homePage.navegarAInicio();
    }

    @Then("^verifico que estoy en la pagina de inicio$")
    public void verificoQueEstoyEnLaPaginaDeInicio() {
        Assert.assertTrue(homePage.verificarTitulo(),
                "la pagina actual no es la esperada");
    }

    @Then("^completo los datos de mi reserva \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" y \"([^\"]*)\"$")
    public void completoLosDatosDeMiReservaY(String desde, String a, String salida, String regreso, String clase, int pasajeros) {
        homePage.buscarVuelo(desde, a, salida, regreso, clase, pasajeros);
    }

    @And("^presiono boton buscar$")
    public void presionoBotonBuscar() {
        homePage.buscar();
    }
}

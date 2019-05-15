package fligths.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import fligths.pages.PagoPage;
import fligths.utils.TestContext;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PagoPageSteps {
    private PagoPage pagoPage;
    private TestContext testContext;
    private WebDriver driver;

    public PagoPageSteps(TestContext testContext){
        this.testContext = testContext;
        driver = this.testContext.getWebDriverManager().getDriver();
        pagoPage = new PagoPage(driver);
    }

    @Then("^verifico que estoy en la pagina de pago$")
    public void verificoQueEstoyEnLaPaginaDePago() {
        Assert.assertTrue(pagoPage.verificarTitulo(),
                "la pagina actual no es la esperada");
    }

    @Then("^introduzco los datos de mi tarjeta \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" y \"([^\"]*)\"$")
    public void introduzcoLosDatosDeMiTarjetaY(String tipo, String numero, String cvc, String mes, String year, String nombre,
                                               String apellido, String pais) {
        pagoPage.completarDatosTarjeta(tipo, numero, cvc, mes, year, nombre, apellido, pais);
    }

    @And("^presiono boton comprar$")
    public void presionoBotonComprar() {
        pagoPage.comprar();
    }
}
